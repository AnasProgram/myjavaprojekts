package java102;
/*
https://www.codewars.com/kata/5592e3bd57b64d00f3000047
 */
public class ASum
{
    public static long findNb(long m)
    {
        long sum = 0;
        long n = 0;
        while (sum < m)
        {
            n++;
            sum += n*n*n;
        }
        if (sum == m)
        {
            return n;
        }
        else
        {
            return -1;
        }
    }
}
