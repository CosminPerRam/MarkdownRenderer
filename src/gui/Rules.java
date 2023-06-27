package gui;

import utilities.MarkDown;
import utilities.MarkDownRule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Objects;
import java.util.regex.Pattern;

import static utilities.Logger.Log;

/**
 * The rules' dialog.
 */
public class Rules {
    static JDialog dialog;
    static boolean visible = false;

    static JScrollPane scrollTable;
    static JTable table;
    static final String[] columns = {"Name", "Regex", "Template"};

    static JTextField name, regex, template;

    /**
     * Initialize the rules' dialog.
     */
    public static void initialize() {
        dialog = new JDialog(GUI.frame.window, "Markdown - Rules", true);
        dialog.setResizable(false);
        dialog.setSize(600, 300);

        JPanel mainPanel = new JPanel();

        JPanel controlsPanel = new JPanel();

        GridLayout layout = new GridLayout(2, 4);
        controlsPanel.setLayout(layout);

        controlsPanel.add(new JLabel("Name: "));
        controlsPanel.add(new JLabel("Regex: "));
        controlsPanel.add(new JLabel("Template: "));
        JButton removeSelected = new JButton("Remove selected");
        removeSelected.addActionListener(e -> removeSelected());
        controlsPanel.add(removeSelected);

        name = new JTextField();
        controlsPanel.add(name);
        regex = new JTextField();
        controlsPanel.add(regex);
        template = new JTextField();
        controlsPanel.add(template);
        JButton addRule = new JButton("Add rule");
        addRule.addActionListener(e -> addRule());
        controlsPanel.add(addRule);

        mainPanel.add(controlsPanel, BorderLayout.PAGE_START);

        table = new JTable(new Object[][]{}, columns);
        scrollTable = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        mainPanel.add(scrollTable);
        updateRules();

        dialog.setContentPane(mainPanel);

        Log().info("Rules dialog has been initialized.");
    }

    /**
     * Update the table and re-render the markdown area.
     */
    public static void updateRules() {
        Object[][] data = new Object[MarkDown.rules.size()][3];
        for(int i = 0; i < MarkDown.rules.size(); i++) {
            MarkDownRule rule = MarkDown.rules.get(i);
            data[i][0] = rule.name;
            data[i][1] = rule.regex;
            data[i][2] = rule.template;
        }

        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        GUI.markdownRenderArea.update();
    }

    /**
     * Removes a rule that is selected from the table.
     */
    public static void removeSelected() {
        int index = table.getSelectedRow();
        if(index == -1) {
            GUI.showError("You need to select a row to delete.");
        } else {
            String selectedRuleName = table.getValueAt(index, 0).toString();
            boolean ignored = MarkDown.removeRule(selectedRuleName);
            updateRules();
        }
    }

    /**
     * Adds a new rule! The data is taken from the UI text fields.
     */
    public static void addRule() {
        String ruleName = name.getText(), ruleRegex = regex.getText(), ruleTemplate = template.getText();

        if(MarkDown.rules.stream().anyMatch(r -> Objects.equals(r.name, ruleName))) {
            GUI.showError("There can't be 2 rules with the same name.");
            return;
        }

        try {
            Pattern.compile(ruleRegex);
        } catch (Exception e) {
            GUI.showError("Invalid regex.");
            return;
        }

        MarkDown.addRule(new MarkDownRule(ruleName, ruleRegex, ruleTemplate));
        updateRules();
    }

    /**
     * Toggle the dialogs' visibility.
     */
    public static void toggleVisibility() {
        dialog.setVisible(!visible);
    }
}
