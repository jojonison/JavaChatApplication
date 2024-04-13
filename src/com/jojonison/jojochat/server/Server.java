package com.jojonison.jojochat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        Socket clientSocket;
        System.out.println("Server started at: ");
        System.out.println("Port: " + serverSocket.getLocalPort());
        System.out.println("Address: " + serverSocket.getInetAddress());
        try {
            while (!serverSocket.isClosed()) {
                clientSocket = serverSocket.accept();
                System.out.println("A client has connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServer();
        }
    }

    public void closeServer() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
