package com.example.freshupnew.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.freshupnew.Model.ProductListModel;
import com.example.freshupnew.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    List<ProductListModel.Detail> list;
    Select select;

    public interface Select {
        void Choose(int position);

    }


    public ProductListAdapter(List<ProductListModel.Detail> list, Select select)
    {
        this.list = list;
        this.select=select;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
         View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list_layout,viewGroup,false);
         final MyViewHolder  myViewHolder=new MyViewHolder(view);
//         myViewHolder.productsList.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 select.Choose(i);
//             }
//         });
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
//        myViewHolder.text.setText(list.get(i).getText());
//        myViewHolder.image.setImageResource(list.get(i).getImage());
        myViewHolder.text.setText(list.get(i).getTitle());
        Picasso.get().load(list.get(i).getImage()).into(myViewHolder.image);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView text;
        RecyclerView productDetailRecyclerview;
        Button product_detail;
        RelativeLayout productsList;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.productsImage);
            text=itemView.findViewById(R.id.productName);
            productDetailRecyclerview=itemView.findViewById(R.id.productDetailRecyclerview);
            productsList=itemView.findViewById(R.id.productsListContainer);
            productsList.setOnClickListener(this);
//            product_detail=itemView.findViewById(R.id.product_detail);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.productsListContainer:
                    select.Choose(getLayoutPosition());
                    break;

            }

        }
    }
}
