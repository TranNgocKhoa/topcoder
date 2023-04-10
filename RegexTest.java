import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {


    public static void main(String[] args) {
        final String regex = "([\\w\\s-]*)(?:\\\"|\\')?";

        final String string = "{\n"
                + "  \"firstName\": \"John\",\n"
                + "  \"lastName\": \"Smith\",\n"
                + "  \"age\": 25,\n"
                + "  \"address\": {\n"
                + "    \"streetAddress\": \"21 2nd Street\",\n"
                + "    \"city\": \"New York\",\n"
                + "    \"state\": \"NY\",\n"
                + "    \"postalCode\": 10021\n"
                + "  },\n"
                + "  \"phoneNumber\": [\n"
                + "    {\n"
                + "      \"type\": \"home\",\n"
                + "      \"number\":    \"212 555-1239\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"type\": \"fax\",\n"
                + "      \"number\": \"646 555-4567\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"gender\": {\n"
                + "    \"type\": 1\n"
                + "  }\n"
                + "}";

        Pattern pattern = Pattern.compile("\"firstName\":\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String name = matcher.group(1);
            System.out.println(name); // output: John Doe
        }
    }
}
