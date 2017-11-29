package ru.spb.etu.server;

import javax.swing.*;

public class ServerFrame extends JFrame {
    private final static int WIDHT = 400;
    private final static int HEIGHT = 200;

    private JLabel serverAction;
    private JLabel clientSend;

    public ServerFrame() {
        setFrameSize();
        initLabels();
        add(createVerticalBox());
    }

    private void initLabels() {
        serverAction = new JLabel("");
        clientSend = new JLabel("");
    }

    private Box createVerticalBox() {
        Box box = Box.createVerticalBox();
        box.add(serverAction);
        box.add(Box.createVerticalStrut(10));
        box.add(clientSend);
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
