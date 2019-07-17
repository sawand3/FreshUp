package com.example.freshupnew.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.freshupnew.Adapters.ProductDetailAdapter;
import com.example.freshupnew.Api.Api;
import com.example.freshupnew.Api.ClassApi;
import com.example.freshupnew.Model.ProductDetailModel;
import com.example.freshupnew.Model.ProductListModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product_Detail extends AppCompatActivity {
   private List<ProductListModel.Product> data=new ArrayList<>();
    private RecyclerView list;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__detail);
//        buy=findViewById(R.id.buy_product);
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Product_Detail.this,Payment.class);
//                startActivity(intent);
//            }
//        });

        list=findViewById(R.id.productDetailRecyclerview);

                    list.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                   data= (List<ProductListModel.Product>) getIntent().getExtras().getSerializable("detail");

//
//        ProductDetailModel productDetailModel=new ProductDetailModel(R.drawable.product_1,"Jack Black Wax Pomade","(Natural Shine, Flexible Hold)","39.00");
//        data.add(productDetailModel);
//        productDetailModel=new ProductDetailModel(R.drawable.product_2,"Paul Mitchell Dry Wax","(Natural Shine, Flexible Hold)","39.00");
//        data.add(productDetailModel);
//        productDetailModel=new ProductDetailModel(R.drawable.product_3,"Maneuver Work Wax By Redken","(Natural Shine, Flexible Hold)","39.00");
//        data.add(productDetailModel);
//        productDetailModel=new ProductDetailModel(R.drawable.product_4,"Americal Crew FormingCream","(Natural Shine, Flexible Hold)","39.00");
//        data.add(productDetailModel);


        ProductDetailAdapter productDetailAdapter=new ProductDetailAdapter(data, new ProductDetailAdapter.Select() {
            @Override
            public void Choose(int position) {
                startActivity(new Intent(Product_Detail.this,Payment.class));
            }
        });
        list.setAdapter(productDetailAdapter);
    }
}
