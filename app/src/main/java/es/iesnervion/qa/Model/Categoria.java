package es.iesnervion.qa.Model;

/**
 * Created by adripol94 on 1/26/17.
 */
public class Categoria {
    private int id;
    private String categoria;

    public Categoria() {
    }

    public Categoria(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
