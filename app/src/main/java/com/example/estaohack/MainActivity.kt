package com.example.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estaohack.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // btnSair.setOnClickListener {
        //    val mIntent = Intent(this, SplashActivity::class.java)
         //   startActivity(mIntent)
       // }
        val email = intent.getStringExtra("KEY_EMAIL")

        //recuperar informações recuperadas no SharedPreferences
        val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)

        //exibir informações recuperadas no view
        val nome= minhasPreferencias.getString("KEY_NOME", "Não encontrado")
        val sobrenome = minhasPreferencias.getString("KEY_SOBRENOME", "Não encontrado")
        val genero = minhasPreferencias.getString("KEY_GENERO", "Não encontrado")

        txvNomeCompleto.text = "$nome $sobrenome"
        txvEmail.text = email
        txvGenero.text = genero

        //implementar a lógica do botão sair
        //voltar para loginActivity
        btnSair.setOnClickListener (){
            //limpar a lista de empilhamento
            finishAffinity()
            //direcionar para determina Activity
            val mIntent = Intent(this,LoginActivity::class.java)
            startActivity(mIntent)
            //finalizar aplicação
            finishActivity()

        }

        //implementar a lógica do botão site
        //ir para webActivity
        btnSite.setOnClickListener() {
            val mIntent =Intent(this, WebActivity::class.java )
            startActivity(mIntent)

        }
    }
}
//colection = array = vetores/ arrayof= imutável/ arraylistof <Tipo>()
//intent = objeto global =! Intent = obj. local
//comentarios multiplos = CTRL +  /