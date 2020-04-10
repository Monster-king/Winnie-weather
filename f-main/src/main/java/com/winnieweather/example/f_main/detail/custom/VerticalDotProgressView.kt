package com.winnieweather.example.f_main.detail.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.winnieweather.example.f_main.R
import ru.surfstudio.android.utilktx.util.ViewUtil

class VerticalDotProgressView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : View(context, attrs) {

    private var widthPx = 0
    private var heightPx = 0
    private var rectF = RectF(0f, 0f, 0f, 0f)
    private var paint = Paint().apply {
        isAntiAlias = true
    }
    private val dotMarginHorizontal = ViewUtil.convertDpToPx(context, 3f)
    private val dotMarginVertical = ViewUtil.convertDpToPx(context, 3f)

    @ColorInt
    var strokeColor: Int = ContextCompat.getColor(context, R.color.textColorSecondary)
        set(value) {
            field = value
            invalidate()
        }
    @ColorInt
    var dotColor: Int = ContextCompat.getColor(context, R.color.colorIconAccent)
        set(value) {
            field = value
            invalidate()
        }
    var maxProgress: Int = 100
        set(value) {
            field = value
            invalidate()
        }
    var progress: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    init {
        initAttrs(attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        widthPx = MeasureSpec.getSize(widthMeasureSpec)
        heightPx = MeasureSpec.getSize(heightMeasureSpec)
        rectF.right = 1f * widthPx
        rectF.bottom = 1f * heightPx
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = strokeColor
        paint.style = Paint.Style.STROKE
        canvas.drawRoundRect(rectF, widthPx / 2f, widthPx / 2f, paint)
        paint.style = Paint.Style.FILL
        paint.color = dotColor
        canvas.drawCircle(widthPx / 2f, calculatePositionY(), getRadius(), paint)
    }

    private fun initAttrs(attrs: AttributeSet?) {
        attrs ?: return
        context.obtainStyledAttributes(attrs, R.styleable.VerticalDotProgressView).run {
            strokeColor = getColor(R.styleable.VerticalDotProgressView_strokeColor, strokeColor)
            dotColor = getColor(R.styleable.VerticalDotProgressView_dotColor, dotColor)
            maxProgress = getInteger(R.styleable.VerticalDotProgressView_maxProgress, maxProgress)
            progress = getInteger(R.styleable.VerticalDotProgressView_progress, progress)
            recycle()
        }
    }

    private fun calculatePositionY(): Float {
        val maxProgressHeight = heightPx - getRadius() * 2 - dotMarginVertical * 2
        return maxProgressHeight - maxProgressHeight / maxProgress * progress + getRadius() + dotMarginVertical
    }

    private fun getRadius(): Float {
        return (widthPx - dotMarginHorizontal) / 2f
    }
}