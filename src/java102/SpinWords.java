package java102;

// Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed
// (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than
// one word is present.

// Examples:

//spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
// spinWords( "This is a test") => returns "This is a test"
// spinWords( "This is another test" )=> returns "This is rehtona test"

public class SpinWords {

    public String spinWords(String sentence) {
        StringBuilder sb = new StringBuilder();
        String [] splitSentence = sentence.split(" ");

        for (String word : splitSentence) {
            if (word.length() > 4) {
                sb.append(new StringBuilder(word).reverse().toString() + " ");
            } else {
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }
}
