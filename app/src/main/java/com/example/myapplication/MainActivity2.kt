package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.myapplication.databinding.FragmentBlank2Binding
import com.example.myapplication.databinding.FragmentBlank3Binding
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.databinding.FragmentItemBinding
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate")
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        onClick = ::onClick,
                        onClick2 = ::startNeverGonnaGiveYouUp,
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    fun onClick() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun startNeverGonnaGiveYouUp() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
        startActivity(intent)
    }

}

@Composable
fun Greeting2(name: String, onClick: () -> Unit, onClick2: () -> Unit, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = onClick) {
            Text("Go to first activity")
        }
        Button(onClick = onClick2) {
            Text("Get rick rolled")
        }
        AndroidViewBinding(FragmentBlank2Binding::inflate)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        Column {
            Greeting("Android2", {})
        }
    }
}