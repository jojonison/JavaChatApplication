package com.jojonison.jojochat.server;

import com.jojonison.jojochat.common.BroadcastMsg;
import com.jojonison.jojochat.common.Response;
import com.jojonison.jojochat.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    public Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private User user;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            closeAll(socket, out, in);
        }
    }

    public void run() {
        while (socket.isConnected()) {
            try {
                Object receivedData = in.readObject();
                if (receivedData instanceof BroadcastMsg) {
                    broadcast((BroadcastMsg) receivedData);
                }
                if (receivedData instanceof User) {
                    logIn((User) receivedData);
                }
            } catch (IOException | ClassNotFoundException e) {
                closeAll(socket, out, in);
            }
        }
    }

    public void logIn(User user) {
        // TODO
    }

    public void sendResponse(Response response) {

    }

    public void broadcast(BroadcastMsg msg) {
        for (ClientHandler handler : clientHandlers) {
            try {
                if (!handler.user.getUsername().equals(this.user.getUsername())) {
                    handler.out.writeObject(msg);
                    handler.out.flush();
                }
            } catch (IOException e) {
                closeAll(socket, out, in);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
    }

    public void closeAll(Socket socket, ObjectOutputStream out, ObjectInputStream in) {
        removeClientHandler();
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
