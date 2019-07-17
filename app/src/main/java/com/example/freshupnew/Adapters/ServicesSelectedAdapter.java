package com.example.freshupnew.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freshupnew.Model.GetServicesDataModel;
import com.example.freshupnew.Model.ServicesListModel;
import com.example.freshupnew.Model.ServicesSelectedModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesSelectedAdapter extends RecyclerView.Adapter<ServicesSelectedAdapter.ViewHolder> {
    List<GetServicesDataModel.SubSubService> itemlist;
    public static Select select;
    List<String> listdata = new ArrayList<>();
    List<String> serviceName=new ArrayList<>();
    List<Double> price=new ArrayList<>();
    Context context;





    public ServicesSelectedAdapter(List<GetServicesDataModel.SubSubService> subSubServices, Select select) {
        this.select=select;
        this.itemlist=subSubServices;
    }

    public interface Select {
        void Choose(int position);

    }


//    public ServicesSelectedAdapter(List<ServicesListModel.SubSubService> list, Select select) {
//
//       this.list = list;
//       this.select=select;
//
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.services_selected_layout,viewGroup,false);
        final ServicesSelectedAdapter.ViewHolder viewHolder=new ServicesSelectedAdapter.ViewHolder(view);


//        viewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.continueBtn.setVisibility(View.VISIBLE);
//            }
//        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
    viewHolder.txtTitle.setText(itemlist.get(i).getTitle());
    viewHolder.price.setText(itemlist.get(i).getPrice());
    viewHolder.selectedServices.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!listdata.contains(itemlist.get(i).getId())){
                if (listdata.size() < itemlist.size()){
                    listdata.add(itemlist.get(i).getId());
                    serviceName.add(itemlist.get(i).getTitle());
                    price.add(Double.valueOf(itemlist.get(i).getPrice()));
                    viewHolder.remove_service.setImageResource(R.drawable.remove_service);

                }
                else {
                    Toast.makeText(context, "You can choose only two services", Toast.LENGTH_SHORT).show();
                }

            } else {
                listdata.remove(itemlist.get(i).getId());
                serviceName.remove(itemlist.get(i).getTitle());
                price.remove(Double.valueOf(itemlist.get(i).getPrice()));
                viewHolder.remove_service.setImageResource(R.drawable.add_service);
            }

        }
    });

    }

    @Override
    public int getItemCount() {

        return itemlist.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle, price;
        ImageView remove_service, add_service;
        Button continueBtn;
        RelativeLayout selectedServices;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.product_name_haircut);
            price=itemView.findViewById(R.id.product_price_haircut);
            remove_service=itemView.findViewById(R.id.remove_service);
            add_service=itemView.findViewById(R.id.add_service);
            continueBtn=itemView.findViewById(R.id.hairCuttingContinueBtn);
            selectedServices=itemView.findViewById(R.id.selectedServices);
            selectedServices.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.selectedServices:
                    select.Choose(getLayoutPosition());
                    break;

            }
        }
    }
    
}
