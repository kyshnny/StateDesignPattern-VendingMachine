public class ItemSelectedState implements VendingMachineStates {
    private final VendingMachine machine;

    public ItemSelectedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Item already selected. Cannot select another item.");
    }

    @Override
    public void insertCoin(int amount) {
        if (amount <= 0) {
            System.out.println("Insert a valid positive coin amount.");
            return;
        }
        machine.addBalance(amount);
        System.out.println("Inserted: " + amount + ". Balance: " + machine.getBalance());
    }

    @Override
    public void dispenseItem() {
        String code = machine.getSelectedItemCode();
        if (code == null) {
            System.out.println("No item selected.");
            machine.setState(machine.idleState());
            return;
        }

        Item item = machine.getItem(code);
        if (item == null || item.getQuantity() <= 0) {
            System.out.println("Selected item is unavailable now.");
            machine.clearSelection();
            machine.resetBalance();
            machine.setState(machine.idleState());
            return;
        }

        if (machine.getBalance() < item.getPrice()) {
            System.out.println("Insufficient balance. Price: " + item.getPrice()
                    + ", Current balance: " + machine.getBalance());
            return;
        }

        machine.setState(machine.dispensingState());
        machine.dispenseItem(); 
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Machine set to OutOfOrder.");
        machine.setState(machine.outOfOrderState());
    }

}