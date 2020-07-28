package com.antailbaxt3r.collegemate.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import com.antailbaxt3r.collegemate.R;
import com.antailbaxt3r.collegemate.adapters.AttendanceRecyclerAdapter;
import com.antailbaxt3r.collegemate.apiControllers.AttendanceCtrl;
import com.antailbaxt3r.collegemate.data.GeneralData;
import com.antailbaxt3r.collegemate.databinding.ActivityAttendanceBinding;
import com.antailbaxt3r.collegemate.models.Attendance;
import com.antailbaxt3r.collegemate.models.AttendanceGetResponseModel;
import com.antailbaxt3r.collegemate.utils.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {
    ActivityAttendanceBinding binding;
    List<Attendance> attendances = new ArrayList<>();
    SharedPrefs prefs;
    AttendanceRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefs= new SharedPrefs(this);
        setSupportActionBar(binding.toolbar);

        loadData();
    }

    void loadData(){
        AttendanceCtrl.getAttendance(prefs.getToken(), new Callback<AttendanceGetResponseModel>() {
            @Override
            public void onResponse(Call<AttendanceGetResponseModel> call, Response<AttendanceGetResponseModel> response) {
                if(response.isSuccessful()){
                    attendances = response.body().getAttendances();
                    setUpRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<AttendanceGetResponseModel> call, Throwable t) {

            }
        });
    }

    void setUpRecyclerView(){
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AttendanceRecyclerAdapter(attendances,this);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        loadData();
        super.onRestart();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}