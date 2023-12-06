package org.unknown;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.drawUI();
        ui = null;
        TaskManager tm = new TaskManager();
        CommandProcessor cp = new CommandProcessor(tm);
        cp.processCommands();
    }
}