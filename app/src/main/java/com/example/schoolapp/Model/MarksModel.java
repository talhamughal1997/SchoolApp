package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MarksModel {

    @SerializedName("data")
    private Data getData;

    public Data getData() {
        return getData;
    }

    public class Data {

        @SerializedName("marks")
        private ArrayList<Marks> getMarksList;

        public ArrayList<Marks> getMarksList() {
            return getMarksList;
        }

        public class Marks {

            @SerializedName("markID")
            private String markID;
            @SerializedName("schoolyearID")
            private String schoolyearID;
            @SerializedName("examID")
            private String examID;
            @SerializedName("exam")
            private String exam;
            @SerializedName("studentID")
            private String studentID;
            @SerializedName("classesID")
            private String classesID;
            @SerializedName("subjectID")
            private String subjectID;
            @SerializedName("subject")
            private String subject;
            @SerializedName("year")
            private String year;
            @SerializedName("teacherID")
            private String teacherID;
            @SerializedName("type")
            private String type;
            @SerializedName("passmark")
            private String passmark;
            @SerializedName("finalmark")
            private String finalmark;
            @SerializedName("subject_author")
            private String subject_author;
            @SerializedName("subject_code")
            private String subject_code;
            @SerializedName("teacher_name")
            private String teacher_name;
            @SerializedName("create_date")
            private String create_date;
            @SerializedName("modify_date")
            private String modify_date;
            @SerializedName("create_userID")
            private String create_userID;
            @SerializedName("create_username")
            private String create_username;
            @SerializedName("create_usertype")
            private String create_usertype;
            @SerializedName("markrelationID")
            private String markrelationID;
            @SerializedName("markpercentageID")
            private String markpercentageID;
            @SerializedName("mark")
            private String mark;


            public String getMarkID() {
                return markID;
            }

            public String getSchoolyearID() {
                return schoolyearID;
            }

            public String getExamID() {
                return examID;
            }

            public String getExam() {
                return exam;
            }

            public String getStudentID() {
                return studentID;
            }

            public String getClassesID() {
                return classesID;
            }

            public String getSubjectID() {
                return subjectID;
            }

            public String getSubject() {
                return subject;
            }

            public String getYear() {
                return year;
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

            public String getMarkrelationID() {
                return markrelationID;
            }

            public String getMarkpercentageID() {
                return markpercentageID;
            }

            public String getMark() {
                return mark;
            }

        }
    }
}
