package com.patricio.dutra.desafiosicredi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patricio.dutra.desafiosicredi.model.Evento
import com.patricio.dutra.desafiosicredi.utils.Retrofit
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EventosViewModel : ViewModel() {

    val listaDeEventos = MutableLiveData<ArrayList<Evento>>()
    var lista = ArrayList<Evento>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun getEvento() {

        loading.value = true

        val callback =  Retrofit().endpoint.getEventos()

        callback.enqueue(object : Callback<ArrayList<Evento>> {

            override fun onResponse(call: Call<ArrayList<Evento>>, response: Response<ArrayList<Evento>>) {
                response?.let {

                    loading.value = false

                    if(response.isSuccessful) {
                        lista.addAll(response.body()!!)
                        listaDeEventos.value = lista
                    }else if(response.errorBody() != null) {

                        it.errorBody()?.let{ result ->
                            try {
                                error.value = result.string()
                            }catch (e : Exception){
                                error.value = e.message
                            }
                        }
                    }
                }
            }


            override fun onFailure(result: Call<ArrayList<Evento>>, t: Throwable) {
                error.value = t.message
                loading.value = false
            }
        })
    }
}