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
        System.out.println("\n\u2728 Create a New Task \u2728");
        System.out.println("-----------------------");

        System.out.print("\uD83D\uDCDD Task Name: ");
        String taskName = getUserInput();

        System.out.print("\uD83D\uDCDA Description: ");
        String description = getUserInput();

        System.out.print("\u23F0 Deadline: ");
        String deadline = getUserInput();

        System.out.println("\uD83E\uDDD0 (1) In progress | (2) Not completed: ");
        int completionStatusChoice = getUserInt();

        CompletionStatus completionStatus;

        if (completionStatusChoice == 1){
            completionStatus = CompletionStatus.IN_PROGRESS;
        } else {
            completionStatus = CompletionStatus.NOT_COMPLETED;
        }

        Task newTask = new Task(taskName, description, deadline, completionStatus);
        taskManager.addTask(newTask);

        System.out.println("\u2705 New task successfully created!\n");
    }

    private void printAllTasks(){
        taskManager.showAll();
    }

    private void printPendingTasks(){
        taskManager.showPending();
    }

    public void processCommands(){
        boolean quit = false;
        while (!quit){
            String userInput = getUserInput();

            switch (userInput){
                case "--quit":
                case "--q":
                    quit = true;
                    break;

                case "--clear":
                case "--c":
                    clearConsole();
                    break;

                case "--new":
                case "--n":
                   addNewTask();
                   break;

                case "--list":
                case "--list all":
                case "--l":
                case "--l all":
                    printAllTasks();
                    break;
                case "--list pending":
                case "--l pending":
                    printPendingTasks();
                    break;
            }
        }
    }
}