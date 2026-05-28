package com.example.rakshaapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {

    val auth = FirebaseAuth.getInstance()

    LaunchedEffect(Unit) {

        delay(2500)

        if (auth.currentUser != null) {

            navController.navigate("dashboard") {

                popUpTo("splash") {
                    inclusive = true
                }
            }

        } else {

            navController.navigate("login") {

                popUpTo("splash") {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF020B1F),
                        Color(0xFF06142E),
                        Color.Black
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            // LOGO

            Image(
                painter = painterResource(
                    id = R.drawable.raksha_logo
                ),

                contentDescription = null,

                modifier = Modifier
                    .size(220.dp)
                    .clip(CircleShape),

                contentScale =
                    ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // APP NAME

            Text(
                text = "RAKSHA",

                color = Color(0xFFFF3B3B),

                fontSize = 38.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // TAGLINE

            Text(
                text = "Stay Safe, Stay Strong",

                color = Color.White.copy(
                    alpha = 0.85f
                ),

                fontSize = 18.sp
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            // LOADER

            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 4.dp
            )
        }
    }
}