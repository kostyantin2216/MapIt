package com.mapitapp.mapit.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;

import com.mapitapp.mapit.R;
import com.mapitapp.mapit.model.TradesmanCriteria;

public class SelectTradesmanCriteriaFragment extends Fragment {

    private final static int POS_CAPE_TOWN = 0;
    private final static int POS_DURBAN = 1;
    private final static int POS_JOHANNESBURG = 2;

    private onTradesmanCriteriaSelected mCallback;

    private Spinner spinnerProfession;
    private Spinner spinnerCity;
    private Spinner spinnerSuburb;

    public SelectTradesmanCriteriaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_select_tradesman_criteria, container, false);

        // Prepare spinners.
        spinnerProfession = (Spinner) rootView.findViewById(R.id.spinner_profession);
        ArrayAdapter<CharSequence> professionsAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_professions, android.R.layout.simple_spinner_item);
        professionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProfession.setAdapter(professionsAdapter);

        spinnerCity = (Spinner) rootView.findViewById(R.id.spinner_city);
        ArrayAdapter<CharSequence> citiesAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.array_cities, android.R.layout.simple_spinner_item);
        citiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(citiesAdapter);

        spinnerSuburb = (Spinner) rootView.findViewById(R.id.spinner_suburb);
        spinnerSuburb.setEnabled(false);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSuburb.setEnabled(true);

                String[] suburbs = null;
                switch(position) {
                    case POS_CAPE_TOWN:
                        suburbs = getResources().getStringArray(R.array.array_cape_town_suburbs);
                        break;
                    case POS_DURBAN:
                        suburbs = getResources().getStringArray(R.array.array_durban_suburbs);
                        break;
                    case POS_JOHANNESBURG:
                        suburbs = getResources().getStringArray(R.array.array_johannesburg_suburbs);
                        break;
                }

                ArrayAdapter<CharSequence> suburbsAdapter = new ArrayAdapter<CharSequence>(getActivity(),
                        android.R.layout.simple_spinner_item, suburbs);
                suburbsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerSuburb.setAdapter(suburbsAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerSuburb.setEnabled(false);
            }
        });

        // Prepare button.
        Button btnDone = (Button) rootView.findViewById(R.id.b_done);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String profession = spinnerProfession.getSelectedItem().toString();
                String city = spinnerCity.getSelectedItem().toString();
                String suburb = spinnerSuburb.getSelectedItem().toString();
                TradesmanCriteria criteria = new TradesmanCriteria(profession, city, suburb);
                mCallback.onTradesmanCriteriaSelected(criteria);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (onTradesmanCriteriaSelected) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onTradesmanCriteriaSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface onTradesmanCriteriaSelected {
        public void onTradesmanCriteriaSelected(TradesmanCriteria criteria);
    }

}
