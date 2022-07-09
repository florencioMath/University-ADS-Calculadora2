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

public class MainFragment extends Fragment {

    private EditText etResult;
    private EditText etOperation;
    private StringBuilder operation = new StringBuilder();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculadora_fragment_main, container, false);

        etResult = v.findViewById(R.id.textViewResultDisplay);
        etOperation = v.findViewById(R.id.textViewOperationDisplay);

        TextView btnPercent = v.findViewById(R.id.percentButton);
        TextView btnOpenParenthesis = v.findViewById(R.id.openParenthesisButton);
        TextView btnCloseParenthesis = v.findViewById(R.id.closeParenthesisButton);
        TextView btnDivision = v.findViewById(R.id.divisionButton);
        TextView btnMultiplication = v.findViewById(R.id.multiplicationButton);
        TextView btnSubtraction = v.findViewById(R.id.subtractionButton);
        TextView btnAddition = v.findViewById(R.id.additionButton);
        TextView btnResult = v.findViewById(R.id.resultButton);
        TextView btnZero = v.findViewById(R.id.zeroButton);
        TextView btnOne = v.findViewById(R.id.oneButton);
        TextView btnTwo = v.findViewById(R.id.twoButton);
        TextView btnThree = v.findViewById(R.id.threeButton);
        TextView btnFour = v.findViewById(R.id.fourButton);
        TextView btnFive = v.findViewById(R.id.fiveButton);
        TextView btnSix = v.findViewById(R.id.sixButton);
        TextView btnSeven = v.findViewById(R.id.sevenButton);
        TextView btnEight = v.findViewById(R.id.eightButton);
        TextView btnNine = v.findViewById(R.id.nineButton);
        TextView btnDecimalPoint = v.findViewById(R.id.decimalPointButton);
        TextView btnBackspace = v.findViewById(R.id.backspaceButton);

        //etResult.setText(EvalParser.calculate("(1+3)x5"));

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnPercent.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnOpenParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnOpenParenthesis.getText());
                etResult.setText(operation.toString());
            }
        });
        btnCloseParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.countMatches(operation.toString(), "(") == StringUtils.countMatches(operation.toString(), ")")) {
                    Toast.makeText(getContext(), "Não é possível fechar parênteses sem abri-lo antes", Toast.LENGTH_SHORT).show();
                } else {
                    operation.append(btnCloseParenthesis.getText());
                    etResult.setText(operation.toString());
                }
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnDivision.getText());
                etResult.setText(operation.toString());
            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnMultiplication.getText());
                etResult.setText(operation.toString());
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSubtraction.getText());
                etResult.setText(operation.toString());
            }
        });
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnAddition.getText());
                etResult.setText(operation.toString());
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etResult.setText(etOperation.getText().toString());
                operation = new StringBuilder();
                etOperation.setText("");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnZero.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnOne.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));

            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnTwo.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnThree.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnFour.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnFive.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSix.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnSeven.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnEight.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnNine.getText());
                etResult.setText(operation.toString());
                etOperation.setText(EvalParser.calculate(operation.toString(), getContext(), etOperation.getText().toString()));
            }
        });
        btnDecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.append(btnDecimalPoint.getText());
                etResult.setText(operation.toString());
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.deleteCharAt(operation.length()-1);
                etResult.setText(operation.toString());
            }
        });


        // Inflate the layout for this fragment
        return v;
    }
}