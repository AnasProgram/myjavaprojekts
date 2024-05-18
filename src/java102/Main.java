package java102;

public class Main
{
    public static void main(String[] args)
    {
        String str = "Hello, World!";
        char[] charArray = str.toCharArray();

        // Iteration durch das Char-Array und Ausgabe der einzelnen Zeichen
        for (char c : charArray) {
            System.out.println(c);
        }
    }
}
