package br.com.mfds.calculadora_ads.calculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;
import br.com.mfds.calculadora_ads.R;
import br.com.mfds.calculadora_ads.database.DatabaseHelper;

public class MainFragment extends Fragment {

    private EditText etResult;
    private EditText etOperation;
    private StringBuilder operation = new StringBuilder();
    private DatabaseHelper dbHelper;

    public MainFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculadora_fragment_main, container, false);

        etResult = v.findViewById(R.id.textView_resultado_display);
        etOperation = v.findViewById(R.id.textView_expressao_display);

        TextView btnPorcentagem = v.findViewById(R.id.Button_porcentagem);
        TextView btnDivisao = v.findViewById(R.id.Button_divisao);
        TextView btnMultiplicacao = v.findViewById(R.id.Button_multiplicacao);
        TextView btnAdicao = v.findViewById(R.id.Button_adicao);
        TextView btnSubtracao = v.findViewById(R.id.Button_subtracao);
        TextView btnResultado = v.findViewById(R.id.Button_Resultado);
        TextView btnParentesesAberto = v.findViewById(R.id.Button_parenteses_aberto);
        TextView btnParentesesFechado = v.findViewById(R.id.Button_parenteses_fechado);
        TextView btnApagar = v.findViewById(R.id.Button_apagar);
        TextView btnPonto = v.findViewById(R.id.Button_ponto);
        TextView btnZero = v.findViewById(R.id.Button_zero);
        TextView btnUm = v.findViewById(R.id.Button_um);
        TextView btnDois = v.findViewById(R.id.Button_dois);
        TextView btnTres = v.findViewById(R.id.Button_tres);
        TextView btnQuatro = v.findViewById(R.id.Button_quatro);
        TextView btnCinco = v.findViewById(R.id.Button_cinco);
        TextView btnSeis = v.findViewById(R.id.Button_seis);
        TextView btnSete = v.findViewById(R.id.Button_sete);
        TextView btnOito = v.findViewById(R.id.Button_oito);
        TextView btnNove = v.findViewById(R.id.Button_nove);

        // Porcentagem
        btnPorcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etOperation.length() != 0) {
                    operation.append(btnPorcentagem.getText());
                    etResult.setText(operation.toString());
                    etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
                 }
            }
        });

        // Parênteses aberto
        btnParentesesAberto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnParentesesAberto.getText());
                etResult.setText(operation.toString());
            }
        });

        // Parênteses fechado
        btnParentesesFechado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.countMatches(operation.toString(), "(") == StringUtils.countMatches(operation.toString(), ")")) {
                    Toast.makeText(getContext(), "Não é possível fechar parênteses sem abri-lo antes", Toast.LENGTH_SHORT).show();
                } else {
                    operation.append(btnParentesesFechado.getText());
                    etResult.setText(operation.toString());
                }
            }
        });

        // Divisão
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnDivisao.getText());
                etResult.setText(operation.toString());
            }
        });

        // Multiplicação
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnMultiplicacao.getText());
                etResult.setText(operation.toString());
            }
        });

        // Subtração
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSubtracao.getText());
                etResult.setText(operation.toString());
            }
        });

        // Adição
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnAdicao.getText());
                etResult.setText(operation.toString());
            }
        });

        // Resultado
        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etResult.length() > 0 && etOperation.length() > 0) {
                    dbHelper = new DatabaseHelper(getActivity());
                    dbHelper.insert(operation.toString(), etOperation.getText().toString());
                }
                etResult.setText(etOperation.getText().toString());
                operation = new StringBuilder();
                etOperation.setText("");
            }
        });

        // Apagar
        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation.length() > 0) {
                    operation.deleteCharAt(operation.length()-1);
                    etResult.setText(operation.toString());
                }
                if(operation.length() < 1) {
                    etOperation.setText("");
                }
            }
        });


        /* Ínicio dos botões do teclado */
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnZero.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnUm.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));

            }
        });
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnDois.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnTres.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnQuatro.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnCinco.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSeis.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSete.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnOito.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnNove.getText());
                etResult.setText(operation.toString());
                etOperation.setText(Operacoes.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnPonto.getText());
                etResult.setText(operation.toString());
            }
        });
        /* Fim dos botões do teclado */

        return v;
    }
}