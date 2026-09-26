package ca.mcgill.ecse250.chapter10;

import java.util.Calendar;

public class MyDate {
    private static final int MILLS_PER_DAY = 86400000;

    private int year;
    private int month;
    private int day;

    public MyDate() {
        Calendar date = Calendar.getInstance();
        year = date.get(Calendar.YEAR) - 1900;
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(MyDate date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    public MyDate(long timeElapsedMillis) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timeElapsedMillis);
        year = date.get(Calendar.YEAR) - 1900;
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long timeElapsedMillis) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timeElapsedMillis);
        year = date.get(Calendar.YEAR) - 1900;
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DAY_OF_MONTH);
    }







}
