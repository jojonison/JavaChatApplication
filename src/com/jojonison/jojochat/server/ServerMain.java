package com.jojonison.jojochat.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerMain {
    private static final int port = 1234; // TODO config file
    private static final InetAddress ip = InetAddress.getLoopbackAddress();

   public static void main(String[] args) {
       ServerSocket serverSocket = null;
       try {
           serverSocket = new ServerSocket(port, 0, ip);
           Server server = new Server(serverSocket);
           server.startServer();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
