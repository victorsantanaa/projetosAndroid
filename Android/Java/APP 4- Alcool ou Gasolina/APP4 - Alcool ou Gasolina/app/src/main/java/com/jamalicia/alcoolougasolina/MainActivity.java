package com.jamalicia.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editTextAlcool);
        editPrecoGasolina = findViewById(R.id.editTextGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if(camposValidados){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if(valorAlcool/valorGasolina >= 0.7){
                textResultado.setText("É melhor utilizar Gasolina!");
            } else {
                textResultado.setText("É melhor utilizar Alcool!");
            }


        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;
        String campo = "preenchido";

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            campo = "alcool";
        } else if(pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
            campo = "gasolina";
        }


        return camposValidados;

    }
}