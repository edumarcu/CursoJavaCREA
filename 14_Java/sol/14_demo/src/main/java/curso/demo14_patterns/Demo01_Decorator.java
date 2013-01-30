package curso.demo14_patterns;

public class Demo01_Decorator {
    public static void main(String[] args) {
        IceCream strawberry = new StrawberryIceCream();
        IceCream chocolate = new ChocolateIceCream();
        IceCream icecream = new TwoBallIceCream(strawberry, chocolate);
        icecream = new BigIceCream(icecream);
        icecream = new ChocolateTopping(icecream);

        // From here I don't care wich IceCream I'm using.

        System.out.println("Flavor: " + icecream.flavor());
        System.out.printf("Price: %.2f\n", icecream.price());
    }
}

interface IceCream {
    String flavor();
    double price();
}

class ChocolateIceCream implements IceCream{

    public String flavor() {
        return "Chocolate";
    }

    public double price() {
        return 2.3;
    }

}

class StrawberryIceCream implements IceCream{

    public String flavor() {
        return "Strawberry";
    }

    public double price() {
        return 2.3;
    }

}

class BigIceCream implements IceCream {

    IceCream iceCream;

    public BigIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String flavor() {
        return iceCream.flavor() + " BIG";
    }

    public double price() {
        return iceCream.price() * 1.3;
    }
}

class TwoBallIceCream implements IceCream {

    IceCream iceCream1;
    IceCream iceCream2;

    public TwoBallIceCream(IceCream iceCream1, IceCream iceCream2) {
        this.iceCream1 = iceCream1;
        this.iceCream2 = iceCream2;
    }

    public String flavor() {
        return iceCream1.flavor() + " and " + iceCream2.flavor();
    }

    public double price() {
        return iceCream1.price() + iceCream2.price();
    }
}

class ChocolateTopping implements IceCream {

    IceCream iceCream;

    public ChocolateTopping(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String flavor() {
        return iceCream.flavor() + " with Chocolate Topping";
    }

    public double price() {
        return iceCream.price() + 0.30;
    }
}