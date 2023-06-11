package utilities;

import java.util.ArrayList;
import java.util.List;

public class MarkDown {
    public static String tagsToText(List<String> tags, boolean ending) {
        StringBuilder converted = new StringBuilder();

        String endingTag = ending ? "/" : "";
        for(String tag : tags)
            converted.append("<").append(endingTag).append(tag).append(">");

        return converted.toString();
    }

    public static String convertLine(String line) {
        StringBuilder converted = new StringBuilder();
        List<String> tags = new ArrayList<String>();

        /// Add tags
        if (line.startsWith("# ")) {
            line = line.substring(2);
            tags.add("h1");
        }

        if (line.startsWith("## ")) {
            line = line.substring(3);
            tags.add("h2");
        }

        if (line.startsWith("### ")) {
            line = line.substring(4);
            tags.add("h3");
        }

        /// Convert everything
        converted.append(tagsToText(tags, false));
        converted.append(line);
        converted.append(tagsToText(tags, true));

        converted.append("<br>");

        return converted.toString();
    }

    public static String convert(String content) {
        String[] lines = content.split("\\r?\\n");

        StringBuilder converted = new StringBuilder();

        for(String line : lines) {
            converted.append(convertLine(line));
        }

        return "<html>" + converted + "</html>";
    }
}
