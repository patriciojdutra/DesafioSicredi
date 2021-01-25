package com.patricio.dutra.desafiosicredi.model


data class Evento (

    var id:String?,
    var title:String?,
    var price:Double?,
    var latitude:String?,
    var longitude:String?,
    var image: String?,
    var description: String?,
    var date: Long?,
    var people: ArrayList<Pessoa>?

) {
    override fun toString(): String {
        return "Venha participar do evento\n$title\n\nDescrição: $description."
    }
}
