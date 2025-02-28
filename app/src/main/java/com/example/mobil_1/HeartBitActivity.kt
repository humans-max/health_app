package com.example.mobil_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
    // 模拟动态数据
    var heartRate by remember { mutableStateOf(75) } // 心率
    var oxygenLevel by remember { mutableStateOf(98) } // 血氧饱和度
    var isLoading by remember { mutableStateOf(false) } // 加载状态

    // 使用 LaunchedEffect 来启动协程
    val coroutineScope = rememberCoroutineScope()

    // 更新数据
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 如果正在加载数据，显示进度条
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(bottom = 16.dp))
        } else {
            // 显示心率和血氧数据
            Text(text = "Heart Rate: $heartRate bpm", modifier = Modifier.padding(bottom = 16.dp))
            CircularProgressIndicator(
                progress = heartRate / 100f,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                color = Color.Red
            )

            Text(text = "Blood Oxygen Level: $oxygenLevel%", modifier = Modifier.padding(bottom = 16.dp))
            CircularProgressIndicator(
                progress = oxygenLevel / 100f,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                color = Color.Green
            )
        }

        // 更新数据按钮
        Button(onClick = {
            isLoading = true
            // 使用 rememberCoroutineScope 启动协程
            coroutineScope.launch {
                // 模拟2秒延迟
                kotlinx.coroutines.delay(2000)
                heartRate = (60..100).random()  // 随机更新心率
                oxygenLevel = (90..100).random()  // 随机更新血氧
                isLoading = false
            }
        }) {
            Text("Update Data")
        }
    }
}
