// HeartBitActivity.kt
package com.example.mobil_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobil_1.ui.theme.Mobil_1Theme

class HeartBitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobil_1Theme {
                HeartBitScreen()
            }
        }
    }
}

@Composable
fun HeartBitScreen() {
    // 模拟一些数据
    val heartRate = 75 // 心率
    val oxygenLevel = 98 // 血氧饱和度

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Heart Rate: $heartRate bpm", modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Blood Oxygen Level: $oxygenLevel%", modifier = Modifier.padding(bottom = 16.dp))
        // 可以在这里加入更多的健康数据，例如：血压、体温等
    }
}
