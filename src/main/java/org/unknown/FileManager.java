package org.unknown;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class FileManager {
    private String filename = "saved.txt";

    public boolean checkIfFileExists() {
        File f = new File(filename);
        return (f.exists() && !f.isDirectory());
    }

    public List<Task> readFromFile() {
        List<Task> tasks = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Task ID: ")) {
                    int taskID = Integer.parseInt(line.substring(9));
                    String taskName = reader.readLine().substring(11);
                    String description = reader.readLine().substring(13);
                    String deadline = reader.readLine().substring(10);

                    CompletionStatus completionStatus = CompletionStatus.
                            valueOf(reader.readLine().substring(19).
                                    replace(" ", "_").
                                    toUpperCase());

                    tasks.add(new Task(taskName, description,
                            deadline, completionStatus));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tasks;
    }

    public void writeToFile(Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("Task ID: " + task.taskID + "\n");
            writer.write("Task Name: " + task.taskName + "\n");
            writer.write("Description: " + task.description + "\n");
            writer.write("Deadline: " + task.deadline + "\n");
            writer.write("Completion Status: " + task.completionStatus.
                    name() + "\n\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeAllToFile(List<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false)); // overwrite the file
            for (Task task : tasks) {
                writer.write("Task ID: " + task.taskID + "\n");
                writer.write("Task Name: " + task.taskName + "\n");
                writer.write("Description: " + task.description + "\n");
                writer.write("Deadline: " + task.deadline + "\n");
                writer.write("Completion Status: " + task.completionStatus.name() + "\n\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}