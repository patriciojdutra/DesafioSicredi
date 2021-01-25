package com.patricio.dutra.desafiosicredi.view

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.patricio.dutra.desafiosicredi.R
import com.patricio.dutra.desafiosicredi.model.Evento
import com.patricio.dutra.desafiosicredi.utils.Utils
import com.squareup.picasso.Picasso


class RecyclerAdapter (private val listaDeEvento: ArrayList<Evento>, var act: Activity): RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.lista_de_eventos,parent,false) as View
        return Holder(v)

    }

    override fun getItemCount() = listaDeEvento.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.txtPreco.setText(Utils.formatarDinheiro(listaDeEvento[position].price))
        holder.txtData.setText(Utils.formatarData(listaDeEvento[position].date!!))
        holder.txtHeadNews.setText(listaDeEvento[position].title)
        holder.txtBodyNews.setText(listaDeEvento[position].description)
        Picasso.get().load(listaDeEvento[position].image)
            .error(R.drawable.sicredi)
            .into(holder.imageView);

        holder.layout.setOnClickListener {

            var intent = Intent(act, DetalheEventoActivity::class.java)
            intent.putExtra("id",listaDeEvento[position].id)
            act.startActivity(intent)

        }

    }

    class Holder(v: View) : RecyclerView.ViewHolder(v) {

        val txtBodyNews = v.findViewById<TextView>(R.id.txtBodyNews)
        val txtHeadNews = v.findViewById<TextView>(R.id.txtHeadNews)
        val imageView = v.findViewById<ImageView>(R.id.imageView3)
        val txtPreco = v.findViewById<TextView>(R.id.txtPreco)
        val txtData = v.findViewById<TextView>(R.id.textData)
        val layout = v.findViewById<ConstraintLayout>(R.id.layout)
    }

}



