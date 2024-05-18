package java101;

public class LargestDifference
{
    public static int largestDifference(int[] data)
    {
        int maxDiff = 0;
        int i, j;
        for (i = 0; i < data.length; ++i) {
            for (j = data.length-1; j > i; --j) {
                if (data[j] >= data[i] && maxDiff < (j - i))
                    maxDiff = j - i;
            }
        }
        return maxDiff;
    }
}
