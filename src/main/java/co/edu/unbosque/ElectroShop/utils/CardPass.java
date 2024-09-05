package co.edu.unbosque.ElectroShop.utils;





public class CardPass {
    /**
     * Checks if a given card number is valid according to the Luhn formula.
     * @param card_number the card number to check
     * @return true if the card number is valid, false if not
     */
    public static boolean isValidCard(String card_number) {
        int sum = 0;
        boolean alternate = false;

        for (int i = card_number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(card_number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }




}
