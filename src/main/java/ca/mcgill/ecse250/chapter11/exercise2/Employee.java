package ca.mcgill.ecse250.chapter11.exercise2;

import ca.mcgill.ecse250.chapter10.MyDate;

public class Employee extends Person {
    private String officeLocation;
    private double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress, String officeLocation, double salary, MyDate date) {
        super(name, address, phoneNumber, emailAddress);
        this.officeLocation = officeLocation;
        this.salary = salary;
        this.dateHired = date;
    }
    @Override
    public String toString() {
        return "name: " + super.getName() + " class: " + getClass();
    }
}
