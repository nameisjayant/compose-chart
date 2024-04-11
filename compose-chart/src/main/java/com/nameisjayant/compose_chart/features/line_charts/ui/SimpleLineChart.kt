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
    showXYLine: Boolean = true,
    showLines: Boolean = true,
    showPoints: Boolean = true,
    verticalLineStrokeWidth: Float = Stroke.HairlineWidth,
    verticalLineGap: Int = 20
) {
    SimpleLineChartRow(
        data = data,
        modifier = modifier,
        brush = color,
        showXYLine = showXYLine,
        showLines = showLines,
        showPoints = showPoints,
        verticalLineGap = verticalLineGap,
        verticalLineStrokeWidth = verticalLineStrokeWidth
    )
}

@Composable
fun SimpleLineChart(
    modifier: Modifier = Modifier,
    color: Color,
    data: List<Float>,
    showXYLine: Boolean = true,
    showLines: Boolean = true,
    showPoints: Boolean = true,
    verticalLineStrokeWidth: Float = Stroke.HairlineWidth,
    verticalLineGap: Int = 20
) {
    SimpleLineChartRow(
        data = data,
        modifier = modifier,
        color = color,
        showXYLine = showXYLine,
        showLines = showLines,
        showPoints = showPoints,
        verticalLineGap = verticalLineGap,
        verticalLineStrokeWidth = verticalLineStrokeWidth
    )
}

@Composable
private fun SimpleLineChartRow(
    modifier: Modifier = Modifier,
    color: Color? = null,
    brush: Brush? = null,
    data: List<Float>,
    showXYLine: Boolean = true,
    showLines: Boolean = true,
    showPoints: Boolean = true,
    verticalLineStrokeWidth: Float = Stroke.HairlineWidth,
    verticalLineGap: Int = 20
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
            color?.let {
                drawLine(
                    color = it,
                    start = Offset(x = x1, y = y1),
                    end = Offset(x = x2, y = y2),
                    strokeWidth = 5f
                )
            }
            brush?.let {
                drawLine(
                    brush = it,
                    start = Offset(x = x1, y = y1),
                    end = Offset(x = x2, y = y2),
                    strokeWidth = 5f
                )
            }

            if (showPoints) {
                color?.let {
                    drawCircle(
                        color = it,
                        radius = 10f,
                        center = Offset(x1, y1)
                    )
                    // for the last point
                    drawCircle(
                        color = it,
                        radius = 10f,
                        center = Offset(x2, y2)
                    )
                }
                brush?.let {
                    drawCircle(
                        brush = it,
                        radius = 10f,
                        center = Offset(x1, y1)
                    )
                    // for the last point
                    drawCircle(
                        brush = it,
                        radius = 10f,
                        center = Offset(x2, y2)
                    )
                }
            }
        }
        if (showXYLine) {
            color?.let {
                drawLine(
                    color = it,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = 0f, size.height / 2),
                    strokeWidth = 10f
                )
                drawLine(
                    color = it,
                    start = Offset(x = 0f, y = size.height / 2),
                    end = Offset(x = size.width, y = size.height / 2),
                    strokeWidth = 10f
                )
            }
            brush?.let {
                drawLine(
                    brush = it,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = 0f, size.height / 2),
                    strokeWidth = 10f
                )
                drawLine(
                    brush = it,
                    start = Offset(x = 0f, y = size.height / 2),
                    end = Offset(x = size.width, y = size.height / 2),
                    strokeWidth = 10f
                )
            }
        }
        if (showLines) {
            color?.let {
                verticalLine(
                    color = color,
                    strokeWidth = verticalLineStrokeWidth,
                    lineGap = verticalLineGap
                )
            }
            brush?.let {
                verticalLine(
                    brush = it,
                    strokeWidth = verticalLineStrokeWidth,
                    lineGap = verticalLineGap
                )
            }
        }
    }
}

private fun DrawScope.verticalLine(
    color: Color? = null,
    brush: Brush? = null,
    strokeWidth: Float = Stroke.HairlineWidth,
    lineGap: Int = 20
) {
    for (i in 0 until size.height.toInt() / 2 step lineGap) {
        val x1 = 0f
        val y1 = i.toFloat()
        val x2 = size.width
        val y2 = i.toFloat()

        color?.let {
            drawLine(
                color = it,
                start = Offset(x1, y1),
                end = Offset(x2, y2),
                strokeWidth = strokeWidth
            )
        }
        brush?.let {
            drawLine(
                brush = it,
                start = Offset(x1, y1),
                end = Offset(x2, y2),
                strokeWidth = strokeWidth
            )
        }
    }
}