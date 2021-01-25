package com.patricio.dutra.desafiosicredi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.patricio.dutra.desafiosicredi.model.Evento
import com.patricio.dutra.desafiosicredi.utils.Retrofit
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DethalheEventoViewModel : ViewModel() {

    val evento = MutableLiveData<Evento>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    val checkInStatus = MutableLiveData<String>()

    fun getEvento(id : String) {

        loading.value = true

        val callback =  Retrofit().endpoint.getEvento(id.toInt())

        callback.enqueue(object : Callback<Evento> {

            override fun onResponse(call: Call<Evento>, response: Response<Evento>) {
                response?.let {

                    loading.value = false

                    if(response.isSuccessful) {
                        evento.value = response.body()!!
                    }else if(response.errorBody() != null) {
                        it.errorBody()?.let{ result ->
                            var json:JSONObject = JSONObject(result.string())
                            error.value = json.getString("message").toString()
                        }
                    }
                }
            }


            override fun onFailure(result: Call<Evento>, t: Throwable) {
                error.value = t.message
                loading.value = false
            }
        })
    }

    fun checkInEvento(id : String, name : String, email : String) {

        var s = "{" +
                "\"eventId\": \"$id\"," +
                "\"name\": \"$name\"," +
                "\"email\": \"$email\"" +
                "}"

        var jsonObject = JSONObject(s)

        loading.value = true

        val callback =  Retrofit().endpoint.checkInEvento(jsonObject)

        callback.enqueue(object : Callback<JSONObject> {

            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                response?.let {

                    loading.value = false

                    if(response.isSuccessful) {
                        checkInStatus.value = "ok"
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

            override fun onFailure(result: Call<JSONObject>, t: Throwable) {
                error.value = t.message
                loading.value = false
            }
        })
    }
}