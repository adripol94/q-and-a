package es.iesnervion.qa.Model;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apol on 1/02/17.
 */

public class CallBackProgress implements Callback<List<Question>> {
    private Context c;
    private List<Question> lisato;


    public CallBackProgress(Context c) {
        this.c = c;
    }

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
        lisato = response.body();
        Responser res = (Responser) c;
        res.terminado();
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<List<Question>> call, Throwable t) {

    }
}
