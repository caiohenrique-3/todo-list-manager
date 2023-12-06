package org.unknown;

import java.util.concurrent.atomic.AtomicInteger;

// Represent individual tasks.
// It should have attributes like task name, description, deadline,
// and completion status.

enum CompletionStatus {
    IN_PROGRESS("In progress \uD83D\uDD04"),
    NOT_COMPLETED("Not completed \u274C"),
    COMPLETED("Completed \u2713");
    private final String display;

    CompletionStatus(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
}

public class Task {
    private static final AtomicInteger count = new AtomicInteger(0);
    public int taskID;
   public String taskName;
    public String description;
    public String deadline;
    public CompletionStatus completionStatus;

    Task(String taskName, String description,
         String deadline, CompletionStatus completionStatus){
        this.taskID = count.incrementAndGet();
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.completionStatus = completionStatus;
    }
}