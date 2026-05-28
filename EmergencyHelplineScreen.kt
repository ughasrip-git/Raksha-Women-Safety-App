package com.example.rakshaapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HelplineScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF061534),
                        Color(0xFF0A1F44)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Emergency Helpline",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Police Card
            HelplineCard(
                title = "Police",
                number = "100"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Ambulance Card
            HelplineCard(
                title = "Ambulance",
                number = "108"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Women Helpline
            HelplineCard(
                title = "Women Helpline",
                number = "1091"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Emergency SOS
            HelplineCard(
                title = "Emergency",
                number = "112"
            )
        }
    }
}

@Composable
fun HelplineCard(
    title: String,
    number: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF142850)
        ),

        shape = RoundedCornerShape(20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = number,
                    color = Color.Green,
                    fontSize = 20.sp
                )
            }

            IconButton(onClick = {

                // later direct call functionality add pannalam

            }) {

                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = Color.Red,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }
}