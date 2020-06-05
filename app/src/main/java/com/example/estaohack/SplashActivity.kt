package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

//funcional (linguagem C) e orientados a objetos(C++ , Csharp)
//atributos -> variaveis
//métodos -> funções
//POO ou OOP (prog. orientado aos objetos)
//Classe -> projeto ou molde
//escopo ou bloco de comando = { }
//classes ,interfaces com heranças multíplas
// herança ( :) como notado abaixo =  mudar de tela, recursos internos ( apenas 1 herança por vez, nunca heranças multiplas)
class SplashActivity : AppCompatActivity() {
//onCreate  = função executada internamento no android  => life cycle - ciclo de vida da activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    //executar uma ação após determinado tempo
        Handler().postDelayed({
            //Intent : intenção /instancia
            //val apenas leitura, var pode mudar
            val mIntent = Intent(this, LoginActivity::class.java)
            //tela :: class.java = efetuar troca de tela
            startActivity(mIntent)
            //remove a activity da pilha de activities
            finish()
        }, 3000)
    }
}
