package com.example.calendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import com.example.calendar.ui.theme.CalendarTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import java.time.YearMonth
import java.time.LocalDate
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalendarTheme {
                CalendarApp()
            }
        }
    }
}

@Composable
fun CalendarApp(){
    val days = listOf("Sun","Mon","Tue","Wed","Thu","Fri","Sat")
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    val yearint = year.toIntOrNull()
    val monthint = month.toIntOrNull()
    val daysInMonth =
        if (yearint != null && monthint != null) {
            YearMonth.of(yearint, monthint).lengthOfMonth()
        } else 0

    val startDay =
        if (yearint != null && monthint != null) {
            LocalDate.of(yearint, monthint, 1).dayOfWeek.value % 7
        } else 0
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(Modifier.height(90.dp))
        Text("Calendar",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (day in days) {
                Text(day)
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(7)
        ) {
            items(42) { index ->
                val date = index - startDay + 1
                Button(onClick = {},
                    contentPadding = PaddingValues(0.dp)

                ) {
                    if ( date in 1..daysInMonth) {
                        Text("$date",
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        Text("")
                    }
                }
            }
        }
        TextField(
            value = year,
            onValueChange = { newValue ->
                if(newValue.length <= 4 && newValue.all {it.isDigit()}){
                    year = newValue
                }
            },
            label = {Text("Enter Year",
                textAlign = TextAlign.End,
            )},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        TextField(
            value = month,
            onValueChange = { newValue ->
                if(newValue.length <= 2 && newValue.all {it.isDigit()}){
                    month = newValue
                }
            },
            label = {Text("Enter Month",
                textAlign = TextAlign.End,
                )},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))




    }
}