package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utilities.Logger.Log;

/**
 * The markdown rules holder and processor.
 */
public class MarkDown {
    public static List<MarkDownRule> rules = new ArrayList<>(){{
        add(new MarkDownRule("Header 3rd Order", "#{3}\\s?([^\\n]+)", "<h3>$1</h3>"));
        add(new MarkDownRule("Header 2nd Order", "#{2}\\s?([^\\n]+)", "<h2>$1</h2>"));
        add(new MarkDownRule("Header 1st Order", "#{1}\\s?([^\\n]+)", "<h1>$1</h1>"));

        add(new MarkDownRule("Bold", "\\*\\*\\s?([^\\n]+)\\*\\*", "<b>$1</b>"));
        add(new MarkDownRule("Italics", "\\*\\s?([^\\n]+)\\*", "<i>$1</i>"));
        add(new MarkDownRule("Bold underscore", "__([^_]+)__", "<b>$1</b>"));
        add(new MarkDownRule("Italics underscore", "_([^_`]+)_", "<i>$1</i>"));
        add(new MarkDownRule("Paragraph", "([^\\n]+\\n?)", "<p>$1</p>"));
        add(new MarkDownRule("Inline Code", "\\`([^`]+)\\`", "<code>$1</code>"));

        add(new MarkDownRule("List", "([^\\n]+)(\\-)([^\\n]+)", "<ul><li>$3</li></ul>"));
    }};

    /**
     * Adds a rule to the rules list.
     * @param rule the rule
     */
    public static void addRule(MarkDownRule rule) {
        rules.add(rule);
        Log().info("Markdown rule added.");
    }

    /**
     * Removes a rule from the rules list.
     * @param name the rule's name
     * @return whether a rule has been removed or not
     */
    public static boolean removeRule(String name) {
        boolean removed = rules.removeIf(rule -> Objects.equals(rule.name, name));
        if(removed) {
            Log().info("Markdown rule removed.");
        }
        return removed;
    }

    /**
     * Create a new Markdown processor.
     */
    public MarkDown() {

    }

    /**
     * Convert a text content to markdown content
     * @param content specified content
     * @return processed content
     */
    public String convert(String content) {
        for(MarkDownRule rule : rules) {
            content = rule.apply(content);
        }

        return "<html>" + content + "</html>";
    }
}
