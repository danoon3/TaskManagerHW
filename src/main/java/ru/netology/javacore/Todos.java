package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected List<String> listOfTasks = new ArrayList<>();

    public void addTask(String task) {
        if (listOfTasks.size() < 7 && !listOfTasks.contains(task)) {
            listOfTasks.add(task);
        }
    }

    public void removeTask(String task) {
        listOfTasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(listOfTasks);

        for (int i = 0; i < listOfTasks.size(); i++) {
            sb.append(listOfTasks.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

}
