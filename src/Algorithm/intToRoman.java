package Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class intToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    /**
     *  * I             1
     *  * V             5
     *  * X             10
     *  * L             50
     *  * C             100
     *  * D             500
     *  * M             1000
     */

    public static String intToRoman(int num) {
        Map<Integer, String> codeMap = new LinkedHashMap<>();
        codeMap.put(1000, "M");
        codeMap.put(900, "CM");
        codeMap.put(500, "D");
        codeMap.put(400, "CD");
        codeMap.put(100, "C");
        codeMap.put(90, "XC");
        codeMap.put(50, "L");
        codeMap.put(40, "XL");
        codeMap.put(10, "X");
        codeMap.put(9, "IX");
        codeMap.put(5, "V");
        codeMap.put(4, "IV");
        codeMap.put(1, "I");

        StringBuilder a = new StringBuilder();
        for (Integer integer : codeMap.keySet()) {
            while (num / integer > 0) {
                num = num - integer;
                a.append(codeMap.get(integer));
                if (num == 0) {
                    break;
                }
            }
            if (num == 0) {
                break;
            }
        }
        return a.toString();
    }
    /**
     * 模拟
     * @param num
     * @return
     */
    public static String intToRoman1(int num) {
        StringBuilder a = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                a.append("M");
            }
            if (num < 1000) {
                if (num >= 900) {
                    a.append("CM");
                    num -= 900;
                }

                if (num < 900 && num >= 500) {
                    num -= 500;
                    a.append("D");
                }

                if (num < 500) {
                    if (num >= 400) {
                        num -= 400;
                        a.append("CD");
                    }

                    if (num < 400 && num >= 100) {
                        a.append("C");
                        num -= 100;
                    }

                    if (num < 100) {
                        if (num >= 90) {
                            a.append("XC");
                            num -= 90;
                        }
                        if (num < 90 && num >= 50) {
                            a.append("L");
                            num -= 50;
                        }
                        if (num < 50) {
                            if (num >= 40) {
                                num -= 40;
                                a.append("XL");
                            }
                            if (num < 40 && num >= 10) {
                                num -= 10;
                                a.append("X");
                            }

                            if (num < 10) {
                                if (num >= 9) {
                                    num -= 9;
                                    a.append("IX");
                                }
                                if (num < 9 && num >= 5) {
                                    a.append("V");
                                    num -= 5;
                                }
                                if (num < 5) {
                                    if (num >= 4) {
                                        a.append("IV");
                                        num -= 4;
                                    }
                                    if (num < 4 && num >= 1) {
                                        a.append("I");
                                        num -= 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return a.toString();
    }
}
