public class PalindromeCheck {

    public static void main(String[] args) {
        String s1 = "Коту тащат уток";
        String s2 = "Мало кукле дел - к уколам";
        String s3 = "И лежу. - Ужели?";
        String s4 = "Аргентина манит негра";
        String s5 = "Колесо. Жалко поклаж. Оселок.";
        String s6 = "Другая строка";

        System.out.println(s1 + ": " + isPalindrome(s1));
        System.out.println(s2 + ": " + isPalindrome(s2));
        System.out.println(s3 + ": " + isPalindrome(s3));
        System.out.println(s4 + ": " + isPalindrome(s4));
        System.out.println(s5 + ": " + isPalindrome(s5));
        System.out.println(s6 + ": " + isPalindrome(s6));
    }

    private static boolean isPalindrome(String s) {
        s = s.replaceAll("-|,|\\.|\\?|!|\\(|\\)|\\s", ""); // убираем знаки препинания, скобки и пробелы
        char[] arr = s.toCharArray();
        for (int i = 0; i <= arr.length/2; i++) {
            if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[arr.length - 1 - i]))
                return false;
        }
        return true;
    }
}
