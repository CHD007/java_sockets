package ru.spb.etu.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIMain {
    private final static Logger LOGGER = Logger.getLogger(GUIMain.class.getName());
    private final static int PORT = 6666;
    private final static String ADDRESS = "127.0.0.1";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread waiterForAnswer;

    public void connectAndShowFrame() {
        if (connect()) {
            createAndStartThreadForWaitingAnAnswer();
            EventQueue.invokeLater(() -> {
                        MainFrame frame = new MainFrame();
                        frame.getOkButton().addActionListener((actionEvent) -> {
                            try {
                                if (frame.validateFields()) {
                                    GeometricAction selectedItem = (GeometricAction) frame.getActionsComboBox().getSelectedItem();
                                    out.writeInt(selectedItem.getId());
                                    switch (selectedItem) {
                                        case TRIANGLE_AREA:
                                        case ROMBUS_AREA:
                                        case REACTANGLE_PERIMETER:
                                            out.writeInt(((Number)frame.getTextFieldFirstValue().getValue()).intValue());
                                            out.writeInt(((Number)frame.getTextFieldSecondValue().getValue()).intValue());
                                            frame.getTextFieldFirstValue().setValue(null);
                                            frame.getTextFieldSecondValue().setValue(null);
                                            break;
                                        case ORB_VALUE:
                                            out.writeInt(((Number)frame.getTextFieldFirstValue().getValue()).intValue());
                                            frame.getTextFieldFirstValue().setValue(null);
                                            break;
                                    }
                                }
                            } catch (IOException e) {
                                LOGGER.log(Level.SEVERE, "Error while writing in stream", e);
                            }
                        });
                        frame.setTitle("Калькулятор");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                waiterForAnswer.interrupt();
                            }
                        });
                        frame.setVisible(true);
                    }
            );
        }
    }

    private void createAndStartThreadForWaitingAnAnswer() {
       waiterForAnswer = new Thread(() -> {
            try {
                while (true) {
                    double answer = in.readDouble();
                    JOptionPane.showMessageDialog(null, "Server answer is " + answer);
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error while writing in stream", e);
            }
        });
        waiterForAnswer.start();
    }

    private Optional<InetAddress> getInetAddress() {
        try {
            InetAddress ipAddress = InetAddress.getByName(ADDRESS);
            return Optional.of(ipAddress);
        } catch (UnknownHostException exception) {
            LOGGER.log(Level.SEVERE, "Error while getting host name", exception);
        }
        return Optional.empty();
    }

    private boolean connect() {
        Optional<InetAddress> inetAddress = getInetAddress();
        if (inetAddress.isPresent()) {
            try {
                socket = new Socket(inetAddress.get(), PORT);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                return true;
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Ошибка подключения к серверу");
                LOGGER.log(Level.SEVERE, "Exception while writing in stream", exception);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ошибка подключения к серверу");
            return false;
        }
    }
}
