import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy {
    public static void main(String[] args) {

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println("countryToLocales: " + countryToLocales);

        List<Locale> swissLocales = countryToLocales.get("CH");
        System.out.println("swissLocales: " + swissLocales);

        locales = Stream.of(Locale.getAvailableLocales());

        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

        List<Locale> englishLocales = englishAndOtherLocales.get(true);

        System.out.println("englishAndOtherLocales: " + englishAndOtherLocales);
        System.out.println("englishLocales: " + englishLocales);

    }
}
