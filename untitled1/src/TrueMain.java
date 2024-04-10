import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TrueMain {
    public static void main(String[] args) {
        ArrayList<String> text = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Minty/OneDrive/Desktop/ab.txt"));
            String line = reader.readLine();
            text.add(line);
            while (line != null) {
                line = reader.readLine();
                text.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] names;
        ArrayList<Purchase> purch = new ArrayList<>();
        ArrayList<PricePurchase> pricePurch = new ArrayList<>();
        for (int i = 0; i < text.size() - 1; i += 2) {
            names = text.get(i).split(";");
            if (names.length == 3) {
                purch.add(new Purchase(names[0], DayOfWeek.valueOf(text.get(i + 1)), new Dollar(Integer.parseInt(names[1]), 0), Integer.parseInt(names[2])));
            } else {
                pricePurch.add(new PricePurchase(names[0], DayOfWeek.valueOf(text.get(i + 1)), new Dollar(Integer.parseInt(names[1]), 0), Integer.parseInt(names[2]), Integer.parseInt(names[3])));
            }
        }

        HashMap<AllPurchase, DayOfWeek> purchases = new HashMap<>();

        for (int i = 0; i < purch.size(); i++) {
            purchases.put(purch.get(i), purch.get(i).getDay());
            purchases.put(pricePurch.get(i), pricePurch.get(i).getDay());
        }
        purchases.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println("---------------");
        HashMap<AllPurchase, DayOfWeek> lastPurchases = new HashMap<>();//dayOfWeek.ordinal()
        ArrayList<DayOfWeek> days = new ArrayList<>();
        days.add(0, DayOfWeek.MONDAY);
        days.add(1, DayOfWeek.TUESDAY);
        days.add(2, DayOfWeek.WEDNESDAY);
        days.add(3, DayOfWeek.THURSDAY);
        days.add(4, DayOfWeek.FRIDAY);
        days.add(5, DayOfWeek.SATURDAY);
        days.add(6, DayOfWeek.SUNDAY);
        for (Map.Entry<AllPurchase, DayOfWeek> item : purchases.entrySet()) {
            for (Map.Entry<AllPurchase, DayOfWeek> item2 : purchases.entrySet()) {
                if (item.getKey().getName().equals(item2.getKey().getName()) && item.getValue().ordinal() > item2.getValue().ordinal()) {
                    lastPurchases.put(item.getKey(), item.getValue());
                }

            }
        }
        lastPurchases.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println("---------------");

        HashMap<AllPurchase, DayOfWeek> firstPurchases = new HashMap<>();
        for (Map.Entry<AllPurchase, DayOfWeek> item : purchases.entrySet()) {
            for (Map.Entry<AllPurchase, DayOfWeek> item2 : purchases.entrySet()) {
                if (item.getKey().getName().equals(item2.getKey().getName()) && item.getValue().ordinal() < item2.getValue().ordinal()) {
                    firstPurchases.put(item.getKey(), item.getValue());
                }
            }
        }
        firstPurchases.forEach((k, v) -> System.out.println(k + "=" + v));
        for (Map.Entry<AllPurchase, DayOfWeek> item : firstPurchases.entrySet()) {
            if (item.getKey().getName().equals("bread") && item.getKey().getPrice().getDollar() == 155) {
                System.out.println("Первый день покупки хлеба за 155 - " + item.getValue());
            }
        }
        for (Map.Entry<AllPurchase, DayOfWeek> item : lastPurchases.entrySet()) {
            if (item.getKey().getName().equals("bread") && item.getKey().getPrice().getDollar() == 155) {
                System.out.println("Последний день покупки хлеба за 155 - " + item.getValue());
            }
        }
        HashMap<AllPurchase, DayOfWeek> deletedMeat = new HashMap<>();
        HashMap<AllPurchase, DayOfWeek> deletedFriday = new HashMap<>();
        for (Map.Entry<AllPurchase, DayOfWeek> item : lastPurchases.entrySet()) {
            if(!item.getKey().getName().equals("meat")){
                deletedMeat.put(item.getKey(),item.getValue());
            }
        }
        for (Map.Entry<AllPurchase, DayOfWeek> item : firstPurchases.entrySet()) {
            if(item.getValue()!=DayOfWeek.FRIDAY){
                deletedFriday.put(item.getKey(),item.getValue());
            }
        }
        System.out.println("--------------------------");
        deletedFriday.forEach((k, v) -> System.out.println(k.toString() + "=" + v));
        System.out.println("--------------------------");
        deletedMeat.forEach((k, v) -> System.out.println(k.toString() + "=" + v));
    }
}











