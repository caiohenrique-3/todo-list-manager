package org.unknown;

// Represent individual tasks.
// It should have attributes like task name, description, deadline,
// and completion status.
public class Task {
   public String taskName;
    public String description;
    public String deadline;
    public int completionStatus;

    Task(String taskName, String description,
         String deadline, int completionStatus){
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.completionStatus= completionStatus;
    }

    public void printSurprise(){
        System.out.println("Hello motherfucker!");
    }
}
