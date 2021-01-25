package com.patricio.dutra.desafiosicredi.utils

import com.patricio.dutra.desafiosicredi.model.Evento
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface Endpoint {

    @GET("events")
    fun getEventos() : Call<ArrayList<Evento>>

    @GET("events/{id}")
    fun getEvento(@Path("id") id:Int) : Call<Evento>

    @POST("checkin")
    fun checkInEvento(@Body jsonObject: JSONObject) : Call<JSONObject>

}