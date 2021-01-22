import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    Item item1 = new Item("Kit kat",2.99,"1Ad3f");
    Item item2 = new Item("Chips",3.99, "2gre5");
    @BeforeEach
    public void setUp(){
        vendingMachine = new VendingMachine();
    }


    @Test
    @Order(1)
    public void items_isEmpty(){

        assertTrue(vendingMachine.isEmpty());
    }

    @Test
    @Order(2)
    public void add_item(){
        //given
        assertTrue(vendingMachine.isEmpty());

        //when
        vendingMachine.add(item1);
        vendingMachine.add(item2);

        //then
        List<Item> actualList = vendingMachine.displayItems();

        assertEquals(item1, actualList.get(0));
        assertEquals(item2, actualList.get(1));
        assertFalse(vendingMachine.isEmpty());
    }

    @Test
    @Order(3)
    public void checkBalance(){
            assertThat("greaterthanzero",vendingMachine.getBalance(), greaterThan(0.0));
            assertEquals(100.0, vendingMachine.getBalance());
    }

    @Test
    public void balance_withdraw(){
        vendingMachine.withdraw(10.0);
        assertEquals(90.0, vendingMachine.getBalance());

    }

    @Test
    public void balance_deposit(){
        vendingMachine.deposit(20.0);
        assertEquals(120.0, vendingMachine.getBalance());
    }

    @Test
    public void check_availableItems(){
        //given
        vendingMachine.add(item1);
        vendingMachine.add(item2);
        assertFalse(vendingMachine.isEmpty());

        //when
        List<Item> availableItemList = vendingMachine.displayItems();

        //then
        assertEquals(item1.getItemName(), availableItemList.get(0).getItemName());
        assertEquals(item1.getItemPrice(), availableItemList.get(0).getItemPrice());
        assertEquals(item1.getItemCode(), availableItemList.get(0).getItemCode());

    }

    @Test
    public void check_customer_balance(){
        vendingMachine.insertMoney(10.0);
        assertEquals(10.0, vendingMachine.getCustomerBalance());
    }

    @Test
    public void purchase_Item(){
        //Given
        double expectedBalance = vendingMachine.getBalance();
        vendingMachine.insertMoney(10.0);
        expectedBalance = expectedBalance +10.0;

        //when
        Item actualItem = vendingMachine.getItem(item1.getItemCode());
        vendingMachine.removeItem(actualItem);

        //then
        assertEquals(expectedBalance, vendingMachine.getBalance());
        Item actual = vendingMachine.getItem(item1.getItemCode());
        assertEquals(null, actual );

    }

    @Test
    public void non_existing_item(){
        //given
        vendingMachine.insertMoney(20.0);

        //when
        try {
            vendingMachine.getItem("fte2d");
            fail();
        }catch(Exception ex){
            assertEquals("No such Item", ex.getMessage());
        }



    }

    @Test
    public void insufficientFund(){
        //Given
        vendingMachine.insertMoney(1.00);

        //when
       /// vendingMachine.isSufficientFund(item1.getItemCode());


    }


}
