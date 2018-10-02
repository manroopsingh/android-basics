package com.example.myapplication.customviews

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewTreeObserver
import android.widget.ProgressBar
import com.example.myapplication.R

class XfiGradientProgressBar constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.R.attr.progressBarStyleHorizontal) :
        ProgressBar(context, attrs, defStyleAttr) {

    private val startColor = Color.parseColor("#00C3FF")
    private val middleColor = Color.parseColor("#8170D7")
    private val endColor = Color.parseColor("#FF3F9A")

    private var progressPaint = Paint()

    private val backgroundPaint = Paint().apply { color = ContextCompat.getColor(context, R.color.accent_material_light) }
    private val cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5f, context.resources.displayMetrics)

    init {
        isIndeterminate = false
        viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val gradient = LinearGradient(0f, 0f, width.toFloat() - paddingLeft.toFloat() - paddingRight.toFloat(), 0f,
                        listOf(startColor, middleColor, endColor).toIntArray(),
                        listOf(0f,0.5f,1f).toFloatArray(),
                        Shader.TileMode.CLAMP)
                progressPaint.shader = gradient
                viewTreeObserver.removeOnGlobalLayoutListener (this)
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        val backgroundLeft = paddingLeft.toFloat()
        val backgroundRight = width.toFloat() - paddingRight.toFloat()
        val backgroundTop = paddingTop.toFloat()
        val backgroundBottom = height.toFloat() - paddingBottom.toFloat()

        canvas.drawRoundRect(
                backgroundLeft,
                backgroundTop,
                backgroundRight,
                backgroundBottom,
                cornerRadius,
                cornerRadius,
                backgroundPaint)

        val pct = progress.toFloat() / 100f

        val progressLeft = paddingLeft.toFloat()
        val progressRight = progressLeft + ((width.toFloat() - paddingLeft.toFloat() - paddingRight.toFloat())* pct)
        val progressTop = paddingTop.toFloat()
        val progressBottom = height.toFloat() - paddingBottom.toFloat()

        canvas.drawRoundRect(
                progressLeft,
                progressTop,
                progressRight,
                progressBottom,
                cornerRadius,
                cornerRadius,
                progressPaint)
    }
}