package curso.demo06;

public class App {

    public static void main(String[] args) {
        Perro perro = new Perro("Thor");
        inspeccionarPerro(perro);

        perro = new PerroSanBernardo("Chiquitín");
        inspeccionarPerro(perro);

        perro = new PerroChiguaguaTullido("Destructor");
        inspeccionarPerro(perro);
    }

    public static void inspeccionarPerro(Perro perro) {
        System.out.printf("%s tiene %d patas y hace %s \n"
                , perro.getNombre()
                , perro.contarPatas()
                , perro.ladrar());
        
        if (perro instanceof PerroSanBernardo) {
            PerroSanBernardo sanbernardo = (PerroSanBernardo) perro;
            System.out.println("\tTiene Barril: " + sanbernardo.tieneBarril());
        }
    }
}
