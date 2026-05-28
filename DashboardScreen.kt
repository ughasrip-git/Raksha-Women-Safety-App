package com.example.rakshaapplication

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase

@Composable
fun DashboardScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    // LANGUAGE DROPDOWN

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedLanguage by remember {
        mutableStateOf("English")
    }

    // MULTI LANGUAGE TEXTS

    val appText = when (selectedLanguage) {

        "தமிழ்" -> mapOf(
            "alert" to "அவசர எச்சரிக்கை",
            "hold" to "அழுத்தி பிடிக்கவும்",
            "info" to "உங்கள் சேமித்த தொடர்புகளுக்கு நேரடி இடத்துடன் அவசர SMS அனுப்பப்படும்.",
            "home" to "முகப்பு",
            "contacts" to "தொடர்புகள்",
            "location" to "இருப்பிடம்",
            "tips" to "பாதுகாப்பு",
            "settings" to "அமைப்புகள்"
        )

        "हिन्दी" -> mapOf(
            "alert" to "आपातकाल",
            "hold" to "दबाकर रखें",
            "info" to "आपके संपर्कों को लाइव लोकेशन के साथ SMS भेजा जाएगा।",
            "home" to "होम",
            "contacts" to "संपर्क",
            "location" to "स्थान",
            "tips" to "सुरक्षा",
            "settings" to "सेटिंग्स"
        )

        "తెలుగు" -> mapOf(
            "alert" to "అత్యవసర హెచ్చరిక",
            "hold" to "నొక్కి పట్టుకోండి",
            "info" to "మీ సేవ్ చేసిన కాంటాక్ట్స్‌కు లైవ్ లొకేషన్‌తో SOS SMS పంపబడుతుంది.",
            "home" to "హోమ్",
            "contacts" to "కాంటాక్ట్స్",
            "location" to "లొకేషన్",
            "tips" to "భద్రత",
            "settings" to "సెట్టింగ్స్"
        )

        "ಕನ್ನಡ" -> mapOf(
            "alert" to "ತುರ್ತು ಎಚ್ಚರಿಕೆ",
            "hold" to "ಒತ್ತಿ ಹಿಡಿಯಿರಿ",
            "info" to "ನಿಮ್ಮ ಉಳಿಸಿದ ಸಂಪರ್ಕಗಳಿಗೆ ಲೈವ್ ಸ್ಥಳದೊಂದಿಗೆ SOS SMS ಕಳುಹಿಸಲಾಗುತ್ತದೆ.",
            "home" to "ಮುಖಪುಟ",
            "contacts" to "ಸಂಪರ್ಕಗಳು",
            "location" to "ಸ್ಥಳ",
            "tips" to "ಭದ್ರತೆ",
            "settings" to "ಸೆಟ್ಟಿಂಗ್ಗಳು"
        )

        "മലയാളം" -> mapOf(
            "alert" to "അപകട മുന്നറിയിപ്പ്",
            "hold" to "അമർത്തി പിടിക്കുക",
            "info" to "നിങ്ങളുടെ സേവ് ചെയ്ത കോൺടാക്റ്റുകൾക്ക് ലൈവ് ലൊക്കേഷനോടെ SOS SMS അയക്കും.",
            "home" to "ഹോം",
            "contacts" to "കോൺടാക്റ്റുകൾ",
            "location" to "ലൊക്കേഷൻ",
            "tips" to "സുരക്ഷ",
            "settings" to "സെറ്റിംഗ്സ്"
        )

        "বাংলা" -> mapOf(
            "alert" to "জরুরি সতর্কতা",
            "hold" to "চেপে ধরে রাখুন",
            "info" to "আপনার সেভ করা কন্টাক্টে লাইভ লোকেশন সহ SOS SMS পাঠানো হবে।",
            "home" to "হোম",
            "contacts" to "কন্টাক্টস",
            "location" to "লোকেশন",
            "tips" to "নিরাপত্তা",
            "settings" to "সেটিংস"
        )

        "मराठी" -> mapOf(
            "alert" to "आपत्कालीन इशारा",
            "hold" to "दाबून ठेवा",
            "info" to "तुमच्या सेव्ह केलेल्या संपर्कांना लाईव्ह लोकेशनसह SOS SMS पाठवला जाईल.",
            "home" to "मुख्यपृष्ठ",
            "contacts" to "संपर्क",
            "location" to "स्थान",
            "tips" to "सुरक्षा",
            "settings" to "सेटिंग्ज"
        )

        else -> mapOf(
            "alert" to "SOS",
            "hold" to "HOLD TO ALERT",
            "info" to "Long press SOS to send emergency SMS with live location to your saved contacts.",
            "home" to "Home",
            "contacts" to "Contacts",
            "location" to "Location",
            "tips" to "Tips",
            "settings" to "Settings"
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween,
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                // APP NAME

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Shield,
                        contentDescription = null,
                        tint = Color.Red
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "RAKSHA",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // LANGUAGE MENU

                Box {

                    Surface(
                        color = Color(0xFF13315C),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.pointerInput(Unit) {

                            detectTapGestures(
                                onTap = {
                                    expanded = true
                                }
                            )
                        }
                    ) {

                        Row(
                            modifier = Modifier.padding(
                                horizontal = 14.dp,
                                vertical = 8.dp
                            ),

                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector =
                                    Icons.Default.Language,

                                contentDescription = null,
                                tint = Color.White
                            )

                            Spacer(
                                modifier = Modifier.width(6.dp)
                            )

                            Text(
                                text = selectedLanguage,
                                color = Color.White
                            )

                            Spacer(
                                modifier = Modifier.width(4.dp)
                            )

                            Icon(
                                imageVector =
                                    Icons.Default.ArrowDropDown,

                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = expanded,

                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        val languages = listOf(
                            "English",
                            "தமிழ்",
                            "हिन्दी",
                            "తెలుగు",
                            "ಕನ್ನಡ",
                            "മലയാളം",
                            "বাংলা",
                            "मराठी"
                        )

                        languages.forEach { language ->

                            DropdownMenuItem(

                                text = {
                                    Text(language)
                                },

                                onClick = {

                                    selectedLanguage =
                                        language

                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // STATUS CARD

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0D3B2E)
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Wifi,
                        contentDescription = null,
                        tint = Color.Green
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text =
                            "Connected — Full emergency services available",

                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            // SOS BUTTON

            Box(
                modifier = Modifier
                    .size(260.dp)
                    .align(Alignment.CenterHorizontally)
                    .shadow(
                        elevation = 30.dp,
                        shape = CircleShape
                    )
                    .background(
                        Color.Red,
                        CircleShape
                    )

                    .pointerInput(Unit) {

                        detectTapGestures(

                            onLongPress = {

                                val database =
                                    FirebaseDatabase.getInstance()

                                val contactsRef =
                                    database.getReference("contacts")

                                contactsRef.get()
                                    .addOnSuccessListener { snapshot ->

                                        val contacts =
                                            mutableListOf<String>()

                                        for (data in snapshot.children) {

                                            val contact =
                                                data.getValue(
                                                    ContactModel::class.java
                                                )

                                            if (contact != null) {

                                                contact.phone?.let {

                                                    contacts.add(it)
                                                }
                                            }
                                        }

                                        SOSManager.sendSOS(
                                            context,
                                            contacts
                                        )

                                        EmergencyEffects.startSiren(
                                            context
                                        )

                                        EmergencyEffects.vibrate(
                                            context
                                        )

                                        if (
                                            Build.VERSION.SDK_INT >=
                                            Build.VERSION_CODES.M
                                        ) {

                                            EmergencyEffects
                                                .startFlashlight(
                                                    context
                                                )
                                        }
                                    }
                            }
                        )
                    },

                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text = appText["alert"] ?: "",
                        color = Color.White,
                        fontSize = 54.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = appText["hold"] ?: "",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = appText["info"] ?: "",

                color = Color.White,
                fontSize = 18.sp,
                lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            // BOTTOM NAVIGATION

            NavigationBar(
                containerColor = Color(0xFF102A43)
            ) {

                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(appText["home"] ?: "")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("contacts")
                    },
                    icon = {
                        Icon(
                            Icons.Default.People,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(appText["contacts"] ?: "")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("location")
                    },
                    icon = {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(appText["location"] ?: "")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("tips")
                    },
                    icon = {
                        Icon(
                            Icons.Default.Security,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(appText["tips"] ?: "")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("settings")
                    },
                    icon = {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(appText["settings"] ?: "")
                    }
                )
            }
        }
    }
}