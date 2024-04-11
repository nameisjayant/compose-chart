package com.nameisjayant.compose_chart.features.line_charts.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun SimpleLineChart(
    modifier: Modifier = Modifier,
    color: Brush,
    data: List<Float>,
    showXYLine:Boolean = true,
    showLines :Boolean = true,
    showPoints:Boolean = true,
    verticalLineColor:Color = Color.Black,
    verticalLineStrokeWidth:Float =  Stroke.HairlineWidth,
    verticalLineGap:Int = 20
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val maxValue = data.maxOrNull() ?: 1f
        val xAxisDistance = size.width / (data.size - 1)
        val yAxisDistance = size.height / 2
        for (i in 0 until data.size - 1) {
            val y1 = size.height / 2 - (data[i] / maxValue) * yAxisDistance
            val y2 = size.height / 2 - (data[i + 1] / maxValue) * yAxisDistance
            val x1 = i * xAxisDistance
            val x2 = (i + 1) * xAxisDistance
            drawLine(
                brush = color,
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                strokeWidth = 5f
            )
            if(showPoints){
                drawCircle(
                    brush = color,
                    radius = 10f,
                    center = Offset(x1, y1)
                )
                // for the last point
                drawCircle(
                    brush = color,
                    radius = 10f,
                    center = Offset(x2, y2)
                )
            }
        }
        if(showXYLine){
            drawLine(
                brush = color,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = 0f, size.height / 2),
                strokeWidth = 10f
            )
            drawLine(
                brush = color,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = size.width, y = size.height / 2),
                strokeWidth = 10f
            )
        }
        if(showLines){
            verticalLine(verticalLineColor,verticalLineStrokeWidth,verticalLineGap)
        }
    }
}


@Composable
fun SimpleLineChart(
    modifier: Modifier = Modifier,
    color: Color,
    data: List<Float>,
    showXYLine:Boolean = true,
    showLines :Boolean = true,
    showPoints:Boolean = true,
    verticalLineColor:Color = color.copy(alpha = 0.5f),
    verticalLineStrokeWidth:Float =  Stroke.HairlineWidth,
    verticalLineGap:Int = 20
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val maxValue = data.maxOrNull() ?: 1f
        val xAxisDistance = size.width / (data.size - 1)
        val yAxisDistance = size.height / 2
        for (i in 0 until data.size - 1) {
            val y1 = size.height / 2 - (data[i] / maxValue) * yAxisDistance
            val y2 = size.height / 2 - (data[i + 1] / maxValue) * yAxisDistance
            val x1 = i * xAxisDistance
            val x2 = (i + 1) * xAxisDistance
            drawLine(
                color = color,
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                strokeWidth = 5f
            )
            if(showPoints){
                drawCircle(
                    color = color,
                    radius = 10f,
                    center = Offset(x1, y1)
                )
                // for the last point
                drawCircle(
                    color = color,
                    radius = 10f,
                    center = Offset(x2, y2)
                )
            }
        }
        if(showXYLine){
            drawLine(
                color = color,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = 0f, size.height / 2),
                strokeWidth = 10f
            )
            drawLine(
                color = color,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = size.width, y = size.height / 2),
                strokeWidth = 10f
            )
        }
        if(showLines){
            verticalLine(verticalLineColor,verticalLineStrokeWidth,verticalLineGap)
        }
    }
}

private fun DrawScope.verticalLine(
    color: Color = Color.Black,
    strokeWidth:Float = Stroke.HairlineWidth,
    lineGap:Int = 20
) {
    for (i in 0 until size.height.toInt() / 2 step lineGap) {
        val x1 = 0f
        val y1 = i.toFloat()
        val x2 = size.width
        val y2 = i.toFloat()

        drawLine(
            color = color,
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = strokeWidth
        )
    }
}