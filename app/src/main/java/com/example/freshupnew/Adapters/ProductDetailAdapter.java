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
import com.example.freshupnew.Model.ProductDetailModel;
import com.example.freshupnew.Model.ProductListModel;
import com.example.freshupnew.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.MyViewHolder> {
    List<ProductListModel.Product> list;
    Select select;

    public interface Select {
        void Choose(int position);

    }

    public ProductDetailAdapter(List<ProductListModel.Product> list, Select select) {

        this.list = list;
        this.select=select;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_detail_layout,viewGroup,false);
        final MyViewHolder  myViewHolder=new MyViewHolder(view);
//        myViewHolder.buyProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                select.Choose(i);
//            }
//        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
//        myViewHolder.text.setText(list.get(i).getProductName());
//        myViewHolder.image.setImageResource(list.get(i).getImage());

        ProductListModel.Product product=list.get(i);
        String logo=product.getProductImage();
        String [] image=logo.split(",");
        String product_logo=image[0];

        Picasso.get().load(product_logo).into(myViewHolder.image);

        myViewHolder.text.setText(list.get(i).getTitle());
        myViewHolder.price.setText(list.get(i).getPrice());
        myViewHolder.detail.setText(list.get(i).getDescription());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView text, price,detail;
        RecyclerView productDetailRecyclerview;
        Button buyProduct;
        RelativeLayout buy_product_layout;
        

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.hairwaxProductDetail);
            text=itemView.findViewById(R.id.productNameDetail);
            detail=itemView.findViewById(R.id.product_detail);
            productDetailRecyclerview=itemView.findViewById(R.id.productDetailRecyclerview);
            price=itemView.findViewById(R.id.product_Price);
            buyProduct=itemView.findViewById(R.id.buy_product);
            buy_product_layout=itemView.findViewById(R.id.buy_product_layout);
            buy_product_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buy_product_layout:
                    select.Choose(getLayoutPosition());
                    break;

            }
        }
    }

}
