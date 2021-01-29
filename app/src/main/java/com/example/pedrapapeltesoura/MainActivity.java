package com.example.pedrapapeltesoura;

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

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){
        ImageView imagem = findViewById(R.id.imageResultado);
        TextView texto = findViewById(R.id.Resultado);

        String[] opcaosDoApp = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);
        String opcaoSelecionadaApp = opcaosDoApp[numero];

        switch (opcaoSelecionadaApp){
            case "Pedra":
                imagem.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagem.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagem.setImageResource(R.drawable.tesoura);
                break;
        }

       if(
                (opcaoSelecionadaApp.equals("Pedra")&&opcaoUsuario.equals("Tesoura"))||
                (opcaoSelecionadaApp.equals("Tesoura")&&opcaoUsuario.equals("Papel"))||
                (opcaoSelecionadaApp.equals("Papel")&&opcaoUsuario.equals("Pedra"))
       ){
            texto.setText("Você perdeu!");
        }else if(
                        (opcaoUsuario.equals("Pedra")&&opcaoSelecionadaApp.equals("Tesoura"))||
                        (opcaoUsuario.equals("Tesoura")&&opcaoSelecionadaApp.equals("Papel"))||
                        (opcaoUsuario.equals("Papel")&&opcaoSelecionadaApp.equals("Pedra"))
       ){
           texto.setText("Você ganhou!");
       }else{
           texto.setText("Empate!");
       }
    }

}
