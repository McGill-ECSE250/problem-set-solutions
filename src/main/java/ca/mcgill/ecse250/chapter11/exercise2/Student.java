package ca.mcgill.ecse250.chapter11.exercise2;

public class Student extends Person {
    // you can also use type String, you can think of an enum is just like that
    // but a pre-defined set of allowed String value
    private final ClassStatus status;

    public Student(String name, String address, String phoneNumber, String emailAddress, ClassStatus status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + " " + getClass();
    }
}
