package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.estacaohack.MainActivity
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //Criando uma lista de opções para o spinner (array ou vetor)
        //arrayOf = lista imutável
        //arraylistof =lista mutável

        val listaGenero = arrayOf(
            "Selecione o gênero",
            "Masculino",
            "Feminino",
            "Outros")

        //Criando o adpatador para spinner

        val spinnerAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaGenero
        )
        //plugando o adaptador
        spnCadastroGenero.adapter = spinnerAdapter

        //escutando o botão cadastrar
        btnCadastrar.setOnClickListener {
            //obter os dados
            //nome.trim() tira os espaços da palavra
            val nome = edtCadastroNome.text.toString().trim()
            val sobreNome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()

            var genero = ""
            if (spnCadastroGenero.selectedItemId != 0L){
                genero = spnCadastroGenero.selectedItem.toString()
            }

            //validando os campos preenchidos
            if (nome.isEmpty() || sobreNome.isEmpty() || email.isEmpty() || senha.isEmpty() || genero.isEmpty()){

                //Mensagem de erro
                Toast.makeText(
                    this@CadastroActivity,
                    "Todos os campos são obrigatórios",
                    Toast.LENGTH_LONG
                ).show()

            }
            else {

                //Salvando os dados locais nas preferencias compartilhadas(SharedPreferences)
                val minhasPreferencias = getSharedPreferences(
                    "cadastro-$email",
                    Context.MODE_PRIVATE
                )
                //Habilitar o sharedPreferences para edição
                //apply = função de contexto + let,with
                minhasPreferencias.edit().apply{
                    putString("KEY_NOME",nome)
                    putString("KEY_SOBRENOME", sobreNome)
                    putString("KEY_EMAIL", email)
                    putString("KEY_SENHA", senha)
                    putString("KEY_GENERO", genero)
                }.apply() //retorna a referencia como this

                //Abrir a tela MainActivity
                btnCadastrar.setOnClickListener(){
                    val mIntent= Intent(this, MainActivity::class.java)
                    //passando informações através da intent
                    mIntent.putExtra("KEY_EMAIL",email)
                    //troca de tela
                    startActivity(mIntent)
                    //limpar o empilhamento de telas
                    finishAffinity()

                }



            }

        }
    }
}
