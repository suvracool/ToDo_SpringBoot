package com.example.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    // List to store todos
    private static List<Todo> todos = new ArrayList<>();
    // Counter to generate unique IDs for todos
    private static int todosCount = 0;

    // Find todos by username
    public List<Todo> findByUsername(String username){
        // Define a predicate to filter todos by username
        Predicate <? super Todo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username) ;
        // Use a stream to filter todos based on the predicate and collect them into a list
        return todos.stream().filter(predicate).toList();
    }

    // Add a new todo
        public void addTodo(String username,String description,LocalDate targetDate,boolean isDone){
        // Create a new todo with a unique ID and provided details
        Todo todo = new Todo(++todosCount,username,description,targetDate,isDone);
        // Add the todo to the list
        todos.add(todo);
    }



    // Delete a todo by its ID
    public void deleteById(int id) {
        // Define a predicate to find the todo by ID and remove it
        Predicate<? super Todo> predicate = todo -> todo.getId() ==id;
                todos.removeIf(predicate);
    }

    // Find a todo by its ID
    public Todo findById(int id) {
        // Define a predicate to find the todo by ID and retrieve the first matching todo
        Predicate<? super Todo> predicate = todo -> todo.getId() ==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    // Update a todo
    public void updateTodo(Todo todo) {
        // Delete the existing todo by ID
        deleteById(todo.getId());
        // Add the updated todo to the list
        todos.add(todo);
    }
}
