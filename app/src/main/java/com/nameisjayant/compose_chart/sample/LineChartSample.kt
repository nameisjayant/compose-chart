package com.nameisjayant.compose_chart.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose_chart.features.line_charts.ui.SimpleLineChart


@Composable
fun LineChartSample() {
   Box(
       modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
       contentAlignment = Alignment.Center
   ) {
       SimpleLineChart(
           color = Color.Black,
           data = listOf(5f, 2f, 3f, 2f, 0f, 7f),
           modifier = Modifier.fillMaxWidth().height(400.dp)
       )
   }
}