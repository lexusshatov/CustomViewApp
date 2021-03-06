package com.natife.example.customviewapp.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.natife.example.customviewapp.R
import kotlin.math.min

class RoundRectangleView(
    context: Context,
    attrs: AttributeSet? = null
) : @JvmOverloads View(context, attrs) {

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RectangleView,
            0, 0
        ).apply {
            roundRadius = getFloat(
                R.styleable.RectangleView_rv_roundRadius,
                ROUND_RADIUS_DEFAULT
            )
            strokeWidth = getFloat(
                R.styleable.RectangleView_rv_strokeWidth,
                STROKE_WIDTH_DEFAULT
            )
            strokeColor = getColor(
                R.styleable.RectangleView_rv_strokeColor,
                STROKE_COLOR_DEFAULT
            )
            color = getColor(
                R.styleable.RectangleView_rv_color,
                COLOR_DEFAULT
            )
            recycle()
        }
    }

    private var roundRadius: Float
    private var strokeWidth: Float
    private var strokeColor: Int
    private var color: Int
    private val rect = RectF()
    private val paintFill = Paint().apply {
        isAntiAlias = true
        color = this@RoundRectangleView.color
        style = Paint.Style.FILL
    }
    private val paintStroke = Paint().apply {
        isAntiAlias = true
        color = strokeColor
        strokeWidth = this@RoundRectangleView.strokeWidth
        style = Paint.Style.STROKE
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = calculateDimension(widthMeasureSpec, DEFAULT_WIDTH)
        val height = calculateDimension(heightMeasureSpec, DEFAULT_HEIGHT)
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        val strokeRadius = strokeWidth / 2
        rect.set(
            strokeRadius,
            strokeRadius,
            measuredWidth.toFloat() - strokeRadius,
            measuredHeight.toFloat() - strokeRadius
        )
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            drawRoundRect(rect, roundRadius, roundRadius, paintFill)
            if (strokeWidth > 0) {
                drawRoundRect(rect, roundRadius, roundRadius, paintStroke)
            }
        }
    }

    private fun calculateDimension(measureSpec: Int, defaultValue: Int) =
        when (MeasureSpec.getMode(measureSpec)) {
            MeasureSpec.EXACTLY -> MeasureSpec.getSize(measureSpec)
            MeasureSpec.AT_MOST -> {
                min(
                    MeasureSpec.getSize(measureSpec),
                    defaultValue
                )
            }
            else -> defaultValue
        }

    companion object {
        private const val ROUND_RADIUS_DEFAULT = 0.0F
        private const val STROKE_WIDTH_DEFAULT = 0.0F
        private const val STROKE_COLOR_DEFAULT = Color.BLACK
        private const val COLOR_DEFAULT = Color.WHITE

        private const val DEFAULT_WIDTH = 100
        private const val DEFAULT_HEIGHT = 100
    }
}

