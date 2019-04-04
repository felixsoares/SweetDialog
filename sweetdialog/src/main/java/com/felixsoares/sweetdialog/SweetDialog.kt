package com.felixsoares.sweetdialog

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.os.CountDownTimer
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SweetDialog {

    private var message: String? = null
    private var title: String? = null
    private var timeToClose: Long? = null

    private var btnPositiveText: String? = null
    private var btnPositiveTextColor: Int = R.color.white
    private var btnPositiveColor: Int = R.color.blue

    private var btnNegativeText: String? = null
    private var btnNegativeTextColor: Int = R.color.white
    private var btnNegativeColor: Int = R.color.dark

    private var animation = Animation.IN_TO_OUT
    private var cancellable = true
    private var type = Type.DEFAULT
    private var showProgress = Progress.INVISIBLE

    private var positiveCallback: ((Dialog) -> Unit)? = null
    private var negativeCallback: ((Dialog) -> Unit)? = null

    enum class Type {
        DEFAULT, SUCCESS, ERROR, DANGER
    }

    enum class Progress {
        VISIBLE, INVISIBLE
    }

    enum class Animation {
        TOP_TO_BOTTOM, TOP_TO_TOP,
        BOTTOM_TO_BOTTOM, BOTTOM_TO_TOP,
        LEFT_TO_RIGHT, LEFT_TO_LEFT,
        RIGHT_TO_LEFT, RIGTH_TO_RIGHT,
        FADE, BOUNCE, IN_TO_OUT
    }

    fun setMessage(message: String): SweetDialog {
        this.message = message
        return this
    }

    fun setTitle(title: String): SweetDialog {
        this.title = title
        return this
    }

    fun setPositiveText(positiveText: String): SweetDialog {
        this.btnPositiveText = positiveText
        return this
    }

    fun setTimer(timer: Long): SweetDialog {
        return setTimer(timer, Progress.INVISIBLE)
    }

    fun setTimer(timer: Long, showProgress: Progress): SweetDialog {
        this.timeToClose = timer
        this.showProgress = showProgress
        return this
    }

    fun setPositiveTextColor(color: Int): SweetDialog {
        this.btnPositiveTextColor = color
        return this
    }

    fun setNegativeTextColor(color: Int): SweetDialog {
        this.btnNegativeTextColor = color
        return this
    }

    fun setPositiveColor(color: Int): SweetDialog {
        this.btnPositiveColor = color
        return this
    }

    fun setNegativeColor(color: Int): SweetDialog {
        this.btnNegativeColor = color
        return this
    }

    fun setCancellable(cancellable: Boolean): SweetDialog {
        this.cancellable = cancellable
        return this
    }

    fun setAnimation(animation: Animation): SweetDialog {
        this.animation = animation
        return this
    }

    fun setType(type: Type): SweetDialog {
        this.type = type
        return this
    }

    fun onPositiveClick(callback: (Dialog) -> Unit): SweetDialog {
        this.positiveCallback = callback
        return this
    }

    fun onNegativeClick(callback: (Dialog) -> Unit): SweetDialog {
        this.negativeCallback = callback
        return this
    }

    fun setNegativeText(negativeText: String): SweetDialog {
        this.btnNegativeText = negativeText
        return this
    }

    fun show(context: Context) {
        val dialog = Dialog(context, R.style.Theme_Dialog)
        setupAnimation(dialog, animation)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(cancellable)

        setText(title, dialog.findViewById(R.id.txtTitle))
        setText(message, dialog.findViewById(R.id.txtMessage))

        createButton(
            dialog.findViewById(R.id.btnPositive),
            btnPositiveText,
            btnPositiveTextColor, btnPositiveColor,
            positiveCallback,
            dialog, context
        )

        createButton(
            dialog.findViewById(R.id.btnNegative),
            btnNegativeText,
            btnNegativeTextColor, btnNegativeColor,
            negativeCallback,
            dialog, context
        )

        setupImage(dialog.findViewById(R.id.lottie))
        closeDialog(dialog)

        dialog.show()
    }

    private fun closeDialog(dialog: Dialog) {
        val progress = dialog.findViewById<ProgressBar>(R.id.progress)

        if (timeToClose != null) {

            if (showProgress == Progress.VISIBLE) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
            }

            progress.max = timeToClose!!.toInt()

            object : CountDownTimer(timeToClose!!, 1000) {
                override fun onFinish() {
                    dialog.dismiss()
                }

                override fun onTick(millisUntilFinished: Long) {
                    progress.progress = millisUntilFinished.toInt()
                }
            }.start()
        } else {
            progress.visibility = View.GONE
        }
    }

    private fun setupAnimation(dialog: Dialog, animation: Animation) {
        dialog.window?.attributes?.windowAnimations = when (animation) {
            Animation.BOUNCE -> {
                R.style.bounce
            }
            Animation.FADE -> {
                R.style.fade
            }
            Animation.LEFT_TO_LEFT -> {
                R.style.left_to_left
            }
            Animation.LEFT_TO_RIGHT -> {
                R.style.left_to_rigth
            }
            Animation.RIGHT_TO_LEFT -> {
                R.style.rigth_to_left
            }
            Animation.RIGTH_TO_RIGHT -> {
                R.style.right_to_right
            }
            Animation.TOP_TO_BOTTOM -> {
                R.style.top_to_bottom
            }
            Animation.TOP_TO_TOP -> {
                R.style.top_to_top
            }
            Animation.BOTTOM_TO_BOTTOM -> {
                R.style.bottom_to_bottom
            }
            Animation.BOTTOM_TO_TOP -> {
                R.style.bottom_to_up
            }
            else -> {
                R.style.in_to_out
            }
        }
    }

    private fun setupImage(lottie: LottieAnimationView) {
        if (type != Type.DEFAULT) {
            val animation = when (type) {
                Type.SUCCESS -> "success"
                Type.DANGER -> "error"
                else -> "warning"
            }

            Handler().postDelayed({
                lottie.setAnimation("$animation.json")
                lottie.playAnimation()
            }, 200)
        } else {
            lottie.visibility = View.GONE
        }
    }

    private fun createButton(
        btn: AppCompatButton,
        btnText: String? = null,
        color: Int, bg: Int,
        callback: ((Dialog) -> Unit)? = null,
        dialog: Dialog, context: Context
    ) {
        if (btnText != null && callback != null) {
            btn.visibility = View.VISIBLE
            btn.text = btnText
            btn.setOnClickListener {
                callback(dialog)
            }
            btn.setTextColor(ContextCompat.getColor(context, color))
            ViewCompat.setBackgroundTintList(btn, ColorStateList.valueOf(ContextCompat.getColor(context, bg)))
        } else {
            btn.visibility = View.GONE
        }
    }

    private fun setText(text: String?, textView: TextView) {
        if (text != null) {
            textView.visibility = View.VISIBLE
            textView.text = text
        } else {
            textView.visibility = View.GONE
        }
    }

}