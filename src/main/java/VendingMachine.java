import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Item> itemsList = new ArrayList<>();
    private double balance = 100.0;
    private double customerBalance;

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

    public void insertMoney(double money) {
        this.customerBalance = money;
        this.balance += this.customerBalance;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public Item getItem(String itemCode)  {
        for(Item item : itemsList)
        {
            if(item.getItemCode().equals(itemCode))
                return item;
        }
        throw new RuntimeException("No such Item");
    }

    public void removeItem(Item actualItem) {
        itemsList.remove(actualItem);
    }
}
