package com.example.artexpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.ui.text.font.FontWeight
import com.example.artexpo.ui.theme.ArtExpoTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Text
import android.R.attr.label
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtExpoTheme {
                Art()
            }
        }
    }
}

@Composable
fun Art() {
    var num by remember { mutableStateOf(1) }

    val pic = when (num) {
        1 -> R.drawable.monalesa
        2 -> R.drawable.motherteresa
        3-> R.drawable.download
        4 ->R.drawable.images
        else -> R.drawable.monalesa
    }
    val text = when (num) {
        1 -> R.string.mona
        2 -> R.string.tere
        3 -> R.string.flo
        4 ->R.string.fah
        else -> R.string.mona
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Surface(
                modifier = Modifier
                    .size(400.dp)
                    .padding(vertical = 16.dp),
                shadowElevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ){
                Image(
                    painter = painterResource(pic),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }


        Text(
            text = stringResource(text),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.size(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if(num>1) {
                Button(
                    onClick = {
                        if (num > 1) {
                            num--
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.size(120.dp, 50.dp)
                ) {
                    Text("Previous")
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            if(num<4) {
                Button(
                    onClick = {
                        if (num < 4) {
                            num++
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.size(120.dp, 50.dp)
                ) {
                    Text("Next")
                }
            }
        }
    }
}
