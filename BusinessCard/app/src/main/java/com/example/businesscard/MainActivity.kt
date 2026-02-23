package com.example.businesscard

import android.R.attr.text
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {

                    Greeting(
                        number=getString(R.string.number),
                        mail=getString(R.string.mail),
                        share=getString(R.string.share),
                        name=getString(R.string.name),
                        title=getString(R.string.title),

                    )
                }
            }
        }
    }


@Composable
fun Greeting(number: String,mail: String, share: String,name: String,title: String, modifier: Modifier = Modifier) {
  Column(modifier = modifier
      .background(Color.Black)
      .fillMaxSize(),
      horizontalAlignment= Alignment.CenterHorizontally,
      verticalArrangement= Arrangement.Center

  ){
      val image= painterResource(R.drawable.android_logo)
      Image(
          painter=image,
          contentDescription=null,
      )
      Text(
          text=name,
          fontWeight = Bold,
          fontSize=40.sp,
          color=Color.White,
          modifier=Modifier
      )
      Text(
          text=title,
          fontWeight = Bold,
          fontSize=20.sp,
          color=Color.White,
      )
      Spacer(modifier= Modifier.padding(90.dp))
      Column {
          Row() {
              Icon(
                  imageVector = Icons.Rounded.Call,
                  contentDescription = "Call",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.padding(5.dp))
              Text(
                  text = number,
                  color = Color.White,
              )
          }
          Spacer(modifier= Modifier.padding(2.dp))
          Row {
              Icon(
                  imageVector = Icons.Rounded.Share,
                  contentDescription = "Share",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.padding(5.dp))
              Text(
                  text = mail,
                  color = Color.White,
              )
          }
          Spacer(modifier= Modifier.padding(2.dp))
          Row {
              Icon(
                  imageVector = Icons.Rounded.Email,
                  contentDescription = "Email",
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.padding(5.dp))
              Text(
                  text = share,
                  color = Color.White,
              )
          }
      }

  }
}

