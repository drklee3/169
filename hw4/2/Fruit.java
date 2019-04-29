import java.util.Date;

public class Fruit extends Food {
    protected Date ripe;

    public Fruit(Date r, String n) {
        this.ripe = r;
        this.name = n;
    }

    public void ripeTime() {
        System.out.println("You can eat it on " + this.ripe);
    }
}