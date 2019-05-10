import java.util.Date;

public class Apple extends Fruit {
    public Apple(Date ripe) {
        super(ripe, "apple");
    }

    public void prepare() {
        System.out.println("Core the " + this.name);
    }
}
