package com.jamalicia.entregasquebrada.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.jamalicia.entregasquebrada.R;
import com.jamalicia.entregasquebrada.helper.ConfiguracaoFirebase;

public class AutenticacaoActivity extends AppCompatActivity {

    private Button botaoAcessar;
    private EditText campoEmail;
    private EditText campoSenha;
    private Switch tipoAcesso;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacao);
        getSupportActionBar().hide();

        inicializarComponentes();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if(!email.isEmpty()){
                    if(!senha.isEmpty()){

                        //Verifica estado do Switch
                        if(tipoAcesso.isChecked()){
                            //Cadastro
                            autenticacao.createUserWithEmailAndPassword(
                                    email, senha
                            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if ( task.isSuccessful()){
                                        Toast.makeText(AutenticacaoActivity.this, "Cadastro realizado com sucesso",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                                    } else {
                                        String erroExcecao= "";

                                        try {
                                            throw task.getException();
                                        } catch (FirebaseAuthWeakPasswordException e) {
                                            erroExcecao = "Digite uma senha mais forte!";
                                        } catch (FirebaseAuthInvalidCredentialsException e) {
                                            erroExcecao = "Digite um e-mail válido!";
                                        } catch (FirebaseAuthUserCollisionException e) {
                                            erroExcecao = "Esta conta já está cadastrada!";
                                        } catch (Exception e) {
                                            erroExcecao = "erro ao cadastrar usuário: " + e.getMessage() ;
                                            e.printStackTrace();
                                        }

                                        Toast.makeText(AutenticacaoActivity.this, "Erro: " + erroExcecao ,
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                        } else {
                            //Login
                        }
                    } else {
                        Toast.makeText(AutenticacaoActivity.this,"Preencha a senha!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AutenticacaoActivity.this,"Preencha o e-mail!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarComponentes(){
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        botaoAcessar = findViewById(R.id.buttonAcesso);
        tipoAcesso = findViewById(R.id.switchAcesso);
    }
}