public class Item {
    private final String code;
    private final String name;
    private final int price;
    private int quantity;

    public Item(String code, String name, int price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() { 
        return code; 
    }

    public String getName() { 
        return name; 
    }

    public int getPrice() { 
        return price; 
    }

    public int getQuantity() { 
        return quantity; 
    }

    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }
    
}