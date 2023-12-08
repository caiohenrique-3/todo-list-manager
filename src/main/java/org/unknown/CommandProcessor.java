package org.unknown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        System.out.println("\n\u2705 New task successfully created!\n");
    }

    private void printAllTasks(){
        taskManager.showAll();
    }

    private void printPendingTasks(){
        taskManager.showPending();
    }
    
    private void printCompleteTasks(){
        taskManager.showComplete();
    }

    private int extractTaskId(String command) {
        // Use regex to match and extract the numeric part of the command
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(command);

        // Find the first occurrence of a numeric sequence in the command
        if (matcher.find()) {
            // Return the matched numeric part as an integer
            return Integer.parseInt(matcher.group());
        } else {
            // Handle the case where no numeric part is found (return an appropriate default or throw an exception)
            throw new IllegalArgumentException("Invalid command format");
        }
    }

    private void updateTaskStatus(int taskId) {
        taskManager.completeTask(taskId);
    }

    private void deleteTask(int taskId){
        taskManager.deleteTask(taskId);
    }

    public void processCommands(){
        boolean quit = false;
        while (!quit){
            String userInput = getUserInput();
            String[] parts = userInput.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            switch (command){
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
                case "--l":
                    if ("pending".equals(argument)){
                        printPendingTasks();
                    } else if ("done".equals(argument)) {
                       printCompleteTasks();
                    } else {
                        printAllTasks();
                    }
                    break;

                case "--done":
                case "--d":
                    if (argument != null){
                        int taskId = extractTaskId(userInput);
                        updateTaskStatus(taskId);
                    }
                    break;

                case "--trash":
                case "--t":
                    if (argument != null){
                        int taskId = extractTaskId(userInput);
                        deleteTask(taskId);
                    }
                    break;
            }
        }
    }
}