package utilities;

import java.util.ArrayList;
import java.util.List;

public class MarkDown {
    public List<MarkDownRule> rules = new ArrayList<>();

    public void addRule(MarkDownRule rule) {
        rules.add(rule);
    }

    public MarkDown() {
        addRule(new MarkDownRule("Header 1st Order", "#{1}\\s?([^\\n]+)", "<h1>$1</h1>"));
        addRule(new MarkDownRule("Header 2nd Order", "#{2}\\s?([^\\n]+)", "<h2>$1</h2>"));
        addRule(new MarkDownRule("Header 3rd Order", "#{3}\\s?([^\\n]+)", "<h3>$1</h3>"));

        addRule(new MarkDownRule("Bold", "\\*\\*\\s?([^\\n]+)\\*\\*", "<b>$1</b>"));
        addRule(new MarkDownRule("Italics", "\\*\\s?([^\\n]+)\\*", "<i>$1</i>"));
        addRule(new MarkDownRule("Bold shorter", "__([^_]+)__", "<b>$1</b>"));
        addRule(new MarkDownRule("Italics shorter", "_([^_`]+)_", "<i>$1</i>"));
        addRule(new MarkDownRule("Paragraph", "([^\\n]+\\n?)", "<p>$1</p>"));

        addRule(new MarkDownRule("List", "([^\\n]+)(\\+)([^\\n]+)", "<ul><li>$3</li></ul>"));
        addRule(new MarkDownRule("List alternative", "([^\\n]+)(\\*)([^\\n]+)", "<ul><li>$3</li></ul>"));
    }

    public String convert(String content) {
        for(MarkDownRule rule : rules) {
            content = rule.apply(content);
        }

        return "<html>" + content + "</html>";
    }
}
