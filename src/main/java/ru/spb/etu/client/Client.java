package ru.spb.etu.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());
    private final static int PORT = 6666;
    private final static String ADDRESS = "127.0.0.1";
    private final static String CONNECTION_SUCCESSFUL = "Connection to the server was successful";
    private final static String CONNECTION_CLOSE = "Connection with the server is closed";
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] ar) {
        Optional<InetAddress> inetAddress = getInetAddress();
        if (inetAddress.isPresent()) {
            try (Socket socket = new Socket(inetAddress.get(), PORT);
                 DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                System.out.println(CONNECTION_SUCCESSFUL);


                do {
                    scanner.nextLine();
                    scanner.nextLine();
                    clearConsole();
                    printMenu();

                    int menuItem = getNextInt();
                    out.writeInt(menuItem);
                    switch (menuItem) {
                        case 1:
                            System.out.println("Triangle height: ");
                            int triangleHeight = getNextInt();
                            System.out.println("Triangle side: ");
                            out.writeInt(triangleHeight);
                            int triangleSide = getNextInt();
                            out.writeInt(triangleSide);
                            out.flush();
                            double triangleArea = in.readDouble();
                            System.out.println("Triangle area is " + triangleArea);
                            break;
                        case 2:
                            System.out.println("rhombus height: ");
                            int rhombusHeight = getNextInt();
                            System.out.println("rhombus side: ");
                            out.writeInt(rhombusHeight);
                            int rhombusSide = getNextInt();
                            out.writeInt(rhombusSide);
                            out.flush();
                            double rhombusArea = in.readDouble();
                            System.out.println("Rhombus area is " + rhombusArea);
                            break;
                        case 3:
                            System.out.println("first side of rectangle:");
                            int fistSideRectangle = getNextInt();
                            out.writeInt(fistSideRectangle);
                            System.out.println("second side of rectangle:");
                            int secondSideRectangle = getNextInt();
                            out.writeInt(secondSideRectangle);
                            out.flush();
                            double rectangleArea = in.readDouble();
                            System.out.println("Rectangle perimeter is " + rectangleArea);
                            break;
                        case 4:
                            System.out.println("Orb radius:");
                            int orbRadius = getNextInt();
                            out.writeInt(orbRadius);
                            out.flush();
                            double orbValue = in.readDouble();
                            System.out.println("Orb value is " + orbValue);
                            break;
                        case 0:
                            System.out.println(CONNECTION_CLOSE);
                            return;
                        default:
                            System.out.println("Try again");
                            break;
                    }

                } while (true);

            } catch (IOException exception) {
                LOGGER.log(Level.SEVERE, "Exception while writing in stream", exception);
            }
        }
    }

    private static Optional<InetAddress> getInetAddress() {
        try {
            InetAddress ipAddress = InetAddress.getByName(ADDRESS);
            return Optional.of(ipAddress);
        } catch (UnknownHostException exception) {
            LOGGER.log(Level.SEVERE, "Error while getting host name", exception);
        }
        return Optional.empty();
    }

    private static void printMenu() {
        System.out.println("Select one of the menu items: ");
        System.out.println(" 1 - area of a triangle");
        System.out.println(" 2 - area of a rhombus");
        System.out.println(" 3 - perimeter of a rectangle");
        System.out.println(" 4 - volume of a orb");
        System.out.println(" 0 - exit");
    }

    private static int getNextInt() {
        do {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException inputException) {
                System.out.println("Input value should be an integer");
                LOGGER.log(Level.INFO, "Retrying input");
                scanner.nextLine();
            }
        } while (true);
    }

    public final static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}