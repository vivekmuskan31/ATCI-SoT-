package mybank;

public class Account {
    private String accountType;
    private double balance = 0d;
    private Customer customer;

    public Account(Customer customer, String accountType) {
        this.customer = customer;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        System.out.printf("Depositing... %.2f\n",amount);
        this.balance += amount;
        System.out.println("SUCCESSFUL TRANSACTION\n");
    }

    public void withdraw(double amount){
        System.out.printf("Please wait while withdrawing amount: %.2f\n",amount);
        if(amount > this.getBalance()){
            System.out.println("TRANSACTION DENIED. Insufficient funds.\n");
        }
        else{
            this.balance -= amount;
            System.out.println("SUCCESSFUL TRANSACTION\n");
        }
    }

    public void display(){
        System.out.println("Customer Account Name: "
                + this.customer.getFirstName() + " "
                + this.customer.getLastName()
        );

        System.out.printf("%s Account Balance: %.2f\n"
                ,this.accountType
                ,this.getBalance()
        );
    }
}
