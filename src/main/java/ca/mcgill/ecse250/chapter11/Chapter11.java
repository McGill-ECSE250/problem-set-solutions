package ca.mcgill.ecse250.chapter11;

import ca.mcgill.ecse250.chapter09.Account;
import ca.mcgill.ecse250.chapter10.MyDate;
import ca.mcgill.ecse250.chapter11.exercise2.*;
import ca.mcgill.ecse250.chapter11.exercise3.CheckingAccount;
import ca.mcgill.ecse250.chapter11.exercise3.SavingsAccount;
import ca.mcgill.ecse250.chapter11.exercise8.NewAccount;

public class Chapter11 {

    public static void main(String[] args) {
    }

    static void exercise_11_02() {
        Person p = new Person("Joe", "McGill University", "514-893-2845"/* RANDOM NUMBER */, "joe@gmail.com");
        Student s = new Student("Remi", "8341 boul St-laurent", "514-893-2845", "ybm@email.com", ClassStatus.junior);
        Faculty f = new Faculty("Professor", "89th Street", "514-514-5144", "professorOfFacultyOfEng@mcgill.ca", "somewhere in campus", 111, new MyDate(2022,11,3), "9am-11am", "Senior");
        Staff staff = new Staff("Mr Staff", "88th Street","438-438-4388", "staffOfMcgill@mcgill.ca", "88 McConnell", 60, new MyDate(2004, 12, 12), "Security");
        System.out.println(p);
        System.out.println(s);
        System.out.println(f);
        System.out.println(staff);


    }

    static void exercise_11_03() {
        Account account = new Account(10, 160007.5, 0.6);
        Account checkingAccount = new CheckingAccount(12, 1650007.5, 0.6, 3000.0);
        Account savingsAccount = new SavingsAccount(10, 160007.5, 0.6);
        System.out.println(account.toString());
        System.out.println(checkingAccount.toString());
        System.out.println(savingsAccount.toString());
        // System.out.print(object.toString()) behaves the same as System.out.print(object) if and only if object != null
        // the default toString() behavior from the Object class
        // is to prints the full class name with package + object's hashcode
        // if the object is null, System.out.print(object.toString()) will throw a NullPointerException,
        //                        System.out.print(object) will safely print null.
    }

    static void exercise_11_08() {
        NewAccount account = new NewAccount(1122, 1000, 1.5, "George");
        account.deposit(30, "deposited 30$");
        account.deposit(40, "deposited 40$");
        account.deposit(50, "deposited 50$");
        account.withdraw(5, "withdrawn 5$");
        account.withdraw(4, "withdrawn 4$");
        account.withdraw(3, "withdrawn 3$");
        System.out.println(account);

    }

}
