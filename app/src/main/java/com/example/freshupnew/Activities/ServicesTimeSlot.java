package com.example.freshupnew.Activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.freshupnew.Adapters.TimeSlotAdapter;
import com.example.freshupnew.Model.TimeSlotModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesTimeSlot extends AppCompatActivity {
    private TextView textTitle;
    RecyclerView list;
    TextView calendarData;
    CalendarView calendarView;

    List<TimeSlotModel> data=new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_time_slot);

        list=findViewById(R.id.time_slot_recyclerview);
        calendarData=findViewById(R.id.calendarData);
        calendarView=findViewById(R.id.calenderview);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth) {
                calendarData.setVisibility(View.VISIBLE);
                calendarData.setText(dayOfMonth+"/"+(month+1)+"/"+year);


            }
        });


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(linearLayoutManager);

        TimeSlotModel timeSlotModel=new TimeSlotModel("HUSHAN");
        data.add(timeSlotModel);
        timeSlotModel=new TimeSlotModel("AFRID");
        data.add(timeSlotModel);


        TimeSlotAdapter timeSlotAdapter=new TimeSlotAdapter(data);
        list.setAdapter(timeSlotAdapter);
    }
}
