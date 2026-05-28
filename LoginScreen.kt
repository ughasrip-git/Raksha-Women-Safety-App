package com.example.rakshaapplication

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val auth = FirebaseAuth.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E293B),
                        Color(0xFF111827)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "RAKSHA",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Women Safety Login",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text("Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    if (email.trim().isEmpty() || password.trim().isEmpty()) {

                        Toast.makeText(
                            context,
                            "Enter Email & Password",
                            Toast.LENGTH_SHORT
                        ).show()

                        return@Button
                    }
                    auth.signInWithEmailAndPassword(
                        email.trim(),
                        password.trim()
                    )
                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Login Success",
                                Toast.LENGTH_SHORT
                            ).show()

                            navController.navigate("dashboard")
                        }

                        .addOnFailureListener { e ->

                            Toast.makeText(
                                context,
                                "Login Failed: ${e.message}",
                                Toast.LENGTH_LONG
                            ).show()

                            e.printStackTrace()
                        }

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),

                shape = RoundedCornerShape(14.dp)
            ) {

                Text(
                    text = "LOGIN",
                    fontSize = 18.sp
                )
            }
        }
    }
}