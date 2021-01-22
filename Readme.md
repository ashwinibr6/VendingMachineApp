As an administrator, I want to see what items are currently in the vending machine, so that I know what we have in stock.

Given there are no items in stock
When I check the vending machine
Then I should see it is empty
-------------------------------------------------
As an administrator, I want to add items to the vending machine, so that it never runs out of snacks.

Given there are no items in stock
When I add some items
Then I should see them in the vending machine
------------------------------------------------

As an administrator, I want to see how much money the vending machine has from item sales, so I know how we are doing financially.

Given there are some balance
When I check the balance of the vending machine
Then I should see the current balance

----------------------------------------------

As an administrator, I want to withdraw or deposit money from the vending machine

When I withdraw money from the vending machine
Then I should see the balance decrease

When I deposit money to the vending machine
Then I should see the balance increase

-------------------------------------------------------
As a customer, I want to see what is available, so that I can make a purchase.

Given there are items in stock
When I check what is available
Then I should see the name, price and code of the items