package com.huangketech.sunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] forecastArray = {"Today - Sunnay - 88 / 63 ", "Tomorrow - Foggy - 70 / 46 ", "Weds - Cloudy - 72 / 63 ", "Thurs - Rainy - 64 / 51 ", "Fri - Foggy - 70 / 46 ", "Sat - Sunnay - 88 / 63 "};
        List list = new ArrayList();
        list.add("Today - Sunnay - 88 / 63 ");
        list.add("Tomorrow - Foggy - 70 / 46 ");
        list.add("Weds - Cloudy - 72 / 63 ");
        list.add("Thurs - Rainy - 64 / 51 ");
        list.add("Fri - Foggy - 70 / 46 ");
        list.add("Sat - Sunnay - 88 / 63 ");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, forecastArray);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(adapter);
        return rootView;
    }
}
