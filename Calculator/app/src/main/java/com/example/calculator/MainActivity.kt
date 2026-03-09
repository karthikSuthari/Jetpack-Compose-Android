package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme
import kotlin.math.roundToInt
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorApp()
                }
            }
        }
    }
@Preview
@Composable
fun CalculatorApp() {
    var display by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.weight(1f))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp)
        ){
            Text(
                text = display,
                fontSize = 40.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(onClick ={display = ""},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "AC",
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(onClick ={
                        if(display.isNotEmpty()){
                            display = display.dropLast(1)
                        }
                    },
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(onClick ={
                        if (display.isNotEmpty()) {
                            val value = display.toDoubleOrNull()
                            if (value != null) {
                                display = value.roundToInt().toString()
                            }
                        }
                    },
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh",
                            tint = Color.Black,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(onClick ={display += "/"},
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        ),
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "/",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                }
                Row(
                      horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(onClick ={display += "7"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "7",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "8"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "8",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "9"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "9",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "x"},
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        ),
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "x",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(onClick ={display += "4"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "4",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "5"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "5",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "6"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "6",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "-"},
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        ),
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "-",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Button(onClick ={display += "1"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "1",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "2"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "2",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "3"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "3",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "+"},
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        ),
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "+",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Button(onClick ={display += "%"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "%",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "0"},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "0",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={display += "."},
                        shape = CircleShape,
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = ".",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                    Button(onClick ={
                        display = calculate(display)
                    },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        ),
                        modifier = Modifier
                            .size(60.dp),
                        contentPadding = PaddingValues(0.dp)
                    ){
                        Text(
                            text = "=",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }

}


fun calculate(expression: String): String {
    return try {
        val operators = listOf("+", "-", "x", "/")
        var operator = ""

        for (op in operators) {
            if (expression.contains(op)) {
                operator = op
                break
            }
        }

        val parts = expression.split(operator)

        val a = parts[0].toDouble()
        val b = parts[1].toDouble()

        val result = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "x" -> a * b
            "/" -> a / b
            else -> 0.0
        }

        if (result % 1 == 0.0) result.toInt().toString()
        else result.toString()

    } catch (e: Exception) {
        "Error"
    }
}



