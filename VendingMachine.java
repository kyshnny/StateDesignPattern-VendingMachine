import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private final Map<String, Item> inventory = new HashMap<>();
    private int balance = 0;
    
    private String selectedItemCode = null;

    private final VendingMachineStates idleState;
    private final VendingMachineStates itemSelectedState;
    private final VendingMachineStates dispensingState;
    private final VendingMachineStates outOfOrderState;

    private VendingMachineStates currentState;


    public VendingMachine() {
        this.idleState = new IdleState(this);
        this.itemSelectedState = new ItemSelectedState(this);
        this.dispensingState = new DispensingState(this);
        this.outOfOrderState = new OutOfOrderState(this);
        this.currentState = idleState;
    }


    public void selectItem(String itemCode) { 
        currentState.selectItem(itemCode); 
    }

    public void insertCoin(int amount) { 
        currentState.insertCoin(amount); 
    }

    public void dispenseItem() { 
        currentState.dispenseItem(); 
    }

    public void setOutOfOrder() { 
        currentState.setOutOfOrder(); 
    }


    public void addItem(String code, String name, int price, int qty) {
        inventory.put(code, new Item(code, name, price, qty));
    }

    public Item getItem(String code) {
        return inventory.get(code);
    }

    public boolean isInStock(String code) {
        Item item = inventory.get(code);
        return item != null && item.getQuantity() > 0;
    }

    public void decrementStock(String code) {
        Item item = inventory.get(code);
        if (item != null) item.setQuantity(item.getQuantity() - 1);
    }

    
    public int getBalance() { 
        return balance; 
    }

    public void addBalance(int amount) {
        balance += amount; 
    }

    public void resetBalance() {
        balance = 0; 
    }

    
    public String getSelectedItemCode() {
        return selectedItemCode; 
    }

    public void setSelectedItemCode(String code) {
        selectedItemCode = code; 
    }

    public void clearSelection() { 
        selectedItemCode = null; 
    }

    
    public void setState(VendingMachineStates state) { 
        this.currentState = state; 
    }


    public VendingMachineStates idleState() {
        return idleState; 
    }

    public VendingMachineStates itemSelectedState() {
        return itemSelectedState; 
    }

    public VendingMachineStates dispensingState() { 
        return dispensingState; 
    }

    public VendingMachineStates outOfOrderState() { 
        return outOfOrderState; 
    }

}