public class StringCompression {
    public static void main(String[] args) {
        String str = "aabccccaaa";
        System.out.println(str + " : " + compressString(str));
    }

    private static String compressString(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                sb.append(chars[i]);
                sb.append(count);
                count = 1;
            }
        }
        sb.append(chars[str.length() - 1]);
        sb.append(count);
        return sb.toString();
    }
}
