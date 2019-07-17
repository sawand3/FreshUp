package com.example.freshupnew.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.freshupnew.Activities.ProductList;
import com.example.freshupnew.Adapters.ProductAdapter;
import com.example.freshupnew.Api.Api;
import com.example.freshupnew.Api.ClassApi;
import com.example.freshupnew.Model.ProductModel;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Product extends Fragment {
    private List<ProductModel.Detail> data=new ArrayList<>();
    private RecyclerView list;
    RelativeLayout layout;



    public Fragment_Product() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);
//        layout = view.findViewById(R.id.productLayout);
//        hairwaxlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), ProductList.class);
//                startActivity(intent);
//
//            }
//        });
        list=view.findViewById(R.id.products_recyclerview);
        list.setLayoutManager(new LinearLayoutManager(getContext()));



//        ProductModel productModel=new ProductModel(R.drawable.background_hari_wax,R.drawable.hair_wax,"Hair Wax");
//        data.add(productModel);
//        productModel=new ProductModel(R.drawable.lookstresses_background,R.drawable.looksandtress,"Looks And Tresses");
//        data.add(productModel);

        Api api= ClassApi.apiclient().create(Api.class);
        Call<ProductModel> call=api.getProduct();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                int size=response.body().getDetails().size();
                if(response.body()!=null){
                    for(int i=0; i<size; i++){
//                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                        ProductModel.Detail save=new ProductModel.Detail();
                        save.setImage1(response.body().getDetails().get(i).getImage1());
                        save.setImage2(response.body().getDetails().get(i).getImage2());
                        save.setTitle(response.body().getDetails().get(i).getTitle());
                        save.setId(response.body().getDetails().get(i).getId());
                        data.add(save);

                    }
                }
                ProductAdapter productAdapter=new ProductAdapter(data, new ProductAdapter.Select() {
                    @Override
                    public void Choose(int position) {
//                        startActivity(new Intent(getContext(), ProductList.class));
                        Toast.makeText(getContext() , data.get(position).getId(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getContext(),ProductList.class);
                        intent.putExtra("productId",data.get(position).getId());
                        startActivity(intent);

                    }
                });
                list.setAdapter(productAdapter);

            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();


            }
        });




        return view;
    }

}
