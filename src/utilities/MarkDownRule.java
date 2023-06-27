package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A markdown rule.
 */
public class MarkDownRule {
    public String name, regex, template;

    /**
     * A MarkDown rule constructor.
     * @param name its name
     * @param regex the regex
     * @param template the group replacing template
     */
    public MarkDownRule(String name, String regex, String template) {
        this.name = name;
        this.regex = regex;
        this.template = template;
    }

    /**
     * Apply the current rule on a specified content
     * @param content specified content
     * @return the processed content
     */
    public String apply(String content) {
        Matcher matcher = Pattern.compile(this.regex).matcher(content);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            String replacement = this.template;
            for (int i = 0; i < matcher.groupCount(); i++) {
                String placeholder = "$" + (i + 1);
                String value = matcher.group(i + 1);
                replacement = replacement.replace(placeholder, value);
            }
            matcher.appendReplacement(output, replacement);
        }
        matcher.appendTail(output);

        return output.toString();
    }
}
