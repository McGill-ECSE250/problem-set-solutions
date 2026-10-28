package ca.mcgill.ecse250.chapter27;

/**
 * CHAPTER 27: HASHING
 */
public class Chapter27 {

    public static void main(String[] args) {
    }

    static void exercise_27_01() {

    }

    static void exercise_27_09() {
        System.out.println("hashCodeForString(hashcode) =" + hashCodeForString("hashcode"));
    }


    private final static byte b = 31;
    public static int hashCodeForString(String s){
        int hashCode = 0;
        for(int i = 0; i < s.length() - 1; i++){
            hashCode += s.charAt(i);
            hashCode *= b;
        }
        return hashCode + s.charAt(s.length() - 1);
    }

}
