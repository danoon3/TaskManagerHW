package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {

    @Test
    void testAdd(){
        Todos todos = new Todos();
        todos.addTask("Погулять с собакой");
        todos.addTask("Сходить в магазин");
        todos.addTask("Почитать книгу");
        String result = todos.getAllTasks();
        String expected = "Погулять с собакой Почитать книгу Сходить в магазин";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testRemove(){
        Todos todos = new Todos();
        todos.addTask("Купить хлеб");
        todos.addTask("Встретиться с друзьями");
        todos.addTask("Запланировать встречу");
        todos.removeTask("Купить хлеб");
        String result = todos.getAllTasks();
        String expected = "Встретиться с друзьями Запланировать встречу";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMaxTaskSize(){
        Todos todos = new Todos();
        todos.addTask("Купить хлеб");
        todos.addTask("Встретиться с друзьями");
        todos.addTask("Запланировать встречу");
        todos.addTask("Погулять с собакой");
        todos.addTask("Сходить в магазин");
        todos.addTask("Почитать книгу");
        todos.addTask("Стать крутым Java разработчиком");
        todos.addTask("Ничего не делать");

        String result = todos.getAllTasks();
        String expected = "Встретиться с друзьями Запланировать встречу Купить хлеб Погулять с собакой Почитать книгу Стать крутым Java разработчиком Сходить в магазин";
        Assertions.assertEquals(expected, result);
    }
}
