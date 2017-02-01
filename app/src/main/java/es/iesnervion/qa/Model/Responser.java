package es.iesnervion.qa.Model;

/**
 * Created by apol on 1/02/17.
 */

public interface Responser<T> {
    void onFinish(T obj, String bearer);
    void onFailure(Throwable t);
}
