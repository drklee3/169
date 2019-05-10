public class Food {
    public String name;

    public Food() {
        this.name = "food";
    }

    public Food(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println("Prepare the " + this.name);
    }
}
