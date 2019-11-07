import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class Reduction {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("datastreams\\alice.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\PL+"));

//        Optional<String> largest = words.max(String::compareToIgnoreCase); // max in the sense of alphabetical order!
//        System.out.println("largest: " + largest.orElse(""));

//        Optional<String> startsWithQ = words.filter(s -> s.startsWith("q")).findFirst();
//        System.out.println("startsWithQ: " + startsWithQ.orElse(""));

//        Optional<String> startsWithQ = words.parallel().filter(s -> s.startsWith("q")).findAny();
//        System.out.println("startsWithQ: " + startsWithQ.orElse(""));

        boolean aWordStartsWithQ = words.parallel().anyMatch(s -> s.startsWith("Q"));
        System.out.println("aWordStartsWithQ: " + aWordStartsWithQ);

    }
}
