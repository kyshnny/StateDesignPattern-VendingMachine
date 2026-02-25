public interface VendingMachineStates {
    void selectItem(String itemCode);
    void insertCoin(int amount);
    void dispenseItem();
    void setOutOfOrder();
}