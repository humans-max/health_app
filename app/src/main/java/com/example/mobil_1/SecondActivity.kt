// SecondActivity.kt
package com.example.mobil_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.mobil_1.ui.theme.Mobil_1Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobil_1Theme {
                Text(text = "啊哈，这是第二个页面，你成功了!")
            }
        }
    }
}
