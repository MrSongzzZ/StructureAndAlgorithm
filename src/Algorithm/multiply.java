package Algorithm;

public class multiply {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";
        StringBuilder zero = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int a = num2.charAt(i) - '0';
            String temp = multiString(num1, a);
            temp += zero.toString();
            zero.append("0");
            result = addString(result, temp);
        }
        return result;
    }

    public static String addString(String nums1, String nums2) {
        int c = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = nums1.length() - 1, j = nums2.length() - 1; i >= 0 || j >= 0; j--, i--) {
            int a = i < 0 ? 0 : nums1.charAt(i) - '0';
            int b = j < 0 ? 0 : nums2.charAt(j) - '0';
            int r = a + b + c;
            c = r / 10;
            r = r % 10;
            builder.append(r);
        }
        if (c > 0) {
            builder.append(c);
        }
        return builder.reverse().toString();
    }

    public static String multiString(String nums1, int a) {
        if (a == 0) {
            return "0";
        }
        int c = 0;
        StringBuilder b = new StringBuilder();
        for (int i = nums1.length() - 1; i >= 0; i--) {
            int x = nums1.charAt(i) - '0';
            int r = x * a + c;
            c = r / 10;
            r = r % 10;
            b.append(r);
        }
        if (c > 0) {
            b.append(c);
        }
        return b.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

}
