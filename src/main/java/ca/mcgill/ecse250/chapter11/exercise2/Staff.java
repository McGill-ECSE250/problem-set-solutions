package ca.mcgill.ecse250.chapter11.exercise2;

import ca.mcgill.ecse250.chapter10.MyDate;

public class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress, String officeLocation, double salary, MyDate date, String title) {
        super(name, address, phoneNumber, emailAddress, officeLocation, salary, date);
        this.title = title;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " " + getClass();
    }
}
