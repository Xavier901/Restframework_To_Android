package com.example.rest_test2;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Posts_Activity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_posts);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        listview=findViewById(R.id.post_listview);
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.242.158:8000/api/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        RetrofitMethod client=retrofit.create(RetrofitMethod.class);
        Call<List<Post_data>> call=client.Posts_listData("v1");

        call.enqueue(new Callback<List<Post_data>>() {
            @Override
            public void onResponse(Call<List<Post_data>> call, Response<List<Post_data>> response) {
                Toast.makeText(Posts_Activity.this, "Success :"+response.message(), Toast.LENGTH_SHORT).show();
                List<Post_data>dataList=response.body();
                listview.setAdapter(new PostList_Adapter(Posts_Activity.this,R.layout.post_list_template,dataList));
            }

            @Override
            public void onFailure(Call<List<Post_data>> call, Throwable throwable) {
                Toast.makeText(Posts_Activity.this, "Error :"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}