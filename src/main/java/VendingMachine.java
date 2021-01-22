import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Item> itemsList = new ArrayList<>();
    private double balance = 100.0;

    public boolean isEmpty() {
        return itemsList.isEmpty();
    }

    public void add(Item item) {
        itemsList.add(item);
    }

    public List<Item> displayItems() {
        return itemsList;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }
}
