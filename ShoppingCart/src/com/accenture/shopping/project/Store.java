package com.accenture.shopping.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class Store {
    private Customer customer;
    private Cashier cashier;
    private List<Item> storeItems;

    public Store(Customer customer, Cashier cashier) {
        this.customer = customer;
        this.cashier = cashier;
    }

    public void showCart(){
        List<Item> items = customer.getCart().getItems();

        String divider = "--------------------------------------------------------------------";
        System.out.println(divider);
        System.out.println("Cart Items");
        System.out.println(divider);
        for(int i=0; i<items.size(); i++){
            Item it = items.get(i);
            System.out.printf("[%d] %-20s %.1f\n",i,it.getName(), it.getPrice());
        }
    }

    public void showStoreItems(){
        String divider = "--------------------------------------------------------------------";
        System.out.println("Store Items");
        System.out.println(divider);
        for(int i=0; i<storeItems.size(); i++){
            Item it = storeItems.get(i);
            System.out.printf("[%d] %-20s %.1f\n",i,it.getName(), it.getPrice());
        }
        System.out.println(divider);
        System.out.printf("[0] - [%d] to select items\n", storeItems.size()-1);
        System.out.print("Select item to add: ");
    }

    public int validateInput(Scanner scanner, int min, int max){
        int input = -1;
        boolean isValidInput = true;
        try {
            input = Integer.parseInt(scanner.next());
        }catch (Exception e){
            isValidInput = false;
        }finally {
            if((!isValidInput) || input<min || input>max ){
                System.out.println("Invalid input");
                return -1;
            }
        }
        return input;
    }

    public String generateReceipt(){
        StringBuilder sb = new StringBuilder();
        String divider = "--------------------------------------------------------------------\n";
        sb.append(divider);
        sb.append("                              RECEIPT                              \n");
        sb.append(divider);
        String startTime = String.format("%02d:%02d",cashier.getStartOfShift().getHour()
                        ,cashier.getStartOfShift().getMinute());
        String endTime = String.format("%02d:%02d",cashier.getEndOfShift().getHour()
                ,cashier.getEndOfShift().getMinute());
        String name = cashier.getName();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        sb.append(String.format("Cashier: %s\tShift: %s - %s\nDate: %s\n",name,startTime,endTime,date ));
        sb.append(divider);
        sb.append("Items:\n");
        String col1 = "Item name";
        String col2 = "Qty";
        String col3 = "Price";
        String col4 = "Total Price";
        sb.append(String.format("\t%-20s %-8s %-10s %s\n",col1, col2, col3, col4));
        List<Item> cart = customer.getCart().getItems();
        Map<Item, Integer> itemList = new HashMap<>();
        for(Item i:cart){
            itemList.putIfAbsent(i, 0);
            int qty = itemList.get(i)+1;
            itemList.put(i, qty);
        }
        for(Map.Entry<Item, Integer> i:itemList.entrySet()){
            String itemName = i.getKey().getName();
            double itemPrice = i.getKey().getPrice();
            int qty = i.getValue();
            sb.append(String.format("\t%-20s %-8d %-,10.1f %-,10.1f\n",itemName,qty,itemPrice,itemPrice*qty));
        }
        sb.append(divider);
        sb.append(String.format("TOTAL: %,.1f\n",customer.getCart().computeTotalPrice()));
        sb.append(divider);

        return sb.toString();

    }

    public void showPromptScreen(){
        String divider = "--------------------------------------------------------------------";
        System.out.println(divider);
        System.out.println("Press [1] Add item | [2] Remove item | [3] Checkout | [0] Exit ");
        System.out.println(divider);
    }

    public void shop(){
        Scanner scanner = new Scanner(System.in);
        readStoreItemsFromFile("C:\\Users\\vivek.muskan\\OneDrive - Accenture\\Desktop\\Coding Exercise SoT\\Java\\ShoppingCart\\src\\com\\accenture\\shopping\\project\\store-items.csv");
        int input = -1;

        do{
            showPromptScreen();
            input = validateInput(scanner, 0, 3);
            if(input!=-1) {
                if (input == 0) System.exit(0);
                else if (input == 1) {
                    showStoreItems();
                    int addItemId = validateInput(scanner, 0, storeItems.size() - 1);
                    if (addItemId != -1) {
                        ShoppingCart shoppingCart = customer.getCart();
                        shoppingCart.addItem(storeItems.get(addItemId));
                        showCart();
                    }
                } else if (input == 2) {
                    if (customer.getCart().getItems().isEmpty()) {
                        System.out.println("Cart is empty. No items to remove.");
                    } else {
                        showCart();
                        System.out.print("Select item to remove: ");
                        int itemIdToRemove = validateInput(scanner, 0, customer.getCart().getItems().size() - 1);
                        if (itemIdToRemove != -1) {
                            customer.getCart().getItems().remove(itemIdToRemove);
                            showCart();
                        }
                    }
                } else if (input == 3) {
                    if (customer.getCart().getItems().isEmpty()) {
                        System.out.println("Cart is Empty. No items to checkout.");
                    } else {
                        printReceipt();
                        saveReceiptToFile("C:\\Users\\vivek.muskan\\OneDrive - Accenture\\Desktop\\Coding Exercise SoT\\Java\\ShoppingCart\\src\\com\\accenture\\shopping\\project\\receipt.txt");
                    }
                    System.exit(0);
                }
            }
        }while (true);

    }

    public void readStoreItemsFromFile(String filename){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner.useDelimiter(",");
        storeItems = new ArrayList<>();
        try {
            while (scanner.hasNext()) {
                String[] row = scanner.nextLine().split(",");
                double price = Double.parseDouble(row[1]);
                storeItems.add(new Item(row[0], price));
            }
        }catch (Exception e){
            System.out.println("issue with csv reading....");
            e.printStackTrace();
        }
        scanner.close();
    }

    public void printReceipt(){
        System.out.println(generateReceipt());
    }

    public void saveReceiptToFile(String filename){
        try{
            FileWriter f = new FileWriter(filename);
            f.write(generateReceipt());
            f.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
