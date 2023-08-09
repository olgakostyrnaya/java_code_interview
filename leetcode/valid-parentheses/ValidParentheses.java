import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private Map<Character, Character> pairs = new HashMap<Character, Character>();

    ValidParentheses() {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> openings = new Stack<>();

        for (char litera : s.toCharArray()) {
            if (openings.isEmpty() && pairs.containsKey(litera)) {
                return false;
            }
            if (pairs.containsKey(litera)) {
                Character symbol = pairs.get(litera);
                if (!symbol.equals(openings.pop())) {
                    return false;
                }
            } else {
                openings.push(litera);
            }
        }

        if (!openings.isEmpty()) {
            return false;
        }

        return true;
    }
}
