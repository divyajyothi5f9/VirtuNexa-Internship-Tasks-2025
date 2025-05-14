public class PalindromeChecker {
    public boolean isPalindrome(String input) {
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}