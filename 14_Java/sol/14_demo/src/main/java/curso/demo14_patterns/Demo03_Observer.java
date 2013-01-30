package curso.demo14_patterns;

import java.util.LinkedList;
import java.util.List;


public class Demo03_Observer {

    public static void main(String[] args) throws InterruptedException {

        Oven oven = new Oven();

        oven.startHeating();

        oven.registerObserver(new OvenObserver() {
            public void temperatureChanged(Oven oven) {
                if (oven.getTemperature() >= 200) {
                    ovenIsReady(oven);
                }
            }
        });

        oven.registerObserver(new OvenObserver() {
            public void temperatureChanged(Oven oven) {
                if (oven.getTemperature() > 100) {
                    oven.unregisterObserver(this);
                }
                System.out.println("El horno está a " + oven.getTemperature() + "ºC.");
            }
        });
    }

    public static void ovenIsReady(Oven oven) {
        oven.stopHeating();
        System.out.println("Putting the turkey inside the oven");
    }

}

interface OvenObserver {
    void temperatureChanged(Oven oven);
}

class Oven {

    private int temperature = 0;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private boolean heating = false;

    public void startHeating() {
        if (heating) {
            return;
        }

        Thread t = new Thread(new Runnable(){
            public void run() {
                heating = true;
                while (heating) {
                    setTemperature(getTemperature() + 10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {}
                }
            }
        });

        t.start();
    }

    public void stopHeating() {
        heating = false;
    }

    // Observable

    List<OvenObserver> observers = new LinkedList<OvenObserver>();

    public void registerObserver(OvenObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(OvenObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OvenObserver observer : observers) {
            observer.temperatureChanged(this);
        }
    }
}