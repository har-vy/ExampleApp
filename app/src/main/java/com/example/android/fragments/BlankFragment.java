package com.example.android.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * It extends the pre-defined ListFragment class
 * which enables us to bind a list view to some array
 */
public class BlankFragment extends ListFragment {

    private PlayerListener playerListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Adapter is a bridge between an Adapter View and its underlying data
        setListAdapter(new ArrayAdapter<String>(this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.Chelsea)));
    }
    public interface PlayerListener{
     public void onPlayerSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
         playerListener=(PlayerListener) context;
        }
        catch (ClassCastException e){
          throw new ClassCastException(context.toString()+" must implement interface named PlayerListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        playerListener.onPlayerSelected(position);
    }
}
