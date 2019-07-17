package com.example.freshupnew.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.freshupnew.Model.TimeSlotChildModel;
import com.example.freshupnew.Model.TimeSlotModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.MyViewHolder> {
    Context context;
    List<TimeSlotModel> itemlist;
    List<TimeSlotChildModel> data=new ArrayList<TimeSlotChildModel>();
    List<String> listdata = new ArrayList<>();

    public TimeSlotAdapter(List<TimeSlotModel> itemlist) {
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.services_time_slot_barber_name_lauout,viewGroup,false);
        final TimeSlotAdapter.MyViewHolder myViewHolder=new TimeSlotAdapter.MyViewHolder(view);
//        myViewHolder.barber_name_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myViewHolder.barber_child_recyclerview.setVisibility(View.VISIBLE);
//            }
//        });


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.barber_name.setText(itemlist.get(i).getBarberName());


        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false);
        myViewHolder.barber_child_recyclerview.setLayoutManager(gridLayoutManager);

        TimeSlotChildModel timeSlotChildModel=new TimeSlotChildModel("4:00 PM");
        data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
       data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
        data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
        data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
        data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
        data.add(timeSlotChildModel);
        timeSlotChildModel=new TimeSlotChildModel("4:40 PM");
        data.add(timeSlotChildModel);

        TimeSlotChildAdapter timeSlotChildAdapter=new TimeSlotChildAdapter(data, new TimeSlotChildAdapter.Select() {
            @Override
            public void Choose(int position) {

            }
        });
        myViewHolder.barber_child_recyclerview.setAdapter(timeSlotChildAdapter);
        myViewHolder.barber_name_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myViewHolder.barber_child_recyclerview.setVisibility(View.VISIBLE);

            }
        });


    }

    @Override
    public int getItemCount() {

        return itemlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView barber_name;
        RecyclerView barber_child_recyclerview;
        RelativeLayout barber_name_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            barber_name=itemView.findViewById(R.id.barber_name);
            barber_child_recyclerview=itemView.findViewById(R.id.barber_child_recyclerview);
            barber_name_layout=itemView.findViewById(R.id.barber_name_layout);

        }
    }
}
