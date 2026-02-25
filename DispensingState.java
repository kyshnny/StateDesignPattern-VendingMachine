public class DispensingState implements VendingMachineStates {
    private final VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    private void doDispense() {
        String code = machine.getSelectedItemCode();
        Item item = machine.getItem(code);

        if (code == null || item == null || item.getQuantity() <= 0) {
            System.out.println("Dispense failed. Returning to Idle.");
            machine.clearSelection();
            machine.resetBalance();
            machine.setState(machine.idleState());
            return;
        }

        machine.decrementStock(code);

        int change = machine.getBalance() - item.getPrice();
        System.out.println("Dispensing: " + item.getName() + " (Code: " + code + ")");
        if (change > 0) System.out.println("Returning change: " + change);

        machine.clearSelection();
        machine.resetBalance();

        System.out.println("Done dispensing. Returning to Idle.");
        machine.setState(machine.idleState());
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Dispensing... no operations allowed.");
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Dispensing... no operations allowed.");
    }

    @Override
    public void dispenseItem() {
        doDispense();
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Cannot change to OutOfOrder while dispensing.");
    }

}