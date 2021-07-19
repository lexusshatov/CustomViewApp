package com.natife.example.customviewapp.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.setPadding

class VerticalLinearLayout(
    context: Context,
    attrs: AttributeSet? = null
): @JvmOverloads ViewGroup(context, attrs) {
    private val textSize = 18.0F
    private val textColor = Color.BLACK
    private val background = Color.WHITE
    private val padding = 20

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (child in children) {
            measureChildWithMargins(
                child, widthMeasureSpec, 0, heightMeasureSpec, 0
            )
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var topLocationOffset = t
        for (child in children) {
            child.apply {
                val childHeight = measuredHeight
                val childWidth = measuredWidth
                layout(
                    l, topLocationOffset, childWidth, topLocationOffset + childHeight
                )
                topLocationOffset += childHeight
            }
        }
    }

    fun addItem(item: String) {
        val textView = TextView(context).apply {
            text = item
            textSize = this@VerticalLinearLayout.textSize
            setTextColor(this@VerticalLinearLayout.textColor)
            setBackgroundColor(this@VerticalLinearLayout.background)
            setPadding(padding)
            layoutParams = MarginLayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        }
        addView(textView)
    }
}