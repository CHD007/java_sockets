package ru.spb.etu.server;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final static Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final static String SERVER_WAIT = "Server is waiting for connection...";
    private final static String CLIENT_CONNECT = "Client connected to the server";
    private final static String SERVER_WAIT_NEW_DATA = "Server is waiting for new data...";
    private final static String CLOSE = "Connection with the client is closed";
    private final static int PORT = 6666;
    private static ServerFrame serverFrame;

    public static void main(String[] ar) {
        serverFrame = new ServerFrame();
        serverFrame.setTitle("Сервер");
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverFrame.setVisible(true);
        serverFrame.getServerAction().setText(SERVER_WAIT);
        try (ServerSocket ss = new ServerSocket(PORT);
             Socket socket = ss.accept();
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            serverFrame.getServerAction().setText(CLIENT_CONNECT);
            serveClient(in, out);
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error while writing in stream", exception);
        } finally {
            System.out.println(CLOSE);
        }
    }

    private static void serveClient(DataInputStream in, DataOutputStream out) {
        do {
            try {
                switch (in.readInt()) {
                    case 1:
                        int triangleHeight = in.readInt();
                        System.out.println("Triangle height is " + triangleHeight);
                        int triangleSide = in.readInt();
                        System.out.println("Triangle side is " + triangleSide);
                        serverFrame.getClientSend().setText("Client send: " + triangleHeight + " and " + triangleSide);
                        out.writeDouble((triangleHeight * triangleSide) / 2);
                        out.flush();
                        break;

                    case 2:
                        int rhombusHeight = in.readInt();
                        System.out.println("rhombus height is " + rhombusHeight);
                        int rhombusSide = in.readInt();
                        System.out.println("rhombus side is " + rhombusSide);
                        serverFrame.getClientSend().setText("Client send: " + rhombusHeight + " and " + rhombusSide);
                        out.writeDouble(rhombusHeight * rhombusSide);
                        out.flush();
                        break;

                    case 3:
                        int fistSideRectangle = in.readInt();
                        System.out.println("rhombus height is " + fistSideRectangle);
                        int secondSideRectangle = in.readInt();
                        System.out.println("rhombus side is " + secondSideRectangle);
                        serverFrame.getClientSend().setText("Client send: " +  fistSideRectangle + " and " + secondSideRectangle);
                        out.writeDouble(2*fistSideRectangle + 2*secondSideRectangle);
                        out.flush();
                        break;

                    case 4:
                        int orbRadius = in.readInt();
                        System.out.println("Orb radius is " + orbRadius);
                        serverFrame.getClientSend().setText("Client send: " + orbRadius);
                        out.writeDouble((4/3) * (Math.PI * Math.pow(orbRadius, 3)));
                        out.flush();
                        break;
                    case 0:
                        return;
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error", e);
                System.exit(0);
            }
            serverFrame.getServerAction().setText(SERVER_WAIT_NEW_DATA);
        } while (true);
    }

}
