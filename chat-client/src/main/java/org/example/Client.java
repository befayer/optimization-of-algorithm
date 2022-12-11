package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5555;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private String clientName = "";

    public String getClientName() {
        return this.clientName;
    }

    public Client(String clientName) {

        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
            this.clientName = clientName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            Scanner scanner = new Scanner(System.in);
            String message;

            @Override
            public void run() {
                try {
                    while (true){
                        message = scanner.nextLine();
                        sendMessage(message, getClientName());
                    }
                } catch (Exception e) {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (true) {
                        if (inMessage.hasNext()) {
                            String inMes = inMessage.nextLine();
                            String clientsInChat = "Пользователей в чате: ";
                            if (inMes.indexOf(clientsInChat) == 0) {
                                System.out.println(inMes);
                            } else {
                                System.out.println(inMes + "\n");
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    public void sendMessage(String message, String clientName) {
        outMessage.println(clientName + ": " + message);
        outMessage.flush();
    }
}
