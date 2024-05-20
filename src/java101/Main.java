package java101;

import java.util.stream.Stream;
import java.util.ArrayList;

//import static org.junit.Assert.assertEquals;

public class Main
{
    public static void main(String [] str)
    {
        Stream<String> stream = Stream.of("apple", "banane", "cherry");
        stream.forEach(System.out::println); //it gives out each stream'sum element
        Probe probe = new Probe();
        probe.aVoid().forEach(System.out::println);
        Lambda lambda = new Lambda();
        System.out.println(lambda.getLength("Anas"));
        Sum sum = new Sum();
        System.out.println(sum.GetSum(-3,6));
        Kata kata = new Kata();
        System.out.println(kata.getMiddle("Computer Science"));
        System.out.println(kata.binaryAddition(5,6));
        int[] ints = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] ints1 = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
//        AreSame areSame = new AreSame();
        System.out.println(AreSame.comp(ints,ints1));
        Metro metro = new Metro();
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        arrayList.add(new int[] {10,0});
        arrayList.add(new int[] {3,5});
        arrayList.add(new int[] {2,5});
        System.out.println(metro.countPassengers(arrayList));
        int [] arrr = {1,2,3};
        System.out.println(LargestDifference.largestDifference(arrr));
        System.out.println(Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(Scramblies.scramble(new String("rkqodlw"), new String("world")));
        System.out.println(Scramblies.scramble(new String("cedewaraaossoqqyt"), new String("codewars")));
        System.out.println(Scramblies.scramble(new String("katas"), new String("steak")));
        System.out.println(new SpinWords().spinWords("Hey fellow warriors"));
        System.out.println(new SpinWords().spinWords("This is probe test"));
        System.out.println(new SpinWords().spinWords("This is another test"));
        System.out.println(ASum.findNb(1071225));
    }
}
