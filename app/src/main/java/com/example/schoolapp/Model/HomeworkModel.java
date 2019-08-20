package com.example.schoolapp.Model;

public class HomeworkModel {
    public HomeworkModel(String date, String day, String book, String subject, String priority) {
        this.date = date;
        this.day = day;
        this.book = book;
        this.subject = subject;
        this.priority = priority;
    }

    public String date, day, book, subject, priority;
}
