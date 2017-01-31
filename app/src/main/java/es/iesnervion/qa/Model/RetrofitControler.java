package es.iesnervion.qa.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adripol94 on 1/31/17.
 */

public class RetrofitControler {
    private static String NAME_SERVER = "api.apol.ciclo.iesnervion.es";
    private Retrofit retrofit;

    public RetrofitControler() {
        retrofit = new Retrofit.Builder()
                .baseUrl(NAME_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RetrofitControler(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }



}
