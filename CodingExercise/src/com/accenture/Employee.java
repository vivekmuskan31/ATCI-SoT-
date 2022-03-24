package com.accenture;

public class Employee {
    private int Id;
    private String firstName;
    private String lastName;
    private String department;
    private String position;

    public Employee(){

    }

    public Employee(int id, String firstName, String lastName, String department, String position) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void printDetails(){
        System.out.println("{");
        System.out.println("\t \"Id\" \t\t\t : "+this.getId()+",");
        System.out.println("\t \"firstName\" \t : "+this.getFirstName()+",");
        System.out.println("\t \"lastName\" \t : "+this.getLastName()+",");
        System.out.println("\t \"department\" \t : "+this.getDepartment()+",");
        System.out.println("\t \"position\" \t : "+this.getPosition());
        System.out.println("}");
    }

    public static void main(){
        Employee e1 = new Employee();
        e1.setId(13436720);
        e1.setFirstName("Vivek");
        e1.setLastName("Muskan");
        e1.setDepartment("Software Engineering Department");
        e1.setPosition("Advance App Engineering Analyst");

        Employee e2 = new Employee(
                13436700,
                "Utkarsh",
                "Kumar",
                "Software Engineering Department",
                "Advance App Engineering Analyst"
        );

        System.out.println("Details of Employee 1");
        e1.printDetails();
        System.out.println("Details of Employee 2");
        e2.printDetails();
    }
}
