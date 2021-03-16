package parser;

public class StringParser {
    public static boolean isValidString(String string) {
        Stack stack = new Stack();
        int flagHasSomeBracket = 0;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                if (i == (string.length() - 1)
                        || !Character.isDigit(string.charAt(i + 1))
                        && string.charAt(i + 1) != '[') {
                    return false;
                }
            } else if (string.charAt(i) == '[') {
                if (i == 0 || !Character.isDigit(string.charAt(i - 1))) {
                    return false;
                }
                flagHasSomeBracket = 1;
                stack.push('[');
            } else if (string.charAt(i) == ']') {
                if (i == 0
                        || string.charAt(i - 1) == '['
                        || stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (!Character.isLetter(string.charAt(i))) {
                return false;
            }
        }

        return stack.isEmpty() && flagHasSomeBracket != 0;
    }

    public static String parseSubString(String subString) {
        StringBuilder counter = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < subString.length(); i++) {
            if (Character.isDigit(subString.charAt(i))) {
                counter.append(subString.charAt(i));
            } else if (subString.charAt(i) == '[') {
                String subSubString = getSubString(subString.substring(i));
                String parsedString = parseSubString(subSubString);
                int numberOfRepeats = Integer.parseInt(counter.toString());

                i += subSubString.length() + 1;
                counter = new StringBuilder();

                for (int j = 0; j < numberOfRepeats; j++) {
                    result.append(parsedString);
                }
            } else {
                result.append(subString.charAt(i));
            }
        }
        return result.toString();
    }

    public static String getSubString(String string) {
        Stack stack = new Stack();
        StringBuilder result = new StringBuilder();

        stack.push(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (stack.isEmpty()) {
                break;
            }
            if (string.charAt(i) == '[') {
                stack.push(string.charAt(i));
            } else if (string.charAt(i) == ']')  {
                stack.pop();
            }
            result.append(string.charAt(i));
        }
        return result.substring(0, result.length() - 1);
    }
}
