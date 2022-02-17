package numbers;

public class Jumping {

    protected static boolean jumping (long input){
        boolean result = true;
        String jumping = String.valueOf(input);
        for (int i = 0; i < jumping.length() - 1; i++) {
            result &= Math.abs(Integer.parseInt(String.valueOf(jumping.charAt(i))) - Integer.parseInt(String.valueOf(jumping.charAt((i + 1))))) == 1;
        }
        return result;

    }
}
