package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.connectToServer("{ \"type\": \"ADD\", \"task\": \"Стать крутым Java разработчиком\" }");
    }

    public void connectToServer(String json) {
        try (Socket clientSocket = new Socket("localhost", 8989);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println(json);
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.getMessage();
        }
    }
}