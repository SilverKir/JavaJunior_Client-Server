package org.example.chat.client.controller;
import org.example.chat.client.model.Client;
import org.example.chat.client.view.ConsoleView;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class App {

    ConsoleView view;

    public void start(){
        try {
            view = new ConsoleView();
            view.set("Введите ваше имя:");
            String name = view.get();
            Socket socket =new Socket("localhost",2500);
            Client client = new Client(socket, name, view);
            InetAddress inetAddress = socket.getInetAddress();
            view.set("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            view.set("Remote IP: " + remoteIp);
            view.set("LocalPort:" + socket.getLocalPort());
            client.listenForMessage();
            client.sendMessage();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
