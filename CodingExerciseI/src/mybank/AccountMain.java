package mybank;

public class AccountMain {
    public static void main(int codingExerciseID){
        Customer myCustomer = new Customer("John", "Doe");

        if(codingExerciseID == 4) {
            Account savingsAcnt = new Savings(myCustomer, "Savings");
            savingsAcnt.deposit(1000d);
            savingsAcnt.withdraw(500d);
            savingsAcnt.display();

            System.out.println();

            Account checkingAcnt = new Checking(myCustomer, "Checking");
            checkingAcnt.deposit(500d);
            checkingAcnt.withdraw(600d);
            checkingAcnt.display();
        }

        if(codingExerciseID == 5) {
            Account privilegedAcnt = new Privileged(myCustomer,
                    "Privileged",
                    5000d
            );
            privilegedAcnt.deposit(1000d);
            privilegedAcnt.withdraw(2000d);
            privilegedAcnt.withdraw(4000d);
            privilegedAcnt.display();
        }
    }
}
