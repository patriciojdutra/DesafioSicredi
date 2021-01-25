package com.patricio.dutra.desafiosicredi.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        var moedaSistema = NumberFormat.getInstance()

        @JvmStatic fun formatarDinheiro(dinheiro:Double?): String{
            var dinheiroFormatado = moedaSistema.format(dinheiro)
            return "R$ "+dinheiroFormatado
        }

        @JvmStatic fun formatarData(data:Long): String{

            try {
                val date = Date(data)
                val format = SimpleDateFormat("dd/MM/yyyy")
                return "Data: " + format.format(date)
            }catch (e:Exception){
                return ""
            }
        }
    }
}