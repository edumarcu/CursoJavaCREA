package curso.demo06;

public class PerroSanBernardo extends Perro {

    public PerroSanBernardo(String nombre) {
        super(nombre);
    }

    @Override
    public String ladrar() {
        return "Woof!";
    }

    public boolean tieneBarril() {
        return Math.random() > 0.5;
    }
}
