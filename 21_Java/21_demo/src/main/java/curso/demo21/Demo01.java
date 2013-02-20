package curso.demo21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) throws SQLException {

        System.out.print("Conecting to MySQL - test DB...");

        Connection conn = connectToDB("com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1/test", "root", "password");

        if (conn != null) {
            System.out.println("OK!");
        } else {
            System.out.println("KO!");
            return;
        }
        System.out.println();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name FROM user;");

        System.out.println("Query Results:");
        showQueryResults(rs);

    }

    public static void showQueryResults(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        int nCol = metaData.getColumnCount();
        for (int i = 1; i <= nCol; i++) {
            String columnName = metaData.getColumnLabel(i);
            System.out.print(columnName + "\t");
        }
        System.out.println();
        for (int i = 1; i <= nCol; i++) {
            String columnName = metaData.getColumnLabel(i);
            for (int j = 0; j < columnName.length(); j++) {
                System.out.print('-');
            }
            System.out.print("----");
        }
        System.out.println();

        while (rs.next()) {
            for (int j = 1; j <= nCol; j++) {
                String nombreColumna = metaData.getColumnLabel(j);
                String tipoColumna = metaData.getColumnTypeName(j);
//                System.out.println(" COLUMNA, nombre: " + nombreColumna
//                    + " tipo: " + tipoColumna);

                if(tipoColumna.contains("VARCHAR")){
                    String res = rs.getString(nombreColumna);
                    System.out.print(res + "\t");
                } else if (tipoColumna.contains("INT")){
                    int res = rs.getInt(nombreColumna);
                    System.out.print(res + "\t");
                }
            }
            System.out.println();
        }
    }

    public static Connection connectToDB(String classForName, String url,
            String user, String pass) {

        /**
         * a partir de Java 6 nno hace falta hacer esto
         */
        try {
           Class.forName(classForName);
        } catch (Exception e) {
            System.err.println("Exception loading class Driver: " + e);
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Exception getting connection: " + e);
        }

        return conn;
    }
}
