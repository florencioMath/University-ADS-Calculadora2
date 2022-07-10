package br.com.mfds.calculadora_ads.calculadora;

import android.content.Context;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

public class Operacoes {
    public static double eval(final String str, Context context, String previousResult) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    Toast.makeText(context, "Erro na expressão.", Toast.LENGTH_SHORT).show();
                    return Double.parseDouble(previousResult);
                }
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // adição
                    else if (eat('-')) x -= parseTerm(); // subtração
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('x')) x *= parseFactor(); // multiplicação
                    else if (eat('÷')) x /= parseFactor(); // divisão
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unário mais
                if (eat('-')) return -parseFactor(); // unário menos

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parênteses
                    x = parseExpression();
                    if (!eat(')')) {
                        Toast.makeText(context, "Erro na expressão.", Toast.LENGTH_SHORT).show();
                        return Double.parseDouble(previousResult);
                    }
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // números
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // funções
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) {
                            Toast.makeText(context, "Erro na expressão.", Toast.LENGTH_SHORT).show();
                            return Double.parseDouble(previousResult);
                        }
                    } else {
                        x = parseFactor();
                    }
                } else {
                    Toast.makeText(context, "Erro na avaliação da expressão.", Toast.LENGTH_SHORT).show();
                    return Double.parseDouble(previousResult) ;
                }

                return x;
            }
        }.parse();
    }

    public static String calculate(String expression, Context context, String previousResult){
        String strResult;
        // calcula a expressão sem ter fechado os parênteses
        int countOpenParenthesis = StringUtils.countMatches(expression, "(");
        int countCloseParenthesis = StringUtils.countMatches(expression, ")");
        if (countOpenParenthesis > countCloseParenthesis) {
            expression = expression + ")";
        }

        if (StringUtils.countMatches(expression, "%") > 0){ // porcentagem
            int indexPercent = expression.indexOf("%");
            if (indexPercent == expression.length()-1){
                String substrExpression = expression.substring(0, indexPercent);
                if (substrExpression.matches("[0-9]+")) {
                    expression = substrExpression + "x0.01";
                } else if (substrExpression.matches("(.*)[/+/-](.*)")) {
                    int indexOperator = expression.indexOf('-');
                    indexOperator = indexOperator == -1 ? expression.indexOf('+') : indexOperator;
                    char operator = substrExpression.charAt(indexOperator);
                    String beforeOperator = substrExpression.substring(0, indexOperator);
                    String afterOperator = substrExpression.substring(indexOperator+1, indexPercent);
                    expression = beforeOperator + operator + "(" +  afterOperator + "x0.01x"+beforeOperator+")";
                }
            }
        }

        double result = eval(expression, context, previousResult);

        // tratamento para o display de 11 digitos máximos
        if ((result*10)/10 == Double.parseDouble(Long.toString(Math.round(result)))) {
            strResult = Long.toString(Math.round(result));
            if (strResult.length() > 11)
                Toast.makeText(context, "Digite um número de até 11 digitos.", Toast.LENGTH_SHORT).show();
        } else {
            strResult = Double.toString(result);
        }
        int length = (StringUtils.countMatches(strResult, ".") > 0) ? 12 : 11;
        while (strResult.length() > length){
            strResult = strResult.substring(0, strResult.length()-1);
        }
        return strResult;
    }
}