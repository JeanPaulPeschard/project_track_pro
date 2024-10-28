package com.jeanpaulpeschard.projecttrackpro.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private LocalDate dueDate;

       // Getters and Setters
        // Getter for name
        public String getTitle() {
            return title;
        }
    
        // Setter for name
        public void setTitle(String title) {
            this.title= title;
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
        public String getStatus(){
            return status;
        }
    
        // Setter for status
        public void setStatus(String status) {
            this.status = status;
        }

         // Getter for LocalDate
         public LocalDate getDueDate(){
            return dueDate;
        }

        // Setter for LocalDate
        public void setDueDate(LocalDate newDueDate){
            this.dueDate = newDueDate;
        }

    
}
