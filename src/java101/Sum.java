package java101;

public class Sum
{
    public int GetSum(int a, int b)
    {
        int result = 0;
        for(int i = Math.min(a,b); i <= Math.max(a,b); i++)
        {
            result +=i;
        }
        return result;
    }
}
