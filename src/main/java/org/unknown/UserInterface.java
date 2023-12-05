package org.unknown;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void drawUI() {
        boolean quit = false;
        printMenu();

        while (!quit){
            String userInput = getUserInput();
            switch (userInput){
                case "--quit":
                    quit = true;

                case "--clear":
                    clearConsole();
                    printMenu();
            }
        }
    }

    private void printMenu() {
        System.out.println("\n+----------------------------------------------------+");
        System.out.println("|             Todo List Manager                      |");
        System.out.println("|                                                    |");
        System.out.println("| --new: Add a new todo item                         |");
        System.out.println("| --list [all | pending | done]: List the todo items |");
        System.out.println("| --done [id]: Update a todo item                    |");
        System.out.println("| --delete [id]: Delete a todo item                  |");
        System.out.println("| --help: List all the available options             |");
        System.out.println("| --version: Print the version of the application    |");
        System.out.println("| --clear: Clears the console                        |");
        System.out.println("| --quit: Closes the application                     |");
        System.out.println("|                                                    |");
        System.out.println("+----------------------------------------------------+");
        System.out.println();
    }
    public String getUserInput() {
        return scanner.nextLine();
    }

    public void clearConsole(){
        System.out.print("\033\143");
    }
}