public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        s = prepareInputString(s);

        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }

    public String prepareInputString(String s) {
        s = removeNonAlphaNumericSymbols(s);
        return s.toLowerCase();
    }

    public String removeNonAlphaNumericSymbols(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    public boolean isPalindromeOptimized(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int tail = s.length() - 1;
        int head = 0;
        while (head <= tail) {
            char chHead = s.charAt(head);
            char chTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(chHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(chTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(chHead) != Character.toLowerCase(chTail)) {
                    return false;
                }
                tail--;
                head++;
            }
        }

        return true;
    }
}
