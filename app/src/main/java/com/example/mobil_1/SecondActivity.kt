// SecondActivity.kt
package com.example.mobil_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mobil_1.ui.theme.Mobil_1Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobil_1Theme {
                Text(text = "This is the second page!")
            }
        }
    }
}
@Composable
fun MyButton2(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("请狠狠地点我!")
    }
}