package com.patricio.dutra.desafiosicredi.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.patricio.dutra.desafiosicredi.R
import com.patricio.dutra.desafiosicredi.utils.DialogUtils
import com.patricio.dutra.desafiosicredi.utils.Utils
import com.patricio.dutra.desafiosicredi.viewmodel.DethalheEventoViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_evento.*
import kotlinx.android.synthetic.main.activity_main.*

class DetalheEventoActivity : AppCompatActivity() {

    private val viewModel: DethalheEventoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_evento)

        var intent = intent
        var id = intent.extras?.getString("id")

        viewModel.getEvento(id!!)

        viewModel.evento.observe(this, Observer {

            txtTitle.setText(it.title)
            txtPreco.setText(Utils.formatarDinheiro(it.price))
            txtData.setText(Utils.formatarData(it.date!!))
            txtDescricao.setText(it.description)
            Picasso.get().load(it.image).into(imgFotoEvento);

        })

        viewModel.error.observe(this, Observer {
            DialogUtils.avisoDialog("Houve um erro",it,this)
        })

        viewModel.loading.observe(this, Observer {
            if(it)
                progressBar2.visibility = View.VISIBLE
            else
                progressBar2.visibility = View.GONE
        })

        viewModel.checkInStatus.observe(this, Observer {
            DialogUtils.avisoDialog("Status","Check-in realizado com sucesso!",this)
        })

        btnCheckIn.setOnClickListener {

            lateinit var dialog: Dialog
            var view = View.inflate(this, R.layout.dialog_layout_formulario,null)

            view.findViewById<Button>(R.id.btnConfirmar).setOnClickListener {

                var nome = view.findViewById<EditText>(R.id.edtNome).text.toString()
                var email = view.findViewById<EditText>(R.id.edtEmail).text.toString()
                progressBar2.visibility = View.VISIBLE

                viewModel.checkInEvento(id!!,nome,email)
                dialog.dismiss()

            }

            view.findViewById<Button>(R.id.btnCancelar).setOnClickListener {
                dialog.dismiss()
            }


            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            builder.setCancelable(false)

            dialog = builder.create()
            dialog.show()


        }

        btnCompartilhar.setOnClickListener {

            val shareBody = viewModel.evento.value.toString()

            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Desafio Sicredi"))

        }


    }
}