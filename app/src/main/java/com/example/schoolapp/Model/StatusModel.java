package com.example.schoolapp.Model;

import com.google.gson.annotations.SerializedName;

public class StatusModel {

    public Result getResult() {
        return result;
    }

    private Result result;

   public class Result {
        @SerializedName("status")
        private String status;

        @SerializedName("response")
        private String response;

        public String getStatus() {
            return status;
        }

        public String getResponse() {
            return response;
        }
    }
}
