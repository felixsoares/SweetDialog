package com.felixsoares.animateddialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felixsoares.sweetdialog.SweetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtMessage.setOnClickListener {

            SweetDialog()
                .setTitle("Hello world!")
                .setMessage("Lorem ypsuin log lgo gskdosi ndgpg sdnkgdgd gdsjgd")
                .setAnimation(SweetDialog.Animation.BOUNCE)
                .setCancellable(false)
                .setTimer(5000)
                .setPositiveColor(R.color.green)
                .setPositiveText("Ok")
                .onPositiveClick { dialog ->
                    dialog.dismiss()
                }
                .setNegativeColor(R.color.red)
                .setNegativeText("Cancel")
                .onNegativeClick { dialog ->
                    dialog.dismiss()
                }
                .show(this)
        }
    }
}
