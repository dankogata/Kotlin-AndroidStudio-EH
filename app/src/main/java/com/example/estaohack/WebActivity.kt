package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.estacaohack.MainActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
//fun = function / fun variavel (a:int, b:int){()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitar a execução de javascript no webView
        wbvSite.settings.javaScriptEnabled = true

        //Abir o site do cel.lep - http://br.cellep.com/estacaohack
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        //Definir o cliente padrão que deverá atender as requisições
        wbvSite.webViewClient = WebViewClient()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}
