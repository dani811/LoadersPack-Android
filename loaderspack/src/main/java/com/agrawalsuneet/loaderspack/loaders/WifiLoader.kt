package com.agrawalsuneet.loaderspack.loaders

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.agrawalsuneet.loaderspack.basicviews.LoaderContract

/**
 * Created by agrawalsuneet on 9/24/18.
 */

class WifiLoader : View, LoaderContract {

    var centerCircleRadius: Int = 30

    var wifiColor: Int = resources.getColor(android.R.color.holo_green_light)

    var incrementalAngle: Float = 1.0f
        set(value) {
            field = if (value < 0.1) 1.0f else value
        }

    private val centerCirclePaint: Paint = Paint()
    private val sidesPaint: Paint = Paint()

    private var rectfArray = Array<RectF?>(3) { it -> null }

    private var calWidth = 0
    private var calHeight = 0

    private var xCor: Float = 0.0f
    private var yCor: Float = 0.0f

    private val startAngle: Float = 230.0f
    private val sweepAngle: Float = 80.0f
    private val waitFrame: Int = 60

    private var currentSweepAngle: Float = 0.0f
    private var visibleShapePos: Int = 0
    private var isDrawingForward: Boolean = true

    private var currentWaitFrame: Int = 0


    constructor(context: Context) : super(context) {
        initPaints()
        initValues()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initPaints()
        initValues()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttributes(attrs)
        initPaints()
        initValues()
    }

    override fun initAttributes(attrs: AttributeSet) {
        /*val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClockLoader, 0, 0)

        this.outerCircleBorderWidth = typedArray
                .getDimension(R.styleable.ClockLoader_clock_outerCircleBorderWidth, 30.0f)
        this.bigCircleRadius = typedArray
                .getDimension(R.styleable.ClockLoader_clock_bigCircleRadius, 350.0f)
        this.innerCircleRadius = typedArray
                .getDimension(R.styleable.ClockLoader_clock_innerCircleRadius, 20.0f)
        this.hourHandLength = typedArray
                .getDimension(R.styleable.ClockLoader_clock_hourHandLength, 240.0f)
        this.minuteHandLength = typedArray
                .getDimension(R.styleable.ClockLoader_clock_minuteHandLength, 300.0f)

        this.outerCircleBorderColor = typedArray
                .getColor(R.styleable.ClockLoader_clock_outerCircleBorderColor, resources.getColor(android.R.color.darker_gray))
        this.bigCircleColor = typedArray
                .getColor(R.styleable.ClockLoader_clock_bigCircleColor, resources.getColor(android.R.color.black))
        this.innerCircleColor = typedArray
                .getColor(R.styleable.ClockLoader_clock_innerCircleColor, resources.getColor(android.R.color.darker_gray))
        this.hourHandColor = typedArray
                .getColor(R.styleable.ClockLoader_clock_hourHandColor, resources.getColor(android.R.color.darker_gray))
        this.minuteHandColor = typedArray
                .getColor(R.styleable.ClockLoader_clock_minuteHandColor, resources.getColor(android.R.color.darker_gray))

        this.animSpeedMultiplier = typedArray
                .getFloat(R.styleable.ClockLoader_clock_animSpeedMultiplier, 1.0f)

        typedArray.recycle()*/
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (calWidth == 0 || calHeight == 0) {
            calWidth = 18 * centerCircleRadius
            calHeight = 14 * centerCircleRadius
        }

        setMeasuredDimension(calWidth, calHeight)
    }


    private fun initPaints() {
        centerCirclePaint.isAntiAlias = true
        centerCirclePaint.color = wifiColor
        centerCirclePaint.style = Paint.Style.FILL


        sidesPaint.isAntiAlias = true
        sidesPaint.color = wifiColor
        sidesPaint.style = Paint.Style.STROKE
        sidesPaint.strokeWidth = (2 * centerCircleRadius).toFloat()
        sidesPaint.strokeCap = Paint.Cap.ROUND
    }

    private fun initValues() {
        if (calWidth == 0 || calHeight == 0) {
            calWidth = 18 * centerCircleRadius
            calHeight = 14 * centerCircleRadius
        }

        for (i in 1..3) {

            val acrRectF = RectF().apply {
                left = ((calWidth / 2) - (i * 4 * centerCircleRadius)).toFloat()
                right = ((calWidth / 2) + (i * 4 * centerCircleRadius)).toFloat()
                top = ((calHeight - centerCircleRadius) - (((i * 4)) * centerCircleRadius)).toFloat()
                bottom = ((calHeight - centerCircleRadius) + (((i * 4)) * centerCircleRadius)).toFloat()
            }

            rectfArray.set(i - 1, acrRectF)

        }

        xCor = (calWidth / 2).toFloat()
        yCor = (calHeight - centerCircleRadius).toFloat()
    }

    private fun drawCenterCircle(canvas: Canvas) {
        canvas.drawCircle(xCor, yCor,
                centerCircleRadius.toFloat(),
                centerCirclePaint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        when (visibleShapePos) {
            0 -> {
                currentWaitFrame++
                if (isDrawingForward) {
                    if (currentWaitFrame > (waitFrame / 2)) {
                        drawCenterCircle(canvas)
                        if (currentWaitFrame > waitFrame) {
                            visibleShapePos++
                            currentWaitFrame = 0
                        }
                    }
                } else {
                    if (currentWaitFrame < (waitFrame / 2)) {
                        drawCenterCircle(canvas)
                    } else if (currentWaitFrame > waitFrame) {
                        isDrawingForward = true
                        currentWaitFrame = 0
                    }

                }
            }

            1, 2, 3 -> {

                drawCenterCircle(canvas)

                for (i in 1 until visibleShapePos) {
                    canvas.drawArc(rectfArray.get(i - 1), startAngle, sweepAngle, false, sidesPaint)
                }

                canvas.drawArc(rectfArray.get(visibleShapePos - 1), startAngle, currentSweepAngle, false, sidesPaint)

                if (isDrawingForward) {

                    if (visibleShapePos <= 3) {

                        currentSweepAngle += incrementalAngle

                        if (currentSweepAngle >= sweepAngle) {
                            currentSweepAngle = 0.0f
                            visibleShapePos++
                        }
                    }
                } else {
                    currentSweepAngle -= incrementalAngle

                    if (currentSweepAngle <= 0.0f) {
                        currentSweepAngle = sweepAngle
                        visibleShapePos--
                    }

                    if (visibleShapePos == 0) {
                        currentSweepAngle = 0.0f
                        currentWaitFrame = 0
                    }
                }
            }

            4 -> {
                drawCenterCircle(canvas)
                for (i in 1 until visibleShapePos) {
                    canvas.drawArc(rectfArray.get(i - 1), startAngle, sweepAngle, false, sidesPaint)
                }

                currentWaitFrame++

                if (currentWaitFrame > waitFrame) {
                    visibleShapePos--
                    isDrawingForward = false
                    currentSweepAngle = sweepAngle
                }
            }
        }

        postInvalidateOnAnimation()
    }
}