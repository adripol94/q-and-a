package es.iesnervion.qa.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import es.iesnervion.qa.Model.Category;
import es.iesnervion.qa.Model.Question;
import es.iesnervion.qa.Model.RetrofitInterfaceQA;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adripol94 on 1/31/17.
 */

public class RetrofitControler {
    private static String NAME_SERVER = "https://api.apol.ciclo.iesnervion.es/index.php/";
    private RetrofitInterfaceQA service;
    private Retrofit retrofit;


    public RetrofitControler() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(NAME_SERVER)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(RetrofitInterfaceQA.class);
    }

    public RetrofitControler(String url) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(RetrofitInterfaceQA.class);
    }

    public Call<Question> getListQuestion(String token) {
        Call<Question> questions = service.lisQuestions(token);

        return questions;
    }

    public Call<List<Category>> getListCategory(String token) {
        Call<List<Category>> categories = service.listCategory(token);

        return categories;
    }
}
