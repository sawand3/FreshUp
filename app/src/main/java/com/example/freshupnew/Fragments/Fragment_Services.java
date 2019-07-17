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

import com.example.freshupnew.Adapters.ServicesAdapter;
import com.example.freshupnew.Api.Api;
import com.example.freshupnew.Api.ClassApi;
import com.example.freshupnew.Model.ServicesModel;
import com.example.freshupnew.R;
import com.example.freshupnew.Activities.ServicesList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Services extends Fragment  {
    private List<ServicesModel.Detail> data=new ArrayList<>();
    private RecyclerView list;
    RelativeLayout layout;

    public Fragment_Services() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_services, container, false);

        list=view.findViewById(R.id.services_recyclerview);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        Api api= ClassApi.apiclient().create(Api.class);
        Call<ServicesModel> call=api.getServices();

        call.enqueue(new Callback<ServicesModel>() {

            @Override
            public void onResponse(Call<ServicesModel> call, final Response<ServicesModel> response) {
                int size=response.body().getDetails().size();
                if(response.body()!=null){

                    for(int i=0; i<size;i++) {
//                        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

                        ServicesModel.Detail save=new ServicesModel.Detail();

                        save.setImage1(response.body().getDetails().get(i).getImage1());
                        save.setImage2(response.body().getDetails().get(i).getImage2());
                        save.setTitle(response.body().getDetails().get(i).getTitle());
                        save.setId(response.body().getDetails().get(i).getId());
                        data.add(save);



                    }
                    ServicesAdapter servicesAdapter=new ServicesAdapter(data, new ServicesAdapter.Select() {
                        @Override
                        public void Choose(int position) {
//                        startActivity(new Intent(getContext(), ServicesList.class));
                            Toast.makeText(getContext(),data.get(position).getId(), Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(getContext(),ServicesList.class);
                            intent.putExtra("serviceId",data.get(position).getId());
                            startActivity(intent);
                        }
                    });
                    list.setAdapter(servicesAdapter);

                }

            }

            @Override
            public void onFailure(Call<ServicesModel> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();


            }
        });




//        ServicesModel servicesModel=new ServicesModel(R.drawable.hair_cutting_imae,R.drawable.haircuttin,"Hair Cutting");
//        data.add(servicesModel);
//        servicesModel=new ServicesModel(R.drawable.lookstresses_background,R.drawable.looksandtress,"Looks And Tresses");
//        data.add(servicesModel);


//        ServicesAdapter servicesAdapter=new ServicesAdapter(data, new ServicesAdapter.Select() {
//            @Override
//            public void Choose(int position) {
//                startActivity(new Intent(getContext(), ServicesList.class));
//            }
//        });

        return view;
    }

}
