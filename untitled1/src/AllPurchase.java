public class AllPurchase {
    String name;
    DayOfWeek day;
    Dollar price;
    int amount;

    public AllPurchase(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Dollar getPrice() {
        return price;
    }

    public void setPrice(Dollar price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AllPurchase{" +
                "name='" + name + '\'' +
                ", day=" + day +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
