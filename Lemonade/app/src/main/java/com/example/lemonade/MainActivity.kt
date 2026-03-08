package com.example.lemonade

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}
@Preview
@Composable
fun LemonadeApp(){
    Column(){
        Box(modifier =  Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .size(130.dp)
        ){
            Column(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 5.dp)
            ){
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp
                )
            }

        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Operation()
    }
}
@Composable
fun Operation(){

        var result by remember{mutableStateOf(1)}
    var squeeze by remember{mutableStateOf((4..10).random())}
        when(result){
            1-> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                result = 2
                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.lemon_tree),
                        fontSize = 18.sp
                    )

                }
            }
            2-> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier.wrapContentSize()
                            .clickable{
                             squeeze--
                            if(squeeze==0){
                                result=3
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.lemon),
                        fontSize = 18.sp
                    )
                }

            }
            3->{
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.glass_of_lemonade),
                        modifier = Modifier.wrapContentSize() .clickable {
                            result = 4
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.glass_of_lemonade),
                        fontSize = 18.sp
                    )
                }

            }
            4->{
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass),
                        modifier = Modifier.wrapContentSize() .clickable {
                            result=1
                            squeeze = (4..10).random()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.empty_glass),
                        fontSize = 18.sp
                    )
                }
            }

        }
    }
