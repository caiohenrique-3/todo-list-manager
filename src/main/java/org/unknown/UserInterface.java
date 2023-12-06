package org.unknown;

public class UserInterface {

    public void drawUI() {
        printMenu();
    }

    private void printMenu() {
        System.out.println("\n+------------------------------------------------------+");
        System.out.println("|             Todo List Manager                        |");
        System.out.println("|                                                      |");
        System.out.println("| --(n)ew: Add a new todo item                         |");
        System.out.println("| --(l)ist [all | pending | done]: List the todo items |");
        System.out.println("| --(d)one [id]: Update a todo item                    |");
        System.out.println("| --(t)rash [id]: Delete a todo item                   |");
        System.out.println("| --(c)lear: Clears the console                        |");
        System.out.println("| --(q)uit: Closes the application                     |");
        System.out.println("|                                                      |");
        System.out.println("+------------------------------------------------------+");
        System.out.println();
    }
}