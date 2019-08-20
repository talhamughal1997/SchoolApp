package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AssignmentModel {

    @SerializedName("data")
    public Data data;

    public Data getData() {
        return data;
    }

    public class Data {
        @SerializedName("assignments")
        public ArrayList<Assignments> assignmentArrayList;

        public ArrayList<Assignments> getAssignmentArrayList() {
            return assignmentArrayList;
        }
    }

    public static class Assignments {

        @SerializedName("assignmentID")
        String assignmentID;
        @SerializedName("title")
        String title;
        @SerializedName("description")
        String description;
        @SerializedName("deadlinedate")
        String deadlinedate;
        @SerializedName("usertypeID")
        String usertypeID;
        @SerializedName("userID")
        String userID;
        @SerializedName("originalfile")
        String originalfile;
        @SerializedName("file")
        String file;
        @SerializedName("classesID")
        String classesID;
        @SerializedName("schoolyearID")
        String schoolyearID;
        @SerializedName("sectionID")
        String sectionID;
        @SerializedName("subjectID")
        String subjectID;
        @SerializedName("assignusertypeID")
        String assignusertypeID;
        @SerializedName("assignuserID")
        String assignuserID;
        @SerializedName("teacherID")
        String teacherID;
        @SerializedName("type")
        String type;
        @SerializedName("passmark")
        String passmark;
        @SerializedName("finalmark")
        String finalmark;
        @SerializedName("subject")
        String subject;
        @SerializedName("subject_author")
        String subject_author;
        @SerializedName("subject_code")
        String subject_code;
        @SerializedName("teacher_name")
        String teacher_name;
        @SerializedName("create_date")
        String create_date;
        @SerializedName("modify_date")
        String modify_date;
        @SerializedName("create_userID")
        String create_userID;
        @SerializedName("create_username")
        String create_username;
        @SerializedName("create_usertype")
        String create_usertype;

        public String getAssignmentID() {
            return assignmentID;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getDeadlinedate() {
            return deadlinedate;
        }

        public String getUsertypeID() {
            return usertypeID;
        }

        public String getUserID() {
            return userID;
        }

        public String getOriginalfile() {
            return originalfile;
        }

        public String getFile() {
            return file;
        }

        public String getClassesID() {
            return classesID;
        }

        public String getSchoolyearID() {
            return schoolyearID;
        }

        public String getSectionID() {
            return sectionID;
        }

        public String getSubjectID() {
            return subjectID;
        }

        public String getAssignusertypeID() {
            return assignusertypeID;
        }

        public String getAssignuserID() {
            return assignuserID;
        }

        public String getTeacherID() {
            return teacherID;
        }

        public String getType() {
            return type;
        }

        public String getPassmark() {
            return passmark;
        }

        public String getFinalmark() {
            return finalmark;
        }

        public String getSubject() {
            return subject;
        }

        public String getSubject_author() {
            return subject_author;
        }

        public String getSubject_code() {
            return subject_code;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public String getCreate_date() {
            return create_date;
        }

        public String getModify_date() {
            return modify_date;
        }

        public String getCreate_userID() {
            return create_userID;
        }

        public String getCreate_username() {
            return create_username;
        }

        public String getCreate_usertype() {
            return create_usertype;
        }


    }

}
