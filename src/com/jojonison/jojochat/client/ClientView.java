package com.jojonison.jojochat.client;

import com.jojonison.jojochat.common.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientView extends Component {
    Client client;

    private static final JFrame frame = new JFrame();
    private static final JPanel panelContainer = new JPanel(new BorderLayout());
    private static final JPanel panelButton = new JPanel();
    public static final CardLayout card = new CardLayout();

    private static final JButton logInButton = new JButton("Log In");
    private static final JTextField usernameLogIn = new JTextField(20);
    private static final JPasswordField passwordLogIn = new JPasswordField(20);

    private static final JPanel headerButtons = new JPanel();
    private static final JPanel footerButtons = new JPanel();
    private static final JPanel logInForm = new JPanel();
    private static final JPanel homePanel = new JPanel();
    private static final JPanel directMessagePanel = new JPanel();
    private static final JPanel conferencePanel = new JPanel();

    private static final JTextField broadcastBox = new JTextField();
    private static final JButton sendBroadcastMsg = new JButton("Broadcast");
    private static final JTextField sendMsgBox = new JTextField();
    private static final JButton sendMsg = new JButton("Send");
    private static final JTextField conferenceMsgBox = new JTextField();
    private static final JButton conferenceMsg = new JButton("Send");

    public static final JMenuBar back = new JMenuBar();
    public static final JMenu backMenu = new JMenu("Menu");
    public static final JMenuItem backToTimer = new JMenuItem("Back To Home");
    public static final JMenuItem logOut = new JMenuItem("Log Out");

    public ClientView(InetAddress address, int port) {
        try {
            client = new Client(new Socket(address, port), null);
            setUpLogInButtons();
            setUpHomePanel();
            setUpDirectMessagePanel();
            setUpConferencePanel();
            setUpCardLayout();
            setUpFrame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setUpFrame() {
    }

    private void setUpCardLayout() {
    }

    private void setUpConferencePanel() {
    }

    private void setUpDirectMessagePanel() {
    }

    private void setUpHomePanel() {
    }

    private void setUpLogInButtons() {
        User user = new User(0, "GOD", "GOD", false, null);
        client.setUser(user);
    }

}
