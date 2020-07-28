package com.antailbaxt3r.collegemate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attendance {
    @SerializedName("attendance_id")
    @Expose
    int attendanceId;
    @SerializedName("subject_id")
    @Expose
    int subjectId;
    @SerializedName("is_present")
    @Expose
    int isPresent;
    @SerializedName("date")
    @Expose
    String date;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(int isPresent) {
        this.isPresent = isPresent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
