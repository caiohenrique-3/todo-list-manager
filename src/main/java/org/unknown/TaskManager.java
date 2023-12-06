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

    public TaskManager(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void showAll(){
        System.out.println("\n\uD83D\uDCDA Total number of tasks: " + tasks.size());
        System.out.println("-----------------------\n");

        for (Task task : tasks) {
            System.out.println("\uD83D\uDCD1 Task ID: " + task.taskID);
            System.out.println("\uD83D\uDCDD Task Name: " + task.taskName);
            System.out.println("\uD83D\uDCDA Task Description: " + task.description);
            System.out.println("\u23F0 Task Deadline: " + task.deadline);
            System.out.println("\uD83D\uDD22 Task Completion Status: " + task.completionStatus);
            System.out.println("-----------------------\n");
        }
    }
}
