package java101;

import java.util.Arrays;

public class AreSame
{
    public static boolean comp(int[] a, int[] b)
    {
//    if (a == null || b == null || a.length != b.length)
//    {
//      return false;
//    }
//    else
//    {
//      int k = 0;
//      for (int i = 0; i < a.length; i++)
//      {
//        boolean found = false;
//        for (int j = 0; j < b.length; j++)
//        {
//          if (a[i] * a[i] == b[j])
//          {
//            found = true;
//            break;
//          }
//        }
//        if (!found)
//        {
//          return false;
//        }
//      }
//      return true;
//    }
        if (a == null || b == null || a.length != b.length)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < a.length; i++)
            {
                a[i] = a[i] * a[i];
            }
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
    }
}