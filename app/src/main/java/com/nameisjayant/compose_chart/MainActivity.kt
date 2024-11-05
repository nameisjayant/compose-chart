package com.nameisjayant.compose_chart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.nameisjayant.compose_chart.sample.LineChartSample
import com.nameisjayant.compose_chart.ui.theme.ComposeChartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChartTheme {
                LineChartSample()
            }
        }
    }
}