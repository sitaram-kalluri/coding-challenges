package src.twoPointer;

public class ReverseString {

    public static void main(String[] args) {
        String test = "This is a pen";
        System.out.println(reverseWords(test));

    }

    public static String reverseWords(String sentence) {

        String[] wordsInSentence = sentence.split("\\s+");
        int endOfArray = (wordsInSentence.length - 1);

        StringBuilder reverseWordsBuilder = new StringBuilder();
        for (int index = endOfArray; index >= 0; index--) {
            reverseWordsBuilder.append(wordsInSentence[index].trim());
            reverseWordsBuilder.append(" ");

        }
        return reverseWordsBuilder.toString().trim();
    }
}
