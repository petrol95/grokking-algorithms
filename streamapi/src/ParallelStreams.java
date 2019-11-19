import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("streamapi\\alice.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        // bad code
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s ->
        {
            if (s.length() < 10)
                shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        // bad code
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s ->
        {
            if (s.length() < 10)
                shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        //
        Map<Integer, Long> shortWordCounts = wordList
                .parallelStream().filter(s -> s.length() < 10)
                .collect(groupingBy(String::length, counting()));
        System.out.println(shortWordCounts);



    }
}
