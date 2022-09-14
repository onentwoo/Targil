import java.util.HashMap;
import java.util.Map;

public class swtrings {


    static Map<Character, Long> counter = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(testMutation());
    }

    public static boolean testMutation() {
        String a = "ABC";
        String b = "CBA";
        if (a.length() != b.length()) {
            return false;
        }
        for (int i=0 ; i<a.length(); i++) {
            char currentCharAtA = a.charAt(i);
            if (counter.containsKey(currentCharAtA)) {
                counter.put(currentCharAtA, counter.get(currentCharAtA) + 1);
            }
            else {
                counter.put(currentCharAtA,1L);
            }
        }
        for (int i=0 ; i<b.length(); i++) {
            char currentCharAtB = b.charAt(i);
            if (counter.containsKey(currentCharAtB)) {
                counter.put(currentCharAtB, counter.get(currentCharAtB) - 1);
                if (counter.get(currentCharAtB)<0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
