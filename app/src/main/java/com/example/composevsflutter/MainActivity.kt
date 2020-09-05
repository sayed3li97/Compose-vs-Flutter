package com.example.composevsflutter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.layout.RowScope.gravity
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {

    val mainColor = Color(0xFFADD8E6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        Scaffold(
                topAppBar = { topAppBar() }
        ) {
            Column (
                    modifier = Modifier.fillMaxHeight()
            ) {
                topImage()
                body()
            }
        }
    }

    @Composable
    fun topAppBar() {
        TopAppBar(
                title = {
                    Text(
                            text = "Flutter VS Compose",
                            style = TextStyle(
                                    textAlign = TextAlign.Center
                            )
                    )
                },
                backgroundColor = mainColor
        )
    }

    @Composable
    fun topImage() {
        val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
        Image(
                imageResource(id = R.drawable.vs),
                modifier = imageModifier
        )
    }

    @Composable
    fun body() {
        var counter: MutableState<Int> = state { 0 }
        Text("Hello World!")
        Text("This is a second line")
        Row(modifier = Modifier.gravity(Alignment.CenterHorizontally)){
            Text(
                    text = "Your count is ${counter.value}",

                    style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = TextUnit.Companion.Sp(30)
                    )
            )
        }
        Button(
                modifier = Modifier.gravity(Alignment.CenterVertically).padding(top = 100.dp),
                onClick = { counter.value += 5 },
                backgroundColor = mainColor) {
            Text("Add 5 to your count", color = Color.White, style = TextStyle(fontSize = TextUnit.Sp(20)))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        mainPage()
    }
}