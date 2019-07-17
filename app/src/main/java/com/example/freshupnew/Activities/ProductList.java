package com.example.freshupnew.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.freshupnew.Adapters.ProductListAdapter;
import com.example.freshupnew.Api.Api;
import com.example.freshupnew.Api.ClassApi;
import com.example.freshupnew.Model.ProductListModel;
import com.example.freshupnew.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductList extends AppCompatActivity {
    List<ProductListModel.Detail> data=new ArrayList<>();
    RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        list=findViewById(R.id.productsDetailRecyclerview);
//        list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ProductList.this, Product_Detail.class);
//                startActivity(intent);
//            }
//        });


        Api api= ClassApi.apiclient().create(Api.class);
        Intent intent=getIntent();
        String s=intent.getStringExtra("productId");
        api.getProducts(s).enqueue(new Callback<ProductListModel>() {
            @Override
            public void onResponse(Call<ProductListModel> call, Response<ProductListModel> response) {
                int size=response.body().getDetails().size();
                if(response.body()!=null){
                    for (int i=0; i<size; i++){
                        ProductListModel.Detail save=new ProductListModel.Detail();
                        save.setTitle(response.body().getDetails().get(i).getTitle());
                        save.setImage(response.body().getDetails().get(i).getImage());
                        save.setId(response.body().getDetails().get(i).getId());
                        save.setProduct(response.body().getDetails().get(i).getProduct());
                        data.add(save);


                    }
                    list.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    ProductListAdapter hairwaxProductAdapter=new ProductListAdapter(data, new ProductListAdapter.Select() {
                        @Override
                        public void Choose(int position) {
//                            startActivity(new Intent(ProductList.this,Product_Detail.class));
                            Toast.makeText(ProductList.this, data.get(position).getId(), Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ProductList.this,Product_Detail.class);
                            intent.putExtra("detail",(Serializable)data.get(position).getProduct());
                            startActivity(intent);
                        }
                    });
                    list.setAdapter(hairwaxProductAdapter);
                }
            }

            @Override
            public void onFailure(Call<ProductListModel> call, Throwable t) {
                Toast.makeText(ProductList.this, "Failed", Toast.LENGTH_SHORT).show();


            }
        });



//        ProductListModel productListModel =new ProductListModel(R.drawable.product_1,"Jack Black Wax Pomade");
//        data.add(productListModel);
//        productListModel =new ProductListModel(R.drawable.product_2,"Paul Mitchell Dry Wax");
//        data.add(productListModel);
//        productListModel =new ProductListModel(R.drawable.product_3,"Maneuver Work Wax By Redken");
//        data.add(productListModel);
//        productListModel =new ProductListModel(R.drawable.product_4,"Americal Crew FormingCream");
//        data.add(productListModel);



    }
}
