public class Purchase extends AllPurchase{

    public Purchase(String name,DayOfWeek day,Dollar price,int amount){
        this.name=name;
        this.day=day;
        this.price=price;
        this.amount=amount;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
