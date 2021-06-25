import java.util.Scanner;

public class URLify {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");

        String string = input.nextLine();
        System.out.println(urlify(string));
    }

    private static String urlify(String arg)
    {
        String trim = arg.trim();
        trim = trim.replaceAll("\\s", "%20");
        return trim;
    }
}
