public class PricePurchase extends AllPurchase{
    String name;
    DayOfWeek day;
    Dollar price;
    int amount;
    int discount;

    public PricePurchase(String name,DayOfWeek day,Dollar price, int amount, int discount) {
        this.name=name;
        this.day = day;
        this.price=price;
        this.amount=amount;
        this.discount=discount;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
