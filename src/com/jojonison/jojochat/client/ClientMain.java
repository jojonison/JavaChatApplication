package com.jojonison.jojochat.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 1234;
            new ClientView(address, port);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
