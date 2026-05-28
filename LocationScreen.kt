package com.example.rakshaapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LocationScreen(
    navController: NavHostController
) {

    var latitude by remember {
        mutableStateOf("12.9716")
    }

    var longitude by remember {
        mutableStateOf("77.5946")
    }

    // LANGUAGE

    val selectedLanguage =
        LanguageManager.selectedLanguage

    // TRANSLATIONS

    val appText = when (selectedLanguage) {

        // TAMIL

        "தமிழ்" -> mapOf(

            "title" to "நேரடி இருப்பிடம்",
            "coordinates" to "தற்போதைய இருப்பிட விவரங்கள்",
            "latitude" to "அட்சரேகை",
            "longitude" to "தீர்க்கரேகை",
            "mapLink" to "கூகுள் மேப்ஸ் இணைப்பு",
            "refresh" to "இருப்பிடத்தை புதுப்பிக்கவும்"
        )

        // HINDI

        "हिन्दी" -> mapOf(

            "title" to "लाइव लोकेशन",
            "coordinates" to "वर्तमान निर्देशांक",
            "latitude" to "अक्षांश",
            "longitude" to "देशांतर",
            "mapLink" to "गूगल मैप्स लिंक",
            "refresh" to "लोकेशन रिफ्रेश करें"
        )

        // TELUGU

        "తెలుగు" -> mapOf(

            "title" to "లైవ్ లొకేషన్",
            "coordinates" to "ప్రస్తుత కోఆర్డినేట్లు",
            "latitude" to "అక్షాంశం",
            "longitude" to "రేఖాంశం",
            "mapLink" to "గూగుల్ మ్యాప్స్ లింక్",
            "refresh" to "లొకేషన్ రిఫ్రెష్"
        )

        // KANNADA

        "ಕನ್ನಡ" -> mapOf(

            "title" to "ಲೈವ್ ಸ್ಥಳ",
            "coordinates" to "ಪ್ರಸ್ತುತ ಸ್ಥಳ ವಿವರಗಳು",
            "latitude" to "ಅಕ್ಷಾಂಶ",
            "longitude" to "ರೇಖಾಂಶ",
            "mapLink" to "ಗೂಗಲ್ ಮ್ಯಾಪ್ಸ್ ಲಿಂಕ್",
            "refresh" to "ಸ್ಥಳ ರಿಫ್ರೆಶ್ ಮಾಡಿ"
        )

        // MALAYALAM

        "മലയാളം" -> mapOf(

            "title" to "ലൈവ് ലൊക്കേഷൻ",
            "coordinates" to "നിലവിലെ ലൊക്കേഷൻ വിവരങ്ങൾ",
            "latitude" to "അക്ഷാംശം",
            "longitude" to "രേഖാംശം",
            "mapLink" to "ഗൂഗിൾ മാപ്സ് ലിങ്ക്",
            "refresh" to "ലൊക്കേഷൻ റിഫ്രെഷ് ചെയ്യുക"
        )

        // BENGALI

        "বাংলা" -> mapOf(

            "title" to "লাইভ লোকেশন",
            "coordinates" to "বর্তমান অবস্থান তথ্য",
            "latitude" to "অক্ষাংশ",
            "longitude" to "দ্রাঘিমাংশ",
            "mapLink" to "গুগল ম্যাপস লিংক",
            "refresh" to "লোকেশন রিফ্রেশ করুন"
        )

        // MARATHI

        "मराठी" -> mapOf(

            "title" to "लाईव्ह लोकेशन",
            "coordinates" to "सध्याचे स्थान तपशील",
            "latitude" to "अक्षांश",
            "longitude" to "रेखांश",
            "mapLink" to "गुगल मॅप्स लिंक",
            "refresh" to "लोकेशन रिफ्रेश करा"
        )

        // ENGLISH

        else -> mapOf(

            "title" to "Live Location",
            "coordinates" to "Current Coordinates",
            "latitude" to "Latitude",
            "longitude" to "Longitude",
            "mapLink" to "Google Maps Link",
            "refresh" to "Refresh Location"
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF06142E),
                        Color(0xFF081F4D)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // TOP BAR

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = appText["title"] ?: "",

                    color = Color.White,

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // LOCATION CARD

            Card(
                modifier = Modifier.fillMaxWidth(),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF142850)
                ),

                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text =
                            appText["coordinates"] ?: "",

                        color = Color.White,

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text =
                            appText["latitude"] ?: "",

                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = latitude,

                        color = Color.Green,

                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text =
                            appText["longitude"] ?: "",

                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = longitude,

                        color = Color.Green,

                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // MAP LINK CARD

            Card(
                modifier = Modifier.fillMaxWidth(),

                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF142850)
                ),

                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text =
                            appText["mapLink"] ?: "",

                        color = Color.White,

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text =
                            "https://maps.google.com/?q=$latitude,$longitude",

                        color = Color.Cyan,

                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // REFRESH BUTTON

            Button(
                onClick = {

                    // later real GPS fetch pannalam

                },

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),

                shape = RoundedCornerShape(16.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text =
                        appText["refresh"] ?: ""
                )
            }
        }
    }
}