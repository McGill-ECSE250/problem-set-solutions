package ca.mcgill.ecse250.chapter09;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double getDiscriminant(){
        return b * b - 4 * a * c;
    }
    double getRoot1(){
        if(getDiscriminant() < 0){
            return 0;
        }
        return ( - b + Math.pow(getDiscriminant(), 0.5) ) / (2 * a);
    }
    //Additional challenge: can you find a way to reuse some of the code
    // by creating a helper used in Root1() and Root2()
    double getRoot2(){
        if(getDiscriminant() < 0){
            return 0;
        }
        return ( - b - Math.pow(getDiscriminant(), 0.5) ) / (2 * a);
    }
}
