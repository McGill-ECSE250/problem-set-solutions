package ca.mcgill.ecse250.chapter11.exercise2;

import ca.mcgill.ecse250.chapter10.MyDate;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String officeLocation, double salary, MyDate date, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, officeLocation, salary, date, "Faculty");
        this.officeHours = officeHours;
        this.rank = rank;
    }

}
