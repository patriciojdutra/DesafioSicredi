package com.patricio.dutra.desafiosicredi.view

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.patricio.dutra.desafiosicredi.R
import com.patricio.dutra.desafiosicredi.model.Evento
import com.patricio.dutra.desafiosicredi.utils.DialogUtils
import com.patricio.dutra.desafiosicredi.viewmodel.EventosViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_lista_eventos.*

class MainActivity : AppCompatActivity() {

    private val viewModel: EventosViewModel by viewModels()
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //if(savedInstanceState == null)
            viewModel.getEvento()
//        else{
//            loadList(viewModel.listaDeEventos.value!!)
//            progressBar.visibility = View.GONE
//        }

        viewModel.listaDeEventos.observe(this, Observer {
            loadList(it)
        })

        viewModel.loading.observe(this, Observer {
            if(it)
                 progressBar.visibility = View.VISIBLE
            else
                 progressBar.visibility = View.GONE
        })

        viewModel.error.observe(this, Observer {
            DialogUtils.avisoDialog("Houve um erro",it,this)
        })

    }

    fun loadList(list: ArrayList<Evento>){

        val linearLayoutManager = LinearLayoutManager ( this )
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(list, this)
        recyclerView.adapter = adapter
    }

}