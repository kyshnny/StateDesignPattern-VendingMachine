public class OutOfOrderState implements VendingMachineStates {
    private final VendingMachine machine;

    public OutOfOrderState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Machine is OutOfOrder. Operation not allowed.");
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Machine is OutOfOrder. Operation not allowed.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Machine is OutOfOrder. Operation not allowed.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is already OutOfOrder.");
    }
    
}