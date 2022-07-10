package br.com.mfds.calculadora_ads;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.mfds.calculadora_ads.historico.MainFragment;


public class MenuFragment extends Fragment {

    public MenuFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu, menu);
    };

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_calculadora:
                Toast.makeText(getActivity(), "Calculadora", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this.getActivity(), MainActivity.class);
                this.startActivity(intent);
                break;
        };
        switch (item.getItemId()) {
          case R.id.menu_historico:
            Toast.makeText(getActivity(), "Histórico", Toast.LENGTH_SHORT).show();
             getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MainFragment()).commit();
            break;
        };
    return super.onOptionsItemSelected(item);
    }
}