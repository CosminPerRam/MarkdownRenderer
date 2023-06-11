package utilities;

public class MarkDown {
    public static String convert(String content) {
        String[] lines = content.split("\\r?\\n");

        StringBuilder converted = new StringBuilder();

        for(String line : lines) {
            converted.append(line).append("<br>");
        }

        return "<html>" + converted + "</html>";
    }
}
