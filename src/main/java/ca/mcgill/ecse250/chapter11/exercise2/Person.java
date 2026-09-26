package ca.mcgill.ecse250.chapter11.exercise2;

public class Person {
    protected final String classType;
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this(name, address, phoneNumber, emailAddress, "Person");
    }

    protected Person(String name, String address, String phoneNumber, String emailAddress, String classType) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "name: " + name + ", class: " + classType;
    }

    protected String getName() {
        return name;
    }
}
