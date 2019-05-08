import java.util.Date;

public class Orange extends Fruit {
    public Orange(Date ripe) {
        super(ripe, "orange");
    }

    public void prepare() {
        System.out.println("Peel the " + this.name);
    }
}