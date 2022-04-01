package mybank;

public class Privileged extends Account{
    private double overDraftLimit;

    public Privileged(Customer customer, String accountType, double overDraftLimit){
        super(customer, accountType);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void withdraw(double amount){
        System.out.printf("Please wait while withdrawing amount: %.2f\n",amount);
        if(amount > this.getBalance()){
            System.out.println("Amount requested is beyond limit... checking overdraft limit.");
            double limit = this.overDraftLimit;
            if(this.getBalance()>0) limit += getBalance();
            if(amount > limit){
                System.out.println("TRANSACTION DENIED. Overdraft limit exceeded.\n");
                return;
            }
            else{
                if(this.getBalance()>0) this.overDraftLimit -= (amount - this.getBalance());
                else this.overDraftLimit -= amount;
            }
        }
        this.setBalance(this.getBalance()-amount);
        System.out.println("SUCCESSFUL TRANSACTION\n");
    }

    @Override
    public void display(){
        super.display();
        System.out.printf("Overdraft Available Limit: %.2f\n", this.overDraftLimit);
    }
}
