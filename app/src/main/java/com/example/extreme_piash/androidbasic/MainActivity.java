package com.example.extreme_piash.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.extreme_piash.androidbasic.Model.BaseModel;
import com.example.extreme_piash.androidbasic.adapter.RVAdapter;
import com.example.extreme_piash.androidbasic.core.ApplicationSingleton;
import com.example.extreme_piash.androidbasic.core.BaseActivity;
import com.example.extreme_piash.androidbasic.network.ApiClient;
import com.example.extreme_piash.androidbasic.network.NetworkCallInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    private static final String TAG= "MainActivity";
    @BindView(R.id.recyclerveiw)
    RecyclerView recyclerView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.textViewDataNotFound)
    TextView textViewNodataFound;
    private LinearLayoutManager layoutManager;
    private RVAdapter rvAdapter;
    private NetworkCallInterface networkCallInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        layoutManager =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new RVAdapter(getApplicationContext());

        initApi();
    }

    public void initApi(){

        if (progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
        ApplicationSingleton.getInstance().getNetworkCallInterface().getApiData().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {

                if (response.body() != null){

                    if (progressBar != null){
                        progressBar.setVisibility(View.GONE);
                    }
                    rvAdapter.setData(response.body().getCategories());
                    recyclerView.setAdapter(rvAdapter);
                    rvAdapter.setOnclickListener(new RClickListener() {
                        @Override
                        public void onItemClick(int position, View view) {

                        }
                    });

                    if (response.body().getCategories().size() <= 0){
                        textViewNodataFound.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {

            }
        });
    }


}
