package com.antailbaxt3r.collegemate.apiControllers;

import com.antailbaxt3r.collegemate.models.Attendance;
import com.antailbaxt3r.collegemate.models.AttendanceGetResponseModel;
import com.antailbaxt3r.collegemate.models.AttendancePostResponseModel;
import com.antailbaxt3r.collegemate.retrofit.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class AttendanceCtrl {

    public static void postAttendance(String token, Attendance attendance, Callback<AttendancePostResponseModel> callback){
        Map<String,String> body = new HashMap<>();
        body.put("date",attendance.getDate());
        body.put("is_present",String.valueOf(attendance.getIsPresent()));
        body.put("subject_id",String.valueOf(attendance.getSubjectId()));

        Call<AttendancePostResponseModel> call = RetrofitClient.getClient().addAttendance(token,body);
        call.enqueue(callback);
    }

    public static void getAttendance(String token, Callback<AttendanceGetResponseModel> callback){
        Call<AttendanceGetResponseModel> call = RetrofitClient.getClient().getAttendance(token);
        call.enqueue(callback);
    }
}
