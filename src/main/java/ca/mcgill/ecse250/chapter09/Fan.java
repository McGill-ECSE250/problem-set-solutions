package ca.mcgill.ecse250.chapter09;

public class Fan {
    private static final byte SLOW = 1;
    private static final byte MEDIUM = 2;
    private static final byte FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    @Override
    public String toString() {
        return on ? "Description of fan:" +
                "speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}'
                : "fan is off";
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isOn() {
        return on;
    }
}