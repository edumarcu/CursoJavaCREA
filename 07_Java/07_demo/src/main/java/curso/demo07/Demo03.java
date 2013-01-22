package curso.demo07;

public class Demo03 {
    
    public static final int NUMBER = 3; // es una constante
    
    public static final Point POINT = new Point(7,9);
    public static final PointInmutable POINTINMUTABLE = new PointInmutable(2,4);
    
    public static void main(String[] args) {
        System.out.println("NUMBER = " + NUMBER);
        
        final int i = 5;
        //i = 7;
        System.out.println("i = " + i);
        System.out.println();
        
        final int j;
        if (Math.random() > 0.5) {
            j = 0;
        }
        else {
            j = 1;
        }
       // j = 4; --> ya ha sido inicializada
        System.out.println("Point");
        System.out.println(POINT);
        POINT.x = 100; //--> se puede modificar los atributos, aunque la ref sea cte
        System.out.println(POINT);   
        System.out.println("");
        
        System.out.println("Point Inmutable");
        System.out.println(POINTINMUTABLE);
        //POINTINMUTABLE.x = 100;
       // System.out.println(POINTINMUTABLE); 
    }
    
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }
}

class PointInmutable {
    private final int x, y;

    public PointInmutable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }
}
