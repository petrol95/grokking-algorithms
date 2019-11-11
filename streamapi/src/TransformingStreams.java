import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TransformingStreams {

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>(Arrays.asList("Gently", "Down", "The", "Stream"));

        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);
        CreatingStreams.show("lowercaseWords", lowercaseWords);

        Stream<String> firstLetters = words.stream().map(s -> s.substring(0, 1));
        CreatingStreams.show("firstLetters", firstLetters);

        Stream<Stream<String>> streamResult = words.stream().map(w -> letters(w));
        Stream<String> flatResult = words.stream().flatMap(w -> letters(w));
        CreatingStreams.show("flatResult", flatResult);

        Stream<Double> randoms = Stream.generate(Math::random).limit(8);
        CreatingStreams.show("randoms", randoms);

        Path path = Paths.get("streamapi\\alice.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> book = Stream.of(contents.split("\\PL+")).skip(1);
        CreatingStreams.show("book", book);

        Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
        CreatingStreams.show("combined", combined);

        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        CreatingStreams.show("uniqueWords", uniqueWords);

        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        CreatingStreams.show("longestFirst", longestFirst);

        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();

    }

    private static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
