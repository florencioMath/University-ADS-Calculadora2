package br.com.mfds.calculadora_ads.historico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.mfds.calculadora_ads.R;
import br.com.mfds.calculadora_ads.database.DatabaseHelper;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.historico_fragment_main, container, false);
        DatabaseHelper dbhelper = new DatabaseHelper(getActivity());
        ListView lv = v.findViewById(R.id.list_view_history);
        dbhelper.select(getActivity(), lv);
        return v;
    }
}