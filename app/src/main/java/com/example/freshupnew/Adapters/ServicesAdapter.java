package com.example.freshupnew.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.freshupnew.Model.ServicesModel;
import com.example.freshupnew.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {
    List<ServicesModel.Detail> list;
    public static Select select;

    public interface Select {
        void Choose(int position);

    }

    public ServicesAdapter(List<ServicesModel.Detail> list, Select select) {
        this.list=list;
        this.select=select;



    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.services_layout,viewGroup,false);
        final  MyViewHolder  myViewHolder=new MyViewHolder(view);
//        myViewHolder.servicesContainer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                select.Choose(i);
//
//            }
//        });

        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
//        myViewHolder.backgroundImage.setImageResource(list.get(i).getBackgroundImage());
//        myViewHolder.frontImage.setImageResource(list.get(i).getFrontImage());
//        myViewHolder.serviceText.setText(list.get(i).getText());

        Picasso.get().load(list.get(i).getImage1()).into(myViewHolder.frontImage);
        Picasso.get().load(list.get(i).getImage2()).into(myViewHolder.backgroundImage);
        myViewHolder.serviceText.setText(list.get(i).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView backgroundImage;
        ImageView frontImage;
        TextView serviceText;
        RelativeLayout servicesContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            backgroundImage=itemView.findViewById(R.id.backgroundImage);
            frontImage=itemView.findViewById(R.id.frontImage);
            serviceText=itemView.findViewById(R.id.serviceText);
            servicesContainer=itemView.findViewById(R.id.servicesContainer);
            servicesContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.servicesContainer:
                    select.Choose(getLayoutPosition());
                    break;
            }

        }
    }
}
