package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {

                    Greeting(
                        a=stringResource(R.string.text_title),
                        b=stringResource(R.string.text_description),
                        c=stringResource(R.string.image_title),
                        d=stringResource(R.string.image_description),
                        e=stringResource(R.string.row_title),
                        f=stringResource(R.string.row_description),
                        g=stringResource(R.string.column_title),
                        h=stringResource(R.string.column_description)
                    )
                }
            }
        }
    }


@Composable
fun Greeting(a: String, b: String, c: String, d: String, e: String, f: String, g: String, h: String, modifier: Modifier = Modifier) {

    Column(modifier= modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = modifier
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = a,
                        fontWeight = Bold,

                        color = Color.Black,
                        modifier = Modifier
                            .padding(bottom = 16.dp)

                    )
                    Text(
                        text = b,
                        color = Color.Black,
                        textAlign = TextAlign.Justify,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = modifier
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = c,
                        fontWeight = Bold,
                        modifier = Modifier
                            .padding(bottom = 16.dp),
                        color = Color.Black
                    )
                    Text(
                        text = d,
                        color = Color.Black,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(0xFFD0BCFF))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = modifier
                            .align(Alignment.Center)
                    ) {
                        Text(
                            text = e,
                            fontWeight = Bold,
                            modifier = Modifier.padding(bottom = 16.dp),
                            color = Color.Black
                        )
                        Text(
                            text = f,
                            color = Color.Black,
                            textAlign = TextAlign.Justify,
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(color = Color(0xFFEADDFF))
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {

                    Column(
                        modifier = modifier
                            .align(Alignment.Center)
                    ) {
                        Text(
                            text = g,
                            fontWeight = Bold,
                            modifier = Modifier.padding(bottom = 16.dp),
                            color = Color.Black
                        )
                        Text(
                            text = h,
                            color = Color.Black,
                            textAlign = TextAlign.Justify,
                        )
                    }
                }
            }
        }
    }



