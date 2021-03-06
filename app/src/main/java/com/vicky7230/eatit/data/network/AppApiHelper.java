package com.vicky7230.eatit.data.network;

import com.vicky7230.eatit.data.Config;
import com.vicky7230.eatit.data.network.model.imagga.content.Content;
import com.vicky7230.eatit.data.network.model.imagga.tag.Tags;
import com.vicky7230.eatit.data.network.model.recipes.Recipes;
import com.vicky7230.eatit.data.network.model.singleRecipe.SingleRecipe;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by vicky on 25/6/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private final RecipeService recipeService;
    private final ImaggaService imaggaService;

    @Inject
    public AppApiHelper(RecipeService recipeService, ImaggaService imaggaService) {

        this.recipeService = recipeService;
        this.imaggaService = imaggaService;
    }

    @Override
    public Observable<Recipes> getRecipes(String page) {

        if (Integer.parseInt(page) % 2 == 0)
            return recipeService.getRecipes(Config.RECIPES_API_KEY, page, "r");
        else
            return recipeService.getRecipes(Config.RECIPES_API_KEY_2, page, "r");
    }

    @Override
    public Observable<SingleRecipe> getRecipe(String recipeId) {
        return recipeService.getRecipe(Config.RECIPES_API_KEY, recipeId);
    }

    @Override
    public Observable<Recipes> searchRecipes(String query, String page) {
        return recipeService.searchRecipes(Config.RECIPES_API_KEY, query, page);
    }

    @Override
    public Observable<Content> uploadImage(RequestBody name, MultipartBody.Part body) {
        return imaggaService.uploadImage(name, body);
    }

    @Override
    public Observable<Tags> tagImage(String content, int limit) {
        return imaggaService.tagImage(content, limit);
    }


}
