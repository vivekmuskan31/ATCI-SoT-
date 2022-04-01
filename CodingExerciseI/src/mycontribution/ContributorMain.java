package mycontribution;

public class ContributorMain {
    public static void main(){
        Contributor myContributor = new Contributor(
                "Vivek",
                "Muskan",
                23,
                10000d
        );
        System.out.printf("Salary: %.2f\n",myContributor.getSalary());

        Ordinary odAccount = new Ordinary(myContributor, "Ordinary");
        odAccount.displayContribution();

        Special spAccount = new Special(myContributor, "Special");
        spAccount.displayContribution();

        MediSave mediAccount = new MediSave(myContributor, "MediSave");
        mediAccount.displayContribution();
    }
}
