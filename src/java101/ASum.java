package java101;

public class ASum
{
    public static long findNb(long m)
    {
        long sum = 0;  // Summe der Volumina der Würfel
        long n = 1;    // Anzahl der Würfel
        while (sum < m)
        {
            sum += n * n * n;  // Volumen des nächsten Würfels hinzufügen
            if (sum == m)
            {
                return n;  // Wenn die Summe gleich m ist, die Anzahl der Würfel zurückgeben
            }
            n++;  // Zum nächsten Würfel übergehen
        }
        return -1;  // Wenn die Summe nie gleich m wird, -1 zurückgeben
    }
}
