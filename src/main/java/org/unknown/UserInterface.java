package org.unknown;

public class UserInterface {

    public void drawUI() {
        printMenu();
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
}