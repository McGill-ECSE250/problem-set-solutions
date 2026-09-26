package ca.mcgill.ecse250.chapter11.exercise2;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "name: " + name + " " + getClass();
    }

    protected String getName() {
        return name;
    }
}
