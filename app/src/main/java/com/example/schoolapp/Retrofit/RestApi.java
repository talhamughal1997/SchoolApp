package com.example.schoolapp.Retrofit;

import com.example.schoolapp.Model.AnnouncementModel;
import com.example.schoolapp.Model.AssignmentModel;
import com.example.schoolapp.Model.AttendanceModel;
import com.example.schoolapp.Model.MarksModel;
import com.example.schoolapp.Model.StatusModel;
import com.example.schoolapp.Model.StudentModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {

    @POST("students/login")
    @FormUrlEncoded
    Call<StudentModel> PostLogin(@Field("username") String username,
                                 @Field("password") String password,
                                 @Field("device_id") String deviceId);

    @POST("students/password_change")
    @FormUrlEncoded
    Call<StatusModel> PasswordChange(@Field("current_password") String currentPassword,
                                     @Field("new_password") String newPassword,
                                     @Field("device_id") String deviceId);

    @POST("students/attendance")
    @FormUrlEncoded
    Call<AttendanceModel> GetAttendance(@Field("month_year") String date,
                                        @Field("device_id") String deviceId);

    @POST("students/assignment")
    @FormUrlEncoded
    Call<AssignmentModel> GetAssignment(@Field("date_assignment") String date,
                                        @Field("device_id") String deviceId);

    @POST("students/marks")
    @FormUrlEncoded
    Call<MarksModel> GetMarks(@Field("subject_id") String sunjectId,
                              @Field("device_id") String deviceId);

    @POST("students/notice")
    @FormUrlEncoded
    Call<AnnouncementModel> GetNotices(@Field("device_id") String deviceId);


}
