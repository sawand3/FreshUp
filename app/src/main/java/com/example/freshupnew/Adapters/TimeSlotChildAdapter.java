package com.example.freshupnew.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.freshupnew.Model.TimeSlotChildModel;
import com.example.freshupnew.R;
import java.util.List;

public class TimeSlotChildAdapter extends RecyclerView.Adapter<TimeSlotChildAdapter.MyViewHolder> {
    Context context;
    List<TimeSlotChildModel> list;
    Select select;

    public interface Select {
        void Choose(int position);

    }


    public TimeSlotChildAdapter(List<TimeSlotChildModel> list, Select select) {
        this.context = context;
        this.list = list;
        this.select=select;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.services_time_slot_child_layout,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.time.setText(list.get(i).getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView time;
        RelativeLayout time_slot_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.time_slot);
            time_slot_layout=itemView.findViewById(R.id.time_slot_layout);
            time_slot_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.time_slot_layout:
                    select.Choose(getLayoutPosition());
                    break;
            }
        }
    }
}
