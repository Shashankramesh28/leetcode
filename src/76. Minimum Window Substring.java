import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        int count = t.length(), start = -1, i = 0, j = 0, minLen = Integer.MAX_VALUE;
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int ind = 0; ind < t.length(); ind++) {
            map.put(t.charAt(ind), map.getOrDefault(t.charAt(ind), 0) + 1);
        }
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                count--;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            while (count == 0) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                }
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                if (map.get(s.charAt(i)) > 0) {
                    count++;
                }
                i++;
            }
            j++;
        }
        if (start == -1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}