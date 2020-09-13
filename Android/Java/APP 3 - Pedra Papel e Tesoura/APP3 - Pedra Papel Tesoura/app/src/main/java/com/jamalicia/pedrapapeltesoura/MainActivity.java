package com.jamalicia.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.img_adversário);
        TextView txtResult = findViewById(R.id.text_result);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoSelecionada == "pedra" && opcaoApp == "papel") ||
                        (opcaoSelecionada == "tesoura" && opcaoApp == "pedra") ||
                        (opcaoSelecionada == "papel" && opcaoApp == "tesoura")
        ) {
            txtResult.setText("Você perdeu ):");

        } else if (
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura") ||
                        (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                        (opcaoSelecionada == "papel" && opcaoApp == "pedra")
        ) {
            txtResult.setText("Você ganhou, ebaaa :)");

        } else {
            txtResult.setText("Foi um empate :/");
        }


    }
}