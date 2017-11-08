package com.example.charl.retrofit;

/**
 * Created by charl on 08/11/2017.
 */

import com.example.charl.retrofit.models.receipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    /*
   * Retrofit get annotation with our URL
   * And our method that will return us details of recipes.
  */
    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<receipe>> getRecipes();
}
