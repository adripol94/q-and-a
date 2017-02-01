package es.iesnervion.qa.Model;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import java.util.List;

import es.iesnervion.qa.R;
import es.iesnervion.qa.TestPrueba;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apol on 1/02/17.
 */

public class CallBackProgress implements Callback<Question> {
    private Context c;
    private Question lisato;
    private View v;


    public CallBackProgress(Context c) {
        this.c = c;
        v = ((Activity)c).findViewById(R.id.activity_test_prueba);
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
    public void onResponse(Call<Question> call, Response<Question> response) {
        if (response.body() == null)
            Snackbar.make(v, response.message(), Snackbar.LENGTH_LONG).show();
        else {
            lisato = response.body();
            String bearer = response.headers().get("WWW-Authenticate");
            Responser res = (Responser) c;
            res.terminado(lisato, bearer);
        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<Question> call, Throwable t) {
        Snackbar.make(v, t.getMessage(), Snackbar.LENGTH_LONG).show();
        t.printStackTrace();
    }
}
