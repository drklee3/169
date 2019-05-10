import java.util.Date;

public class Fruit extends Food implements Comparable<Fruit> {
    protected Date ripe;

    public Fruit(Date r, String n) {
        this.ripe = r;
        this.name = n;
    }

    public void ripeTime() {
        System.out.println("You can eat it on " + this.ripe);
    }

    @Override
    public String toString() {
        return String.format("%-12s (%s)", this.name, this.ripe);
    }

    @Override
    public int compareTo(Fruit other) {
        return this.ripe.compareTo(other.ripe);
    }
}
