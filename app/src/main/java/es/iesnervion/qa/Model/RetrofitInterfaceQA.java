package es.iesnervion.qa.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by apol on 1/02/17.
 */

public interface RetrofitInterfaceQA {
    @GET("question")
    Call<List<Question>> lisQuestions(@Header("HTTP_WWW_AUTHENTICATE") String autentication);

    @GET("question/{id}")
    Call<Question> question();
}
