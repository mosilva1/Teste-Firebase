package com.example.teste_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityCadastroBinding extends AppCompatActivity {

    private CadastroActivity binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        binding.btnCadastro.setOnClickListener(view -> validaDados());
    }

    private void validaDados(){
        String email = binding.editEmail.getText().toString().trim();
        String senha = binding.editSenha.getText().toString().trim();

        if (!email.isEmpty()){
            if (!senha.isEmpty()){
                binding.progressBar.setVisibility(View.VISIBLE);
                criarContaFirebase(email,senha);
            }else{
                Toast.makeText(this, "Informe uma Senha ! ", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Informe seu E-mail ! ", Toast.LENGTH_SHORT).show();
        }
    }

    private void criarContaFirebase(String email, String senha){
        mAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                finish();
                startActivity(new Intent(this,MainActivity.class));
            }else{
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(this, "Ocorreu um erro !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}