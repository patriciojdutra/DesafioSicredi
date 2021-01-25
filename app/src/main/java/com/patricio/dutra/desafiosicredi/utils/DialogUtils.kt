package com.patricio.dutra.desafiosicredi.utils

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface

class DialogUtils {

    companion object {

        @JvmStatic fun avisoDialog(titulo:String, msg:String, act: Activity){

            lateinit var dialog: Dialog

            val builder = AlertDialog.Builder(act)
            builder.setTitle(titulo)
            builder.setMessage(msg)
            builder.setCancelable(false)
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                act.finish()
            })
            dialog = builder.create()
            dialog.show()

        }
    }
}