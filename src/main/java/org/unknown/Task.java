package org.unknown;

import java.util.concurrent.atomic.AtomicInteger;

// Represent individual tasks.
// It should have attributes like task name, description, deadline,
// and completion status.
public class Task {
    private static final AtomicInteger count = new AtomicInteger(0);
    public int taskID;
   public String taskName;
    public String description;
    public String deadline;
    public int completionStatus;

    Task(String taskName, String description,
         String deadline, int completionStatus){
        this.taskID = count.incrementAndGet();
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.completionStatus= completionStatus;
    }
}
