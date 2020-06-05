package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.estacaohack.MainActivity
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnCadastrar

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Escutando o botão entrar
        btnEntrar.setOnClickListener {

            //Capturando os dados
            val email = edtLoginEmail.text.toString()
            val senha = edtLoginSenha.text.toString()

            //validar os dados
            if (email.isEmpty()){
                edtLoginEmail.error = "Campo Obrigatório"
                edtLoginEmail.requestFocus()
            }
            else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo Obrigatório"
                edtLoginSenha.requestFocus()
            }
            else {

                //Recuperar informações no SharedPreferences
                val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)
                val emailpref = minhasPreferencias("KEY_EMAIL", "")
                val senhapref = minhasPreferencias("KEY_SENHA", "")

                //verificar email e senha (if aninhado)
                if (email == emailpref && senha == senhapref) {
                    //exibindo um toast / ver onde o this referencia = ctrl +B
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário logado",
                        Toast.LENGTH_LONG
                    ).show()

                    //mudando para mainActivity
                    val mIntent = Intent(this, MainActivity::class.java )
                    mIntent.putExtra("KEY_EMAIL", email)
                    startActivity(mIntent)
                    //finish para não voltar a tela anterior e remove da tela de empilhamento
                    finish()
                }

                else {
                    //Recuperar
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário ou senha incorretos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        //Escutando o botão cadastrar
        btnCadastrar.setOnClickListener {
            // ir para tela de cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
            finish()
        }

    }
}
