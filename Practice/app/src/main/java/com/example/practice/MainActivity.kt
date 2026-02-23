package com.example.practice

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                    GreetingForm(
                        heading= stringResource(R.string.Heading),
                        para1= stringResource(R.string.para1),
                        para2= stringResource(R.string.para2),
                    )
                }
            }
        }
    }


@Composable
fun GreetingForm(heading: String, para1: String, para2:String, modifier: Modifier = Modifier) {
    val image= painterResource(R.drawable.bg_compose_background)
    Column (modifier = modifier){
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text= heading,
            fontSize=24.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text=para1,
            textAlign= TextAlign.Justify,
            modifier= Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .align(alignment = Alignment.CenterHorizontally)

        )
        Text(
            text=para2,
            textAlign= TextAlign.Justify,
            modifier= Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}


