import java.util.*;

class cardChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter card number");
        String cardNum = input.nextLine();
        if (checkCardValid(cardNum)) {
            System.out.println("Is a valid credit card");
        } else {
            System.out.println("Is not a valid credit card");
        }

    }

    /**
     * First reverse the string, then gets index posision, if the
     * index is odd, checked by if its divisble by 2, mulitply it by 2.
     * if then its greater than 9, minus 9 if not add normally
     * if number is even, add it to another integer.
     * at the end add both together and see if divisible by 10
     * to check if it is a valid card.
     * 
     * @param cardNum4539682995824395
     * @return a boolean to state if card is valid or not
     */
    public static boolean checkCardValid(String cardNum) {
        String rev = new StringBuilder(cardNum).reverse().toString(); // reverse the string
        int sum = 0;
        int multSum = 0;
        /*
         * 4539682995824395
         * 0123456789
         */
        if (rev.length() > 3 && rev.length() < 31) {
            for (int i = 0; i < rev.length(); i++) {
                if (i % 2 == 0) {
                    sum += Character.getNumericValue(rev.charAt(i));
                } else { // number is odd
                    int numCheck = Character.getNumericValue(rev.charAt(i)) * 2;
                    if (numCheck > 9) {
                        multSum += numCheck -= 9;
                    } else {
                        multSum += numCheck;
                    }
                }
            }
            if ((sum + multSum) % 10 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
