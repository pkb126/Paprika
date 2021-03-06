package com.vicky7230.eatit.data.network;

import com.vicky7230.eatit.data.network.model.singleRecipe.SingleRecipe;
import com.vicky7230.eatit.data.network.model.recipes.Recipes;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vicky on 25/6/17.
 */

public interface RecipeService {

    @GET("search")
    Observable<Recipes> getRecipes(
            @Query("key") String key,
            @Query("page") String page,
            @Query("sort") String sort
    );

    @GET("get")
    Observable<SingleRecipe> getRecipe(
            @Query("key") String key,
            @Query("rId") String rId
    );


    @GET("search")
    Observable<Recipes> searchRecipes(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

}
