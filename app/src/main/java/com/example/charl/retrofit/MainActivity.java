package com.example.charl.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.charl.retrofit.models.ingredients;
import com.example.charl.retrofit.models.receipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.nameTxt);
        loadJSON();
    }

    private void loadJSON() {

        /*build Retrofit using Retrofit.Builder() and convert JSON data
        into accessible data object using GsonConverterFactory*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<receipe>> call = request.getRecipes();//because reponse will be a JSON array not a JSON object
        call.enqueue(new Callback<List<receipe>>() {
            @Override
            public void onResponse(Call<List<receipe>> call, Response<List<receipe>> response) {

                List<receipe> receipes = response.body();


                for (int i = 0; i < receipes.size(); i++) {
                    if (i == 0) {
                        name.setText(receipes.get(i).getName());

                        List<ingredients> ingredients = receipes.get(i).getIngredients();
                        name.append(":" + ingredients.get(i).getIngredient());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<receipe>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
