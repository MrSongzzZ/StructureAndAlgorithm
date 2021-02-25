package Algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class firstUniqChar1 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.containsKey(cs[i]) ? -1 : i);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) >= 0) {
                return map.get(character);
            }
        }
        return -1;
    }
}
