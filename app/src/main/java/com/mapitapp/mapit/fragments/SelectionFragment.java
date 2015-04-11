package com.mapitapp.mapit.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mapitapp.mapit.R;

/**
 * Created by Kostyantin on 3/21/2015.
 */
public class SelectionFragment extends Fragment {

    private onFindTradesmanListener mCallback;

    public SelectionFragment() {
    }

    public interface onFindTradesmanListener {
        public void onFindTradesman();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_page, container, false);

        Button btnFindTradesman = (Button) rootView.findViewById(R.id.b_home_find_tradesman);
        btnFindTradesman.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCallback.onFindTradesman();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // this makes sure the container activity has implemented
        // the callback interface.  If not, it throws and exception.
        try {
            mCallback = (onFindTradesmanListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onFindTradesmanListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
