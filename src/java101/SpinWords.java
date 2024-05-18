package java101;

public class SpinWords
{
//    Write a function that takes in a string of one or more words, and returns the same string,
//    but with all words that have five or more letters reversed (Just like the name of this Kata).
//    Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
    public String spinWords(String sentence)
    {
        StringBuilder sb = new StringBuilder();
        String [] splitSentence = sentence.split(" ");

        for (String word : splitSentence)
        {
            if (word.length() > 4)
            {
                sb.append(new StringBuilder(word).reverse().toString() + " ");
            }
            else
            {
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }
}
