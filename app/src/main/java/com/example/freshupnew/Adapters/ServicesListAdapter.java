package com.example.freshupnew.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.freshupnew.Model.ServicesSelectedModel;
import com.example.freshupnew.Model.ServicesListModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesListAdapter extends RecyclerView.Adapter<ServicesListAdapter.MyViewHolder> {
    Context context;
    List<ServicesListModel.Detail> itemlist;
    RecyclerView list;
    List<ServicesSelectedModel> data=new ArrayList<>();
    Select select;
    List<String> listdata = new ArrayList<>();

    public interface Select {
        void Choose(int position);

    }




    public ServicesListAdapter(List<ServicesListModel.Detail> itemlist, Select select) {
        this.itemlist = itemlist;
        this.select=select;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.services_list_layout,viewGroup,false);
         final MyViewHolder myViewHolder=new MyViewHolder(view);
//        myViewHolder.list_count.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                select.Choose(i);
//                myViewHolder.childRecyclerview.setVisibility(View.VISIBLE);
//            }
//        });


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.txtTitle.setText(itemlist.get(i).getTitle());


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.childRecyclerview.setLayoutManager(linearLayoutManager);

//        ServicesSelectedModel servicesSelectedModel =new ServicesSelectedModel("Hair Cut","KWD 6.00");
//        data.add(servicesSelectedModel);
//         servicesSelectedModel =new ServicesSelectedModel("Keratin Front Long Hair","KWD 8.00");
//        data.add(servicesSelectedModel);
//         servicesSelectedModel =new ServicesSelectedModel("Shaving","KWD 8.00");
//        data.add(servicesSelectedModel);
//        servicesSelectedModel =new ServicesSelectedModel("Hair Art","KWD 10.00");
//        data.add(servicesSelectedModel);
        ServicesSelectedAdapter servicesSelectedAdapter=new ServicesSelectedAdapter(itemlist.get(i).getSubSubServices(), new ServicesSelectedAdapter.Select() {
            @Override
            public void Choose(int position) {

            }
        });


        myViewHolder.childRecyclerview.setAdapter(servicesSelectedAdapter);
        myViewHolder.list_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!listdata.contains(itemlist.get(i).getId())) {
                    if (listdata.size() < itemlist.size()) {
                        listdata.add(itemlist.get(i).getId());
                        myViewHolder.childRecyclerview.setVisibility(View.VISIBLE);
                        myViewHolder.down_arrow.setVisibility(View.VISIBLE);
//                        myViewHolder.righ_arrow.setVisibility(View.GONE);
                        myViewHolder.down_arrow.setImageResource(R.drawable.down_arrow);
                    }
                     else {
                        Toast.makeText(context, "close previously once", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    listdata.remove(itemlist.get(i).getId());
                    myViewHolder.childRecyclerview.setVisibility(View.GONE);
//                    myViewHolder.down_arrow.setVisibility(View.GONE);
//                    myViewHolder.righ_arrow.setVisibility(View.VISIBLE);
                    myViewHolder.down_arrow.setImageResource(R.drawable.right_arrow);
                }

            }
        });








//       ServicesSelectedAdapter servicesSelectedAdapter =new ServicesSelectedAdapter();
//       myViewHolder.childRecyclerview.setAdapter(servicesSelectedAdapter);

    }



    @Override
    public int getItemCount() {

        return itemlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle;
        private RecyclerView childRecyclerview;
        RelativeLayout list_count;
        ImageView righ_arrow, down_arrow;
        Button continuebtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.haircuttingRecyclerText);
            childRecyclerview=itemView.findViewById(R.id.childRecyclerview);
            list_count=itemView.findViewById(R.id.list_count);
            list_count.setOnClickListener(this);
//            righ_arrow=itemView.findViewById(R.id.righ_arrow);
            down_arrow=itemView.findViewById(R.id.down_arrow);
            continuebtn=itemView.findViewById(R.id.hairCuttingContinueBtn);



        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.list_count:
                    select.Choose(getLayoutPosition());
                    break;
            }

        }
    }
}
