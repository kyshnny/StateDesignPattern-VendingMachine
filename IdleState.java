public class IdleState implements VendingMachineStates {
    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String itemCode) {
        if (!machine.isInStock(itemCode)) {
            System.out.println("Item not available or out of stock.");
            return;
        }
        machine.setSelectedItemCode(itemCode);
        System.out.println("Item selected: " + itemCode);
        machine.setState(machine.itemSelectedState());
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Cannot insert coins in Idle. Please select an item first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Cannot dispense in Idle. Please select an item first.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Machine set to OutOfOrder.");
        machine.setState(machine.outOfOrderState());
    }
    
}