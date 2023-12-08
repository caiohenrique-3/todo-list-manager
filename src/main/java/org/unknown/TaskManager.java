package org.unknown;

import java.util.ArrayList;
import java.util.List;

// Include methods for adding tasks, removing tasks,
// marking tasks as complete, and displaying the list of tasks.

// Implement functionality to read and write tasks to a local file.
// This ensures that tasks persist between program runs.
// Use basic file I/O operations like reading
// from and writing to a text file.
public class TaskManager {
    private List<Task> tasks;
    private FileManager fileManager;

    public TaskManager(FileManager fileManager) {
        this.fileManager = fileManager;
        if (fileManager.checkIfFileExists()) {
            this.tasks = fileManager.readFromFile();
            if (!tasks.isEmpty())
                System.out.println("\n[\u2713] Successfully loaded "
                        + tasks.size() + " tasks from last session.\n");
        } else {
            this.tasks = new ArrayList<>();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        fileManager.writeToFile(task);
    }

    public void showAll() {
        System.out.println("\n+-------------------------------------+");
        System.out.println("|                                     |");
        System.out.println("|  \uD83D\uDCDA Total number of tasks: " + tasks.size()
                + "        |");
        System.out.println("|                                     |");
        System.out.println("+-------------------------------------+\n");

        for (Task task : tasks) {
            System.out.println("\uD83D\uDCD1 ID: " + task.taskID);
            System.out.println("\uD83D\uDCDD Name: " + task.taskName);
            System.out.println("\uD83D\uDCDA Description: " + task.description);
            System.out.println("\u23F0 Deadline: " + task.deadline);
            System.out.println("\uD83D\uDD22 Status: " + task.completionStatus);
            System.out.println("-------------------------------------\n");
        }
    }

    public void showPending() {
        int totalTasks = 0;
        for (Task task : tasks) {
            if (task.completionStatus == CompletionStatus.IN_PROGRESS
                    || task.completionStatus == CompletionStatus.NOT_COMPLETED) {
                totalTasks++;
            }
        }

        System.out.println("\n+------------------------------------------+");
        System.out.println("|                                          |");
        System.out.println("|  \uD83D\uDCDA Total number of pending tasks: " + totalTasks
                + "     |");
        System.out.println("|                                          |");
        System.out.println("+------------------------------------------+\n");

        for (Task task : tasks) {
            if (task.completionStatus == CompletionStatus.IN_PROGRESS
                    || task.completionStatus == CompletionStatus.NOT_COMPLETED) {
                System.out.println("\uD83D\uDCD1 ID: " + task.taskID);
                System.out.println("\uD83D\uDCDD Name: " + task.taskName);
                System.out.println("\uD83D\uDCDA Description: " + task.description);
                System.out.println("\u23F0 Deadline: " + task.deadline);
                System.out.println("\uD83D\uDD22 Status: " + task.completionStatus);
                System.out.println("-------------------------------------\n");
            }
        }
    }

    public void showComplete() {
        int totalTasks = 0;
        for (Task task : tasks) {
            if (task.completionStatus == CompletionStatus.COMPLETED) {
                totalTasks++;
            }
        }

        System.out.println("\n+------------------------------------------+");
        System.out.println("|                                          |");
        System.out.println("|  \uD83D\uDCDA Total number of completed tasks: " + totalTasks
                + "   |");
        System.out.println("|                                          |");
        System.out.println("+------------------------------------------+\n");

        for (Task task : tasks) {
            if (task.completionStatus == CompletionStatus.COMPLETED) {
                System.out.println("\uD83D\uDCD1 ID: " + task.taskID);
                System.out.println("\uD83D\uDCDD Name: " + task.taskName);
                System.out.println("\uD83D\uDCDA Description: " + task.description);
                System.out.println("\u23F0 Deadline: " + task.deadline);
                System.out.println("\uD83D\uDD22 Status: " + task.completionStatus);
                System.out.println("-------------------------------------\n");
            }
        }
    }

    public void completeTask(int taskID) {
        boolean taskFound = false;
        for (Task task : tasks) {
            if (task.taskID == taskID) {
                task.completionStatus = CompletionStatus.COMPLETED;
                System.out.println("\n[\u2713] Successfully completed task id: " +
                        taskID + "\n");
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            fileManager.writeAllToFile(tasks);
        } else {
            System.out.println("\n[!] Could not find task id: " + taskID + '\n');
        }
    }

    public void deleteTask(int taskID) {
        boolean taskFound = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).taskID == taskID) {
                tasks.remove(i);
                System.out.println("\n[\u274C] Successfully deleted task id: " +
                        taskID + "\n");
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            fileManager.writeAllToFile(tasks);
        } else {
            System.out.println("\n[!] Could not find task id: " + taskID + '\n');
        }
    }
}