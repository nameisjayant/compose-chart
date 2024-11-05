package com.nameisjayant.compose_chart.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose_chart.features.line_charts.ui.SimpleLineChart


@Composable
fun LineChartSample() {
   Box(
       modifier = Modifier
           .padding(horizontal = 10.dp)
           .fillMaxSize(),
       contentAlignment = Alignment.Center
   ) {
       SimpleLineChart(
           color = Brush.linearGradient(listOf(
               Color.Black, Color.Red, Color.Green
           )),
           data = listOf(
               5f,
               2f,
               3f,
               2f,
               0f,
               7f,
               10f,
               12f,
               8f,
               2f,
               3f,
               10f,
               5f,
               7f,
               6f,
               4f,
               12f,
               11f,
               15f
           ),
           modifier = Modifier
               .fillMaxWidth()
               .height(400.dp),
           verticalLineGap = 80
       )
   }
}