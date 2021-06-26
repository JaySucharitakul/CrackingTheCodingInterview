import java.util.Scanner;

public class OneAway {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter str1: ");
        String str1 = input.nextLine();

        input = new Scanner(System.in);
        System.out.println("Enter str2: ");
        String str2 = input.nextLine();
    }

    private static boolean singleEdit(String str1, String str2)
    {
        int str1Len = str1.length();
        int str2Len = str2.length();

        if (str1Len - str2Len > 1)
            return false;

        int editCount = 0;

        char str1Array[] = str1.toCharArray();
        char str2Array[] = str2.toCharArray();
        int str1Count = 0;
        int str2Count = 0;
        while (str1Count < str1Len && str2Count < str2Len)
        {
            if (str1Array[str1Count] != str2Array[str2Count])
            {

            }
        }
        return false;
    }
}
