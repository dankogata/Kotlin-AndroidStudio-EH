package com.example.estacaohack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.estaohack.LoginActivity
import com.example.estaohack.R
import com.example.estaohack.WebActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            //direcionar para determina Activity
            val mIntent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(mIntent)
            //finalizar aplicação
            finish()

        }

        //implementar a lógica do botão site
        //ir para webActivity
        btnSite.setOnClickListener() {
            val mIntent =Intent(this@MainActivity, WebActivity::class.java )
            startActivity(mIntent)

        }
    }
}
//colection = array = vetores/ arrayof= imutável/ arraylistof <Tipo>()
//intent = objeto global =! Intent = obj. local
//comentarios multiplos = CTRL +  /