package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AttendanceModel implements Serializable {

    @SerializedName("data")
    public Data data;

    public static class Data {

        @SerializedName("total_absent")
        public int total_absent;
        @SerializedName("total_present")
        public int total_present;
        @SerializedName("attendances")
        public List<Attendances> attendances;

        public int getTotal_absent() {
            return total_absent;
        }

        public int getTotal_present() {
            return total_present;
        }

        public List<Attendances> getAttendances() {
            return attendances;
        }

        public static class Attendances {
            @SerializedName("attendanceID")
            public String attendanceID;
            @SerializedName("studentID")
            public String studentID;
            @SerializedName("monthyear")
            public String monthyear;
            @SerializedName("a1")
            public String a1;
            @SerializedName("a2")
            public String a2;
            @SerializedName("a3")
            public String a3;
            @SerializedName("a4")
            public String a4;
            @SerializedName("a5")
            public String a5;
            @SerializedName("a6")
            public String a6;
            @SerializedName("a7")
            public String a7;
            @SerializedName("a8")
            public String a8;
            @SerializedName("a9")
            public String a9;
            @SerializedName("a10")
            public String a10;
            @SerializedName("a11")
            public String a11;
            @SerializedName("a12")
            public String a12;
            @SerializedName("a13")
            public String a13;
            @SerializedName("a14")
            public String a14;
            @SerializedName("a15")
            public String a15;
            @SerializedName("a16")
            public String a16;
            @SerializedName("a17")
            public String a17;
            @SerializedName("a18")
            public String a18;
            @SerializedName("a19")
            public String a19;
            @SerializedName("a20")
            public String a20;
            @SerializedName("a21")
            public String a21;
            @SerializedName("a22")
            public String a22;
            @SerializedName("a23")
            public String a23;
            @SerializedName("a24")
            public String a24;
            @SerializedName("a25")
            public String a25;
            @SerializedName("a26")
            public String a26;
            @SerializedName("a27")
            public String a27;
            @SerializedName("a28")
            public String a28;
            @SerializedName("a29")
            public String a29;
            @SerializedName("a30")
            public String a30;
            @SerializedName("a31")
            public String a31;


        }
    }
}
