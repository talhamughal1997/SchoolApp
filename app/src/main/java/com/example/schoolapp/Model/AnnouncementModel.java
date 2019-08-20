package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnnouncementModel {

    @SerializedName("data")
    private Data mData;

    public Data getmData() {
        return mData;
    }

    public class Data {

        @SerializedName("notice")
        private ArrayList<Notices> mNotices;

        public ArrayList<Notices> getNotices() {
            return mNotices;
        }

        public class Notices {
            @SerializedName("noticeID")
            private String noticeID;
            @SerializedName("title")
            private String title;
            @SerializedName("notice")
            private String notice;
            @SerializedName("schoolyearID")
            private String schoolyearID;
            @SerializedName("date")
            private String date;
            @SerializedName("create_date")
            private String create_date;

            public String getNoticeID() {
                return noticeID;
            }

            public String getTitle() {
                return title;
            }

            public String getNotice() {
                return notice;
            }

            public String getSchoolyearID() {
                return schoolyearID;
            }

            public String getDate() {
                return date;
            }

            public String getCreate_date() {
                return create_date;
            }
        }

    }
}