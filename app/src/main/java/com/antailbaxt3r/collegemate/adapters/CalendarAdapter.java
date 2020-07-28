package com.antailbaxt3r.collegemate.adapters;

import android.view.View;
import android.widget.TextView;

import com.antailbaxt3r.collegemate.databinding.CalendarDayLayoutBinding;
import com.kizitonwose.calendarview.model.CalendarDay;
import com.kizitonwose.calendarview.ui.DayBinder;
import com.kizitonwose.calendarview.ui.ViewContainer;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class CalendarAdapter implements DayBinder<CalendarAdapter.DayViewContainer> {
    CalendarDayLayoutBinding binding;

    @Override
    public void bind(@NotNull DayViewContainer dayViewContainer, @NotNull CalendarDay calendarDay) {
        dayViewContainer.textView.setText(String.valueOf(calendarDay.getDate().getDayOfMonth()));
    }

    @NotNull
    @Override
    public DayViewContainer create(@NotNull View view) {
        return new DayViewContainer(view);
    }

    public class DayViewContainer extends ViewContainer{
        TextView textView;
        public DayViewContainer(@NotNull View view) {
            super(view);
            binding = CalendarDayLayoutBinding.bind(view);
            textView = binding.text;
        }
    }

}
