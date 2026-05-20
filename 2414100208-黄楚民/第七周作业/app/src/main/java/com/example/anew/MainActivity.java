package com.example.anew;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.anew.databinding.ActivityMainBinding;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater()); // ViewBinding 初始化
        setContentView(binding.getRoot());

        new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(News2.class)
                .getTopNews("top", "d28aec02329d46150613b932b660dd9b")
                .enqueue(new retrofit2.Callback<News>() {
                    @Override
                    public void onResponse(retrofit2.Call<News> call, retrofit2.Response<News> res) {
                        if (res.isSuccessful() && res.body().result != null) {
                            binding.rvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            binding.rvNews.setAdapter(new NewsAdapter(res.body().result.data));
                        }
                    }
                    @Override public void onFailure(retrofit2.Call<News> call, Throwable t) {}
                });
    }
}