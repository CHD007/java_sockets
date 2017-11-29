package ru.spb.etu.GUI;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;

public class MainFrame extends JFrame {
    private JFormattedTextField textFieldFirstValue;
    private JFormattedTextField textFieldSecondValue;
    private JComboBox<GeometricAction> actionsComboBox;
    private JButton okButton;

    private final static int WIDHT = 400;
    private final static int HEIGHT = 200;

    public MainFrame() {
        setFrameSize();
        initFields();
        createVerticalBox();
    }

    private void setFrameSize() {
        setSize(WIDHT, HEIGHT);
    }

    @SuppressWarnings("Duplicates")
    private void createVerticalBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel("Высчитать:"), c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(actionsComboBox, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Первое число:"), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(textFieldFirstValue, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Второе число:"), c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(textFieldSecondValue, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(okButton, c);
        add(panel);
    }

    @SuppressWarnings("Duplicates")
    private void initFields() {
        textFieldFirstValue = new JFormattedTextField(NumberFormat.getNumberInstance());
        textFieldFirstValue.setColumns(4);
        textFieldFirstValue.setMaximumSize(new Dimension(100,20));
        textFieldFirstValue.setSize(new Dimension(100,20));
        textFieldSecondValue = new JFormattedTextField(NumberFormat.getNumberInstance());
        textFieldSecondValue.setColumns(4);
        actionsComboBox = new JComboBox<>();
        Arrays.asList(GeometricAction.values()).forEach(a -> actionsComboBox.addItem(a));
        okButton = new JButton("Посчитать");

        okButton.addActionListener((actionEvent) -> {

        });
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JFormattedTextField getTextFieldFirstValue() {
        return textFieldFirstValue;
    }

    public JFormattedTextField getTextFieldSecondValue() {
        return textFieldSecondValue;
    }

    public JComboBox<GeometricAction> getActionsComboBox() {
        return actionsComboBox;
    }

    public boolean validateFields() {
        switch ((GeometricAction)getActionsComboBox().getSelectedItem()) {
            case TRIANGLE_AREA:
            case REACTANGLE_PERIMETER:
            case ROMBUS_AREA:
                if (textFieldFirstValue.getValue() == null || textFieldSecondValue.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Неправильные числа");
                    return false;
                } else {
                    return true;
                }
            case ORB_VALUE:
                if (textFieldFirstValue.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Неправильные числа");
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }
}
