package com.antailbaxt3r.collegemate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antailbaxt3r.collegemate.data.GeneralData;
import com.antailbaxt3r.collegemate.databinding.RecyclerAttendanceBinding;
import com.antailbaxt3r.collegemate.models.Attendance;
import com.antailbaxt3r.collegemate.models.Subject;
import com.kizitonwose.calendarview.CalendarView;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AttendanceRecyclerAdapter extends RecyclerView.Adapter<AttendanceRecyclerAdapter.ViewHolder> {
    List<Attendance> data;
    Context context;

    RecyclerAttendanceBinding binding;

    List<Subject> subjects = GeneralData.getSubjects();

    public AttendanceRecyclerAdapter(List<Attendance> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RecyclerAttendanceBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YearMonth currentMonth = YearMonth.now();
        YearMonth firstMonth = currentMonth.minusMonths(0);
        YearMonth lastMonth = currentMonth.plusMonths(0);
        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
        holder.subject.setText(subjects.get(position).getSubjectTitle());
        holder.calendarView.setDayBinder(new CalendarAdapter());
        holder.calendarView.setup(firstMonth,lastMonth,firstDayOfWeek);
        holder.calendarView.scrollToMonth(currentMonth);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView subject;
        CalendarView calendarView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = binding.subject;
            calendarView = binding.calendarView;
        }
    }
}
