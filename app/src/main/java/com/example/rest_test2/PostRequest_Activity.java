package com.example.rest_test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRequest_Activity extends AppCompatActivity {

    TextView AUTHER,TITLE,BODY;
    Button Create_Post_Btn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_request);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        
        AUTHER=findViewById(R.id.author_id);
        TITLE=findViewById(R.id.title_id);
        BODY=findViewById(R.id.body_id);
        Create_Post_Btn=findViewById(R.id.Post_create);





        
        Create_Post_Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Post_request_data postRequestData=new Post_request_data(
                        Integer.parseInt( AUTHER.getText().toString()),
                        TITLE.getText().toString(),
                        BODY.getText().toString());
                SendNetworkRequest(postRequestData);
            }
        });
    }
    private void SendNetworkRequest(Post_request_data  createpost){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://192.168.242.158:8000/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        RetrofitMethod client=retrofit.create(RetrofitMethod.class);
        Call<Post_request_data> call=client.CreatePost(createpost);

        call.enqueue(new Callback<Post_request_data>() {
            @Override
            public void onResponse(Call<Post_request_data> call, Response<Post_request_data> response) {
                Toast.makeText(PostRequest_Activity.this, "User-ID: "+response.body().getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Post_request_data> call, Throwable throwable) {
                Toast.makeText(PostRequest_Activity.this, "Error:"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}