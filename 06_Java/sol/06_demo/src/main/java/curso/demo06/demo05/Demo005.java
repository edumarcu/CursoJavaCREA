package curso.demo06.demo05;

public class Demo005 {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneMe original = new CloneMe();
        CloneMe copy = (CloneMe) original.clone();

        System.out.println("-> " + original.foo);
        System.out.println("-> " + copy.foo);

        original.foo.y = 100;

        System.out.println("-> " + original.foo.y);
        System.out.println("-> " + copy.foo.y);
    }

}

class CloneMe implements Cloneable {

    public int x = 5;

    public DoNotCloneMe foo = new DoNotCloneMe();

    @Override
    public Object clone() throws CloneNotSupportedException {
        CloneMe copy = (CloneMe) super.clone();
        copy.foo = (DoNotCloneMe) this.foo.clone();
        return copy;
    }
}

class DoNotCloneMe implements Cloneable {

    public int y = 5;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}