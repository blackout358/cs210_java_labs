public class baseConverter {
    public static void main(String[] args) {
        int base1 = 6;
        int base2 = 17;
        String inputNumber = "542015123130";
        boolean isNegative = false;

        if (inputNumber.contains("-")) {
            isNegative = true;
            inputNumber = inputNumber.substring(1);
        }

        if (isValidInput(inputNumber, base1) && checkBase(base1) && checkBase(base2)) {
            inputNumber = baseToDecimal(inputNumber, base1);
            System.out.println(checkBase(base2));
            String res = decimalToBase(inputNumber, base2);
            if (isNegative) {
                System.out.println("-" + res);
            } else {
                System.out.println(res);
            }

            // System.out.println(decimalToBase(inputNumber, base2));
        } else {
            System.out.println("Invalid input or base.");
        }

    }

    /**
     * Takes in input number and base, then converts it into decimal
     * 
     * number = 123, base 5
     * (1*5^2) + (2*5^1) + (3*5^0)
     * 
     * @param number to be changed to decimal
     * @param base   of the input number
     * @return the number converted to decimal
     */
    public static String baseToDecimal(String number, int base) {
        long sum = 0;
        // String num = Integer.toString(number);
        for (int i = 0, j = number.length() - 1; i < number.length(); i++, j--) {
            sum += Character.getNumericValue(number.charAt(i)) * Math.pow(base, j);
        }
        return String.valueOf(sum);

    }

    /**
     * Divide the number by the base, get the remainder and get its character value
     * and add it to the string reverse the string and return it
     * 
     * @param num  input decimal number
     * @param base desired base to be converted to
     * @return number in the base given
     */
    public static String decimalToBase(String number, int base) {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        long num = Long.parseLong(number);
        while (num > 0) {
            long remander = num % base;
            int rem = (int) remander;
            num /= base;
            res += digits.charAt(rem);
        }
        return new StringBuilder(res).reverse().toString();
    }

    /**
     * checks if the base is between 2 and 32 inclusive
     * 
     * @param base
     * @return true if base is valid, false if it is not
     */
    public static boolean checkBase(int base) {
        return base <= 32 && base >= 2;
    }

    /**
     * Checks if the input number is valid for the given base.
     * For example, if the base is 10, the input number should only contain digits
     * 0-9.
     *
     * @param number to be checked
     * @param base   of the input number
     * @return true if the input number is valid, false otherwise
     */
    public static boolean isValidInput(String number, int base) {
        String validCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // String num = Integer.toString(number);
        for (char c : number.toCharArray()) {
            if (validCharacters.indexOf(c) < 0 || validCharacters.indexOf(c) >= base) {
                return false;
            }
        }
        return true;
    }
}
