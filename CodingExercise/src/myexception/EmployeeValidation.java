package myexception;

public class EmployeeValidation {
    public static void validateInput(Employee emp) throws InvalidUserDetailException{
        // 1. Name must not be less than 3 characters
        if(emp.getName().length()<3){
            throw new InvalidUserDetailException(
                    "Invalid Employee name "+emp.getName()
                            +". Must be at least 3 characters.");
        }

        // 2. Age must be b/w 18 - 65 years
        if(emp.getAge()<18 || emp.getAge()>65){
            throw new InvalidUserDetailException(
                    "Invalid Employee age. Must be between 18 - 65 years old.");
        }

        // 3. Gender must be either "male" or "female" (non-case sensitive)
        if(!(emp.getGender().equalsIgnoreCase("male")
                || emp.getGender().equalsIgnoreCase("female")) ){
            throw new InvalidUserDetailException(
                    "Invalid Employee gender. Only accepts either male or female"
            );
        }

        // All good --> print Details
        System.out.println("*** Employee Details ***");
        System.out.printf("Name=%s, Age=%d, Gender=%s\n"
        ,emp.getName(),emp.getAge(),emp.getGender());
    }
}
