package ru.spb.etu.server;

import javax.swing.*;
import java.awt.*;

public class ServerFrame extends JFrame {
    private final static int WIDHT = 400;
    private final static int HEIGHT = 200;

    private JPanel mainPanel;
    private JLabel serverAction;
    private JLabel clientSend;

    private JButton firstTableButton;
    private JButton secondTableButton;
    private JButton thirdTableButton;
    private JTable tableForServers;
    private JTable tableForUnivers;
    private JTable tableForSupplies;
    private JTable table;

    public ServerFrame() {
        setFrameSize();
        initWidgets();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createVerticalBox());
        setLayout(new BorderLayout());
        getContentPane().add(mainPanel);
    }

    private void initWidgets() {
        serverAction = new JLabel("");
        clientSend = new JLabel("");
        firstTableButton = new JButton("Сервера");
        secondTableButton = new JButton("Университеты");
        thirdTableButton = new JButton("Поставки");

        table = new JTable();
    }

    private void createTables() {
        String[] columnNames = {"Имя",
                "Сервера",
                "Sport",
                "# of Years",
                "Vegetarian"};
    }

    private Box createVerticalBox() {
        Box box = Box.createVerticalBox();
        box.add(createButtonsPanel());
        box.add(Box.createVerticalStrut(10));
        Box boxForTable = Box.createHorizontalBox();
        boxForTable.add(table);
        box.add(boxForTable);
        box.add(Box.createVerticalStrut(10));
        Box boxForMsg = Box.createHorizontalBox();
        boxForMsg.add(serverAction);
        boxForMsg.add(clientSend);
        box.add(boxForMsg);
        return box;
    }

    private Box createButtonsPanel() {
        Box box = Box.createHorizontalBox();
        box.add(firstTableButton);
        box.add(secondTableButton);
        box.add(thirdTableButton);
        box.add(Box.createHorizontalGlue());
        return box;
    }

    private void setFrameSize() {
        setSize(WIDHT, HEIGHT);
    }

    public JLabel getServerAction() {
        return serverAction;
    }

    public JLabel getClientSend() {
        return clientSend;
    }
}
