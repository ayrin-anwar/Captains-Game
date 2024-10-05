package com.example.captainsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captainsgame.ui.theme.CaptainsGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainsGameTheme {
                CaptainGame()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaptainsGameTheme {
        Greeting("Android")
    }
}

@Composable
fun CaptainGame() {
    val treasureFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("north") }
    val stormOrDisaster = remember { mutableStateOf("") }
    Column {
        Spacer(Modifier.height(64.dp))
        Text(text = "Treasure Found :{${treasureFound.value}}")
        Spacer(Modifier.height(16.dp))
        Text(text ="Direction found: {${direction.value}}")
        Spacer(Modifier.height(16.dp))
        Text(text ="Storm or Disasaterr: {${stormOrDisaster.value}}")
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            direction.value = "East"
            if(Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrDisaster.value = "We found a treasure"
            } else {
                stormOrDisaster.value = "The" +
                        "re is a storm"
            }
        }) {
            Text("Sail East")

        }
        Button(onClick = {
            direction.value = "West"
            if(Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrDisaster.value = "We found a treasure"
            } else {
                stormOrDisaster.value = "There is a storm"
            }
        }) {
            Text("Sail West")

        }
        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrDisaster.value = "We found a treasure"
            } else {
                stormOrDisaster.value = "There is a storm"
            }
        }) {
            Text("Sail North")

        }
        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()) {
                treasureFound.value += 1
                stormOrDisaster.value = "We found a treasure"
            } else {
                stormOrDisaster.value = "There is a storm"
            }
        }) {
            Text("Sail South")

        }
    }
}