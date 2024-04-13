package com.jojonison.jojochat.client;

import com.jojonison.jojochat.common.BroadcastMsg;
import com.jojonison.jojochat.common.DirectMsg;
import com.jojonison.jojochat.common.Response;
import com.jojonison.jojochat.common.User;
import jdk.jfr.consumer.RecordedStackTrace;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Queue;

public class Client {
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private User user;
    private Queue<Object> msgQueue;

    public Client(Socket socket, User user) {
        try {
            this.socket = socket;
            this.user = user;
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendLoginDetails(User user) {
        try {
            out.writeObject(user);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void receiveData() {
        new Thread(() -> {
            Object data;
            while (socket.isConnected()) {
                try {
                    data = in.readObject();
                    if (data instanceof BroadcastMsg) {
                        // TODO
                        msgQueue.add(data);
                    }
                    if (data instanceof DirectMsg) {
                        // TODO
                        msgQueue.add(data);
                    }
                    if (data instanceof Response) {
                        // TODO for example if log in is invalid
                        msgQueue.add(data);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void bookmark(User user) {}
    public void createGC() {}
    public void joinGC() {}
    public void directMessage() {}
    public void changePassword() {}
    public void changeStatus() {}
    public void sendFile() {}

    public void closeAll(Socket socket, ObjectOutputStream out, ObjectInputStream in) {
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

    public void setUser(User user) {
        this.user = user;
    }
}
