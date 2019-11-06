import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransformingStreams {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Gently", "Down", "The", "Stream"));

        Stream<String> lowercaseWords = words
                .stream()
                .map(String::toLowerCase);
        CreatingStreams.show("lowercaseWords", lowercaseWords);

        Stream<String> firstLetters = words
                .stream()
                .map(s -> s.substring(0, 1));
        CreatingStreams.show("firstLetters", firstLetters);

        Stream<Stream<String>> streamResult = words
                .stream()
                .map(w -> letters(w));
        Stream<String> flatResult = words
                .stream()
                .flatMap(w -> letters(w));
        CreatingStreams.show("flatResult", flatResult);
    }

    private static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
