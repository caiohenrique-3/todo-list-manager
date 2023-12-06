package org.unknown;

import java.util.Scanner;

// Handle the processing of user commands
// Should take user input as a parameter and execute
// the appropriate action based on the command.

// This functions calls the Task Manager class to perform
// the actual logic associated with each command.
public class CommandProcessor {

    private Scanner scanner;
    private TaskManager taskManager;

    public CommandProcessor(TaskManager taskManager){
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    private int getUserInt(){
        return scanner.nextInt();
    }

    private void clearConsole(){
        System.out.print("\033\143");
        UserInterface ui = new UserInterface();
        ui.drawUI();
        ui = null;
    }

    private void addNewTask(){
        System.out.println("Name:");
        String taskName = getUserInput();

        System.out.println("Description:");
        String description = getUserInput();


        System.out.println("Deadline:");
        String deadline = getUserInput();

        System.out.println("Choose a number:" +
                "(1) In progress | (2) Not completed");

        int completionStatus = getUserInt();

        Task newTask = new Task(taskName, description,
                deadline, completionStatus);
        taskManager.addTask(newTask);

        System.out.println("New task successfully created!");
    }

    private void printAllTasks(){
        taskManager.showAll();
    }

    public void processCommands(){
        boolean quit = false;
        while (!quit){
            String userInput = getUserInput();

            switch (userInput){
                case "--quit":
                    quit = true;
                    break;

                case "--clear":
                    clearConsole();
                    break;

                case "--new":
                   addNewTask();
                   break;

                case "--list":
                    printAllTasks();
                    break;
            }
        }
    }
}