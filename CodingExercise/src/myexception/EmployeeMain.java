package myexception;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(){
        Scanner sc = new Scanner(System.in);

        Employee e = new Employee();

        System.out.println("*** Input Employee Details ***");
        System.out.print("Name: ");
        e.setName(sc.nextLine()); // Read Name
        System.out.print("Age: ");
        e.setAge(sc.nextInt()); // Read Age
        sc.nextLine(); // Skip \n
        System.out.print("Gender: ");
        e.setGender(sc.nextLine()); // Read Gender

        try {
            EmployeeValidation.validateInput(e);
        }
        catch (InvalidUserDetailException ex){
            System.out.println(ex.getMessage());
        }
    }
}
