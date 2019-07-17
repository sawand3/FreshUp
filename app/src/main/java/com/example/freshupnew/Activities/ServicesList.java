package com.example.freshupnew.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freshupnew.Api.Api;
import com.example.freshupnew.Api.ClassApi;
import com.example.freshupnew.Model.ServicesListModel;

import com.example.freshupnew.Adapters.ServicesListAdapter;
import com.example.freshupnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesList extends AppCompatActivity {
    private TextView textTitle;
    RecyclerView list;
    Button continueBtn;
    List<ServicesListModel.Detail> data=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);
        list=findViewById(R.id.haircuttinRecyclerView);
        continueBtn=findViewById(R.id.hairCuttingContinueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(ServicesList.this,ServicesTimeSlot.class);
                startActivity(intent);
            }
        });



        Api api= ClassApi.apiclient().create(Api.class);
        Intent intent=getIntent();
        String s= intent.getStringExtra("serviceId");

        api.getSubServices(s).enqueue(new Callback<ServicesListModel>() {
            @Override
            public void onResponse(Call<ServicesListModel> call, Response<ServicesListModel> response) {
                int size=response.body().getDetails().size();
                if(response.body()!=null){
                    for(int i=0; i<size; i++){
                        ServicesListModel.Detail save=new ServicesListModel.Detail();
                        save.setTitle(response.body().getDetails().get(i).getTitle());
                        save.setId(response.body().getDetails().get(i).getId());
                        save.setSubSubServices(response.body().getDetails().get(i).getSubSubServices());
                        data.add(save);

                    }
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    list.setLayoutManager(linearLayoutManager);


                    ServicesListAdapter servicesListAdapter =new ServicesListAdapter(data, new ServicesListAdapter.Select() {
                        @Override
                        public void Choose(int position) {

                            Toast.makeText(ServicesList.this, data.get(position).getId(), Toast.LENGTH_SHORT).show();


                        }
                    });
                    list.setAdapter(servicesListAdapter);
                }


            }

            @Override
            public void onFailure(Call<ServicesListModel> call, Throwable t) {

            }
        });

//        data=new ServicesListModel[]{
//                new ServicesListModel("Beard"),
//                new ServicesListModel("Facial"),
//                new ServicesListModel("Hair Color"),
//                new ServicesListModel("Hair"),
//                new ServicesListModel("Keratin Front Of Short Hair"),
//        };

//       ServicesListModel servicesListModel =new ServicesListModel("Beard");
//       data.add(servicesListModel);
//        servicesListModel =new ServicesListModel("Facial");
//        data.add(servicesListModel);
//         servicesListModel =new ServicesListModel("Hair color");
//        data.add(servicesListModel);
//        servicesListModel =new ServicesListModel("Hair");
//        data.add(servicesListModel);
//         servicesListModel =new ServicesListModel("Keratin Front Of Short Hair");
//        data.add(servicesListModel);




    }

}
