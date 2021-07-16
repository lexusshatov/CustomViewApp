package com.natife.example.customviewapp.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class CustomLinearLayout(
    context: Context,
    attrs: AttributeSet? = null
): @JvmOverloads LinearLayout(context, attrs) {
    private val textSize = 18.0F
    private val textColor = Color.BLACK
    private val background = Color.WHITE
    private val padding = 4

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        orientation = VERTICAL
    }

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.text = item
        textView.textSize = textSize
        textView.setTextColor(textColor)
        textView.setBackgroundColor(background)
        textView.setPadding(padding)
        addView(textView)
    }
}