package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String json = in.readLine();
                    Gson gson = new Gson();
                    Root root = gson.fromJson(json, Root.class);

                    if (root.getType().equals("ADD")) {
                        todos.addTask(root.getTask());
                        out.println(todos.getAllTasks());
                    } else if (root.getType().equals("REMOVE")) {
                        todos.removeTask(root.getTask());
                        out.println(todos.getAllTasks());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
