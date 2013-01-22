package curso.demo06;

public class PerroChiuahuaTullido extends Perro{
    
    public  PerroChiuahuaTullido(String nombre) {
        super(nombre);
     //   System.out.println("Constructor PerroChiuahuaTullido - nombre");
    }
    
    @Override
    public String ladrar() {
    //    System.out.println("Ladrar PerroChiuahuaTullido");
        return "Grrrrr!";
    }

    @Override
    public int contarPatas() {
    //    System.out.println("ContarPatas PerroChiuahuaTullido");    
        return super.contarPatas() - 1;
    }
   
}
