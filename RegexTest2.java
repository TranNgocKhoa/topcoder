import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
    public static void main(String[] args) {
        String jsonString = "{\"data\":[{\"firstName\":\"John\",\"lastName\":\"Doe\"},{\"firstName\":\"Jane\",\"lastName\":\"Doe\"},{\"firstName\":\"ssssss\",\"lastName\":\"Doe\"}]}";
        Pattern pattern = Pattern.compile("\"data\":\\[\\{.*?\\}\\,\\{.*?\\},\\{\"firstName\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(jsonString);
        if (matcher.find()) {
            String firstName = matcher.group(1);
            System.out.println(firstName); // output: Jane
        }
    }
}
