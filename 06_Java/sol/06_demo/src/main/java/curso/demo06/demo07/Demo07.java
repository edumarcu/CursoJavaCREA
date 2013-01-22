package curso.demo06.demo07;

public class Demo07 {

    public static void main(String[] args) throws InterruptedException {

        Logger[] loggers = new Logger[10];
        for (int i = 0; i< loggers.length; i++) {
            loggers[i] = new Logger(i);
        }

        loggers = null;

        System.gc();
        System.gc();
        System.gc();
        System.gc();

        Thread.sleep(5000);
    }

}

class Logger {

    int i;

    public Logger(int i) {
        this.i = i;
        System.out.println("Creando objeto " + i);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Liberando objeto " + i);
    }

}
