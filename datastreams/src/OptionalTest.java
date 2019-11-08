import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("datastreams\\alice.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");


    }
}
