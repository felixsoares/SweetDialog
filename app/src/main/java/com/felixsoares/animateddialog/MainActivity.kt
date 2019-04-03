package com.felixsoares.animateddialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felixsoares.sweetdialog.SweetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .show(this)
        }

        btn2.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setCancellable(false)
                .setPositiveText("Ok")
                .onPositiveClick { dialog ->
                    dialog.dismiss()
                }
                .show(this)
        }

        btn3.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setCancellable(false)
                .setPositiveText("Ok")
                .onPositiveClick { dialog ->
                    dialog.dismiss()
                }
                .setNegativeText("Cancel")
                .onNegativeClick { dialog ->
                    dialog.dismiss()
                }
                .show(this)
        }

        btn4.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setCancellable(false)
                .setPositiveColor(android.R.color.holo_orange_dark)
                .setPositiveTextColor(R.color.black)
                .setPositiveText("Positive =)")
                .onPositiveClick { dialog ->
                    dialog.dismiss()
                }
                .setNegativeColor(R.color.black)
                .setNegativeTextColor(R.color.red)
                .setNegativeText("Negative =(")
                .onNegativeClick { dialog ->
                    dialog.dismiss()
                }
                .show(this)
        }

        btn5.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setCancellable(false)
                .setTimer(5000)
                .show(this)
        }

        btn6.setOnClickListener {

            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setType(SweetDialog.Type.SUCCESS)
                .show(this)
        }

        btn7.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setType(SweetDialog.Type.DANGER)
                .show(this)
        }

        btn8.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setType(SweetDialog.Type.ERROR)
                .show(this)
        }

        btn9.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.IN_TO_OUT)
                .show(this)
        }

        btn10.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.BOUNCE)
                .show(this)
        }

        btn11.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.LEFT_TO_LEFT)
                .show(this)
        }

        btn12.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.LEFT_TO_RIGHT)
                .show(this)
        }

        btn13.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.RIGTH_TO_RIGHT)
                .show(this)
        }

        btn14.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.RIGHT_TO_LEFT)
                .show(this)
        }

        btn15.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.BOTTOM_TO_BOTTOM)
                .show(this)
        }

        btn16.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.BOTTOM_TO_TOP)
                .show(this)
        }

        btn17.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.TOP_TO_TOP)
                .show(this)
        }

        btn18.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.TOP_TO_BOTTOM)
                .show(this)
        }

        btn19.setOnClickListener {
            SweetDialog()
                .setTitle("Lorem ipsum")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.")
                .setAnimation(SweetDialog.Animation.FADE)
                .show(this)
        }
    }
}
