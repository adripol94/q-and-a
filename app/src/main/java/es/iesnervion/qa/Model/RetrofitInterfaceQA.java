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
    Call<Question> lisQuestions(@Header("WWW-Authenticate") String token);

    @GET("question/{id}")
    Call<Question> question();
}
