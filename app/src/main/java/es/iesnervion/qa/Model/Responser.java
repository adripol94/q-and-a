package es.iesnervion.qa.Model;

/**
 * Created by apol on 1/02/17.
 */

public interface Responser<T> {
    void terminado(T obj, String bearer);
}
