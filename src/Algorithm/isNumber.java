package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isNumber {

    public static List<Map<Character, Integer>> tempList = new ArrayList<>();
    static {
        Map<Character, Integer> temp0 = new HashMap<>();//kongge
        temp0.put('b', 0);
        temp0.put('s', 1);
        temp0.put('n', 2);
        temp0.put('d', 9);

        Map<Character, Integer> temp = new HashMap<>();//+-
        temp.put('n', 2);
        temp.put('d', 9);

        Map<Character, Integer> temp1 = new HashMap<>();//11
        temp1.put('n', 2);
        temp1.put('d', 3);
        temp1.put('e', 5);
        temp1.put('b', 8);

        Map<Character, Integer> temp2 = new HashMap<>();//.
        temp2.put('n', 4);
        temp2.put('e', 5);
        temp2.put('b', 8);

        Map<Character, Integer> temp3 = new HashMap<>();//21
        temp3.put('n', 4);
        temp3.put('e', 5);
        temp3.put('b', 8);

        Map<Character, Integer> temp4 = new HashMap<>();//e
        temp4.put('s', 6);
        temp4.put('n', 7);

        Map<Character, Integer> temp5 = new HashMap<>();//+-
        temp5.put('n', 7);

        Map<Character, Integer> temp6 = new HashMap<>();
        temp6.put('n', 7);
        temp6.put('b', 8);

        Map<Character, Integer> temp7 = new HashMap<>();
        temp7.put('b', 8);

        Map<Character, Integer> temp8 = new HashMap<>();
        temp8.put('n', 4);

        tempList.add(temp0);
        tempList.add(temp);
        tempList.add(temp1);
        tempList.add(temp2);
        tempList.add(temp3);
        tempList.add(temp4);
        tempList.add(temp5);
        tempList.add(temp6);
        tempList.add(temp7);
        tempList.add(temp8);
    }

    /**
     * 0 符号 或者 数字
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        int index = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> startMap = tempList.get(index);
            char temp = getCharType(s.charAt(i));
            if (temp == 'z' || !startMap.containsKey(temp)) {
                return false;
            }
            index = startMap.get(temp);
        }
        return index == 2 || index == 3 || index == 4 || index == 7 || index == 8;
    }

    public static char getCharType(char i) {
        if (i == 'e' || i == 'E') {
            return 'e';
        } else if (i >= '0' && i <= '9') {
            return 'n';
        } else if (i == '+' || i == '-') {
            return 's';
        } else if (i == '.') {
            return 'd';
        }
        return 'z';
    }

    public static void main(String[] args) {
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber("3."));
        System.out.println(isNumber("1"));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("+100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1416"));
        System.out.println(isNumber("-1E-16"));
        System.out.println(isNumber("0123"));

        System.out.println("---------------------------------------");
        System.out.println(isNumber("."));
        System.out.println(isNumber("12e"));
        System.out.println(isNumber("1a3.14"));
        System.out.println(isNumber("1.2.3"));
        System.out.println(isNumber("+-5"));
        System.out.println(isNumber("12e+5.4"));
    }

}
