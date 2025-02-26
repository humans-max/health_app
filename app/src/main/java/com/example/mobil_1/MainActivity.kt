package com.example.mobil_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobil_1.ui.theme.Mobil_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobil_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,  // 这里是正确的拼写
                        horizontalAlignment = Alignment.CenterHorizontally  // 这里是正确的拼写
                    ) {
                        Greeting(name = "YGH")
                        Spacer(modifier = Modifier.height(16.dp)) // 使用 Spacer 和 height 作为间距
                        MyButton(onClick={navigateToSecondActivity()})
                    }
                }
            }
        }
    }
    private fun navigateToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "good $name!",
        modifier = modifier
    )
}

@Composable
fun MyButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("请狠狠地点我!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobil_1Theme {
        Greeting("Android")
    }
}
