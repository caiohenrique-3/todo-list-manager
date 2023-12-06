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

    private void clearConsole(){
        System.out.print("\033\143");
        UserInterface ui = new UserInterface();
        ui.drawUI();
        ui = null;
    }

    public void processCommands(){
        boolean quit = false;
        while (!quit){
            String userInput = getUserInput();

            switch (userInput){
                case "--quit":
                    quit = true;

                case "--clear":
                    clearConsole();
            }
        }
    }
}