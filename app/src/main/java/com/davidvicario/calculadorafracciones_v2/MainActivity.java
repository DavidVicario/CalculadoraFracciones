package com.davidvicario.calculadorafracciones_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables
    private int n1;
    private int d1;
    private int n2;
    private int d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultar barra de aplicaciones
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        //Declaración de cajas de las fracciones
        final EditText num1 = findViewById(R.id.editN1);
        final EditText den1 = findViewById(R.id.editD1);
        final EditText num2 = findViewById(R.id.editN2);
        final EditText den2 = findViewById(R.id.editD2);

        //Declaración de cajas de texto resultado
        final TextView numR = findViewById(R.id.textNR);
        final TextView denR = findViewById(R.id.textDR);

        //Botones de operaciones
        final RadioButton suma = findViewById(R.id.rSum);
        final RadioButton resta = findViewById(R.id.rRes);
        final RadioButton multi = findViewById(R.id.rMul);
        final RadioButton divi = findViewById(R.id.rDiv);

        //Boton de igual
        final Button botonI = findViewById(R.id.btnIgual);

        //Para el mcd
        final TextView tv_MCD = findViewById(R.id.txtMcd);
        tv_MCD.setVisibility(View.INVISIBLE);

        botonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (suma.isChecked()){

                    //Introducir dígitos de las fracciones
                    n1 = Integer.parseInt(String.valueOf(num1.getText()));
                    d1 = Integer.parseInt(String.valueOf(den1.getText()));
                    n2 = Integer.parseInt(String.valueOf(num2.getText()));
                    d2 = Integer.parseInt(String.valueOf(den2.getText()));

                    //Impedir la división entre 0
                    if (d1 == 0) d1 = 1;
                    if (d2 == 0) d2 = 1;

                    //Calculo y mcd
                    int nR = n1 * d2 + d1 * n2;
                    int dR = d1 * d2;
                    int vMCD = mcd(nR, dR);

                    tv_MCD.setText(String.valueOf(vMCD));

                    nR = nR / vMCD;
                    dR = dR / vMCD;

                    //Visualizar resultado
                    numR.setText(String.valueOf(nR));
                    denR.setText(String.valueOf(dR));

                    //Ocultar caja en caso de ser 1
                    if (dR==1) denR.setVisibility(View.INVISIBLE);
                    else denR.setVisibility( View.VISIBLE );

                }else if (resta.isChecked()){

                    //Introducir dígitos de las fracciones
                    n1 = Integer.parseInt(String.valueOf(num1.getText()));
                    d1 = Integer.parseInt(String.valueOf(den1.getText()));
                    n2 = Integer.parseInt(String.valueOf(num2.getText()));
                    d2 = Integer.parseInt(String.valueOf(den2.getText()));

                    //Impedir la división entre 0
                    if (d1 == 0) d1 = 1;
                    if (d2 == 0) d2 = 1;

                    //Calculo y mcd
                    int nR = n1 * d2 - d1 * n2;
                    int dR = d1 * d2;
                    int vMCD = mcd(nR, dR);

                    tv_MCD.setText(String.valueOf(vMCD));

                    nR = nR / vMCD;
                    dR = dR / vMCD;

                    //Visualizar resultado
                    numR.setText(String.valueOf(nR));
                    denR.setText(String.valueOf(dR));

                    //Ocultar caja en caso de ser 1
                    if (dR==1) denR.setVisibility(View.INVISIBLE);
                    else denR.setVisibility( View.VISIBLE );

                }else if (multi.isChecked()){

                    //Introducir dígitos de las fracciones
                    n1 = Integer.parseInt(String.valueOf(num1.getText()));
                    d1 = Integer.parseInt(String.valueOf(den1.getText()));
                    n2 = Integer.parseInt(String.valueOf(num2.getText()));
                    d2 = Integer.parseInt(String.valueOf(den2.getText()));

                    //Impedir la división entre 0
                    if (d1 == 0) d1 = 1;
                    if (d2 == 0) d2 = 1;

                    //Calculo y mcd
                    int nR = n1 * n2;
                    int dR = d1 * d2;
                    int vMCD = mcd(nR, dR);

                    tv_MCD.setText(String.valueOf(vMCD));

                    nR = nR / vMCD;
                    dR = dR / vMCD;

                    //Visualizar resultado
                    numR.setText(String.valueOf(nR));
                    denR.setText(String.valueOf(dR));

                    //Ocultar caja en caso de ser 1
                    if (dR==1) denR.setVisibility(View.INVISIBLE);
                    else denR.setVisibility( View.VISIBLE );

                }else if (divi.isChecked()){

                    //Introducir dígitos de las fracciones
                    n1 = Integer.parseInt(String.valueOf(num1.getText()));
                    d1 = Integer.parseInt(String.valueOf(den1.getText()));
                    n2 = Integer.parseInt(String.valueOf(num2.getText()));
                    d2 = Integer.parseInt(String.valueOf(den2.getText()));

                    //Impedir la división entre 0
                    if (d1 == 0) d1 = 1;
                    if (d2 == 0) d2 = 1;

                    //Calculo y mcd
                    int nR = n1 * d2;
                    int dR = d1 * n2;
                    int vMCD = mcd(nR, dR);

                    tv_MCD.setText(String.valueOf(vMCD));

                    nR = nR / vMCD;
                    dR = dR / vMCD;

                    //Visualizar resultado
                    numR.setText(String.valueOf(nR));
                    denR.setText(String.valueOf(dR));

                    //Ocultar caja en caso de ser 1
                    if (dR==1) denR.setVisibility(View.INVISIBLE);
                    else denR.setVisibility( View.VISIBLE );

                }

            }
        });

        //Control de modificaciones en las cajas de fracción.
        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String cad = String.valueOf(num1.getText());
                Toast.makeText(MainActivity.this, "Numerador uno: " + cad, Toast.LENGTH_SHORT).show();
            }
        });
        den1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String cad = String.valueOf(den1.getText());
                Toast.makeText(MainActivity.this, "Denominador uno: " + cad, Toast.LENGTH_SHORT).show();
            }
        });
        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String cad = String.valueOf(num2.getText());
                Toast.makeText(MainActivity.this, "Numerador dos: " + cad, Toast.LENGTH_SHORT).show();
            }
        });
        den2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String cad = String.valueOf(den2.getText());
                Toast.makeText(MainActivity.this, "Denominador dos: " + cad, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Función Máximo Común Divisor
    private int mcd(int pA, int pB){
        int a = pA;
        int b = pB;
        int R = -1;
        while (R != 0) {
            R = a % b;
            a = b;
            b = R;
        }
        return a;
    }

}