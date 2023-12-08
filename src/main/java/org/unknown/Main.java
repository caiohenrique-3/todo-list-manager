package org.unknown;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.drawUI();
        ui = null;
        FileManager fm = new FileManager();
        TaskManager tm = new TaskManager(fm);
        CommandProcessor cp = new CommandProcessor(tm);
        cp.processCommands();
    }
}