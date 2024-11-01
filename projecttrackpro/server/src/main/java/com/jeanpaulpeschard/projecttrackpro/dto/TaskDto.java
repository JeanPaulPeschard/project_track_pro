package com.jeanpaulpeschard.projecttrackpro.dto;

import java.time.LocalDate;

public class TaskDto {
    private String title;
    private String description;
    private String status;
    
    private LocalDate dueDate;

    // Getter for name
    public String getTitle() {
        return title;
    }

    // Setter for name
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for description
    public void setStatus(String status) {
        this.status = status;
    }

     // Getter for LocalDate
     public LocalDate getDueDate(){
        return dueDate;
    }
}
