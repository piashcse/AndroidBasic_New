package com.example.extreme_piash.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.extreme_piash.androidbasic.Model.BaseModel;
import com.example.extreme_piash.androidbasic.adapter.RVAdapter;
import com.example.extreme_piash.androidbasic.core.ApplicationSingleton;
import com.example.extreme_piash.androidbasic.network.ApiClient;
import com.example.extreme_piash.androidbasic.network.NetworkCallInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= "MainActivity";
    @BindView(R.id.recyclerveiw)
    RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RVAdapter rvAdapter;
    private NetworkCallInterface networkCallInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        layoutManager =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new RVAdapter(getApplicationContext());

/*        Retrofit retrofit = ApiClient.getInstance(this);
        networkCallInterface = retrofit.create(NetworkCallInterface.class);
        networkCallInterface.getApiData().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {

                Toast.makeText(getApplicationContext(), "Yo yo", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onResponse: "+response.body().getCategories().get(0).getCategoryName() );
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {

            }
        });*/

        ApplicationSingleton.getInstance().getNetworkCallInterface().getApiData().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                Toast.makeText(getApplicationContext(), "Yo yo", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onResponse: "+response.body().getCategories().get(0).getCategoryName() );
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {

            }
        });
        /*ApplicationSingleton.getInstance().getNetworkCallInterface().getApiData().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });*/
    }
}
