public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addItem("A1", "Chips", 20, 5);
        vm.addItem("B2", "Soda", 30, 1);

        vm.insertCoin(10);           
        vm.selectItem("A1");         
        vm.selectItem("B2");         

        vm.insertCoin(10);
        vm.dispenseItem();           
        vm.insertCoin(15);
        vm.dispenseItem();           

        vm.setOutOfOrder();
        vm.selectItem("B2");
    }

}