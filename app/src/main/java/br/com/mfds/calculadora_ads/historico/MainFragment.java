package br.com.mfds.calculadora_ads.historico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import br.com.mfds.calculadora_ads.R;
import br.com.mfds.calculadora_ads.database.DatabaseHelper;

public class MainFragment extends Fragment {
    private DatabaseHelper dbHelper;
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

        Button btnDeletarHistorico = v.findViewById(R.id.Button_excluir_historico);
        btnDeletarHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Deseja excluir todo o histórico?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbhelper.delete();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MainFragment()).commit();
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Não faz nada!
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return v;
    }

}