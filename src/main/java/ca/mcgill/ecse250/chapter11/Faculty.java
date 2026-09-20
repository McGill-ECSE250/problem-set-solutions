package ca.mcgill.ecse250.chapter11;

import ca.mcgill.ecse250.chapter10.MyDate;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String officeLocation, double salary, MyDate date, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, officeLocation, salary, date);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + "class: " + getClass();
    }

}
