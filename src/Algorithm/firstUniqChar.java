package Algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class firstUniqChar {

    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            map.put(c, !map.containsKey(c));
        }
        for (Character character : map.keySet()) {
            if (map.get(character)) {
                return character;
            }
        }
        return ' ';
    }
}
