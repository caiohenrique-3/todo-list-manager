package org.unknown;

import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class FileManager {
    private String filename = "saved.txt";

    public boolean checkIfFileExists(){
        File f = new File(filename);
        return (f.exists() && !f.isDirectory());
    }

    public void writeToFile(Task task){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("Task ID: " + task.taskID + "\n");
            writer.write("Task Name: " + task.taskName + "\n");
            writer.write("Description: " + task.description + "\n");
            writer.write("Deadline: " + task.deadline + "\n");
            writer.write("Completion Status: " + task.completionStatus.getDisplay() + "\n\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}