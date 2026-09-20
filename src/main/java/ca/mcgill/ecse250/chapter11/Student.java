package ca.mcgill.ecse250.chapter11;

public class Student extends Person {
    private final ClassStatus status;

    public Student(String name, String address, String phoneNumber, String emailAddress, ClassStatus status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "class: " + getClass();
    }
}
