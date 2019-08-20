package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

public class StudentModel extends StatusModel {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public class Data {

        @SerializedName("device_id")
        private String device_id;
        @SerializedName("student_data")
        private StudentData student_data;

        public String getDevice_id() {
            return device_id;
        }

        public StudentData getStudent_data() {
            return student_data;
        }

        public class StudentData {
            @SerializedName("studentID")
            private String studentID;
            @SerializedName("name")
            private String name;
            @SerializedName("dob")
            private String dob;
            @SerializedName("device_id")
            private String device_id;
            @SerializedName("username")
            private String username;
            @SerializedName("photo")
            private String photo;
            @SerializedName("phone")
            private String phone;

            public String getStudentID() {
                return studentID;
            }

            public String getName() {
                return name;
            }

            public String getDob() {
                return dob;
            }

            public String getDevice_id() {
                return device_id;
            }

            public String getUsername() {
                return username;
            }

            public String getPhoto() {
                return photo;
            }

            public String getPhone() {
                return phone;
            }
        }
    }
}