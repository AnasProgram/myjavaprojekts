package java101;

public class Kata
{
    public static String getMiddle(String word)
    {
        int length = word.length();
        int middle = length/2;
        if (length % 2 == 0)
        {
            return word.substring(middle -1, middle+1);
        }
        else
        {
            return word.substring(middle, middle+1);
        }
    }
    public static String binaryAddition(int a, int b)
    {
        int sum = a +b;
        String result = "";
        do
        {
            result= sum % 2 + result;
            sum = sum / 2;
        }
        while(sum != 0);
        return result;
    }
}
