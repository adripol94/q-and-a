package es.iesnervion.qa.Model;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import es.iesnervion.qa.R;
import es.iesnervion.qa.ui.Adapter.CategoriaAdapter;
import es.iesnervion.qa.ui.Adapter.ListAdapter;

/**
 * Created by adripol94 on 1/28/17.
 */

public class ListQuestionFragment extends ListFragment {
    private Question questions;


    private OnSelectedItem mCallBack;

    public interface OnSelectedItem {
        public void onAnswerClicked(int position);
    }


    public ListQuestionFragment() {

    }

    public static ListQuestionFragment newInstance(Question question) {
        Bundle args = new Bundle();

        ListQuestionFragment fragment = new ListQuestionFragment();
        args.putParcelable(Question.CATEGORY_KEY, question);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layou = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;


        if (getArguments() == null)
            throw new ExceptionInInitializerError("Don't allow question");

        questions = getArguments().getParcelable(Question.CATEGORY_KEY);

        setListAdapter(new ListAdapter(getContext(), R.layout.template_gaming, questions.getAnswer()));
    }


    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Castear el context, de no sér así no saltará la excepcion
        try {
            mCallBack = (OnSelectedItem) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("No implementado OnHeadSelectedListener :( "
                    + e.getMessage() + ")");
        }
    }

    /**
     * This method will be called when an item in the list is selected.
     * Subclasses should override. Subclasses can call
     * getListView().getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param l        The ListView where the click happened
     * @param v        The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id       The row id of the item that was clicked
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //TODO Terminar!!
        //Introducimos la posicion en la interfaz
        mCallBack.onAnswerClicked(position);

        //Indicamos al ListView que posicion de la lista tiene que seleccionar.
        // Indicaremos con true que ponga como seleccionado la posicion pasada por parametro
        getListView().setItemChecked(position, true);
    }
}
