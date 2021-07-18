package com.natife.example.customviewapp.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.setPadding

class CustomLinearLayout(
    context: Context,
    attrs: AttributeSet? = null
): @JvmOverloads ViewGroup(context, attrs) {
    private val textSize = 18.0F
    private val textColor = Color.BLACK
    private val background = Color.WHITE
    private val padding = 20

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.text = item
        textView.textSize = textSize
        textView.setTextColor(textColor)
        textView.setBackgroundColor(background)
        textView.setPadding(padding)
        addView(textView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("TEST", "height: $suggestedMinimumHeight, width: $suggestedMinimumWidth")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var topLocationOffset = t
        for (child in children) {
            child.apply {
                //Log.d("TEST", "height: $measuredHeight, width: $measuredWidth")
                val childHeight = 500
                val childWidth = 500
                layout(
                    l,
                    topLocationOffset,
                    childWidth,
                    topLocationOffset + childHeight
                )
                topLocationOffset += childHeight
            }
        }
    }
}