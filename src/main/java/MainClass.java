import parser.StringParser;

public class MainClass {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Program arguments is empty.");
        } else if (StringParser.isValidString(args[0])) {
            System.out.println(StringParser.parseSubString(args[0]));
        } else {
            System.out.println("String: \"" + args[0] + "\" is invalid.");
        }
    }
}
