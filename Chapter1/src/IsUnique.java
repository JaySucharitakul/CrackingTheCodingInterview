import java.util.Scanner;

public class IsUnique {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");

        String string = input.nextLine();
        if (isUnique(string) != 0)
            System.out.println("The string is not unique");
        else
            System.out.println("The string is unique");
    }

    private static int isUnique(String arg)
    {
        String knownChars = "";
        for (int i = 0; i < arg.length(); i++)
        {
            char letter = arg.charAt(i);
            if (knownChars.indexOf(letter) == -1)
                knownChars += letter;
            else
                return 1;
        }
        return 0;
    }
}
