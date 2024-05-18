package java101;
public class Lambda implements StringLengthCalculator
{
    @Override
    public int getLength(String str)
    {
        return str.length();
    }
    public static void lambda()
    {
        StringLengthCalculator calculator = (String str) -> str.length();
        String input = "Hello, World";
        int length = calculator.getLength(input);
        System.out.println("Length of the string: "+ length);
    }
}
