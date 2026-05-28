package com.example.rakshaapplication

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun SettingsScreen(
    navController: NavHostController
) {

    val context = navController.context

    val sharedPreferences =
        context.getSharedPreferences(
            "RAKSHA_SETTINGS",
            Context.MODE_PRIVATE
        )

    // SETTINGS STATES

    var shakeDetection by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "shakeDetection",
                false
            )
        )
    }

    var sirenEnabled by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "sirenEnabled",
                true
            )
        )
    }

    var flashlightEnabled by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "flashlightEnabled",
                true
            )
        )
    }

    var vibrationEnabled by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "vibrationEnabled",
                true
            )
        )
    }

    var autoLogin by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "autoLogin",
                true
            )
        )
    }

    var darkMode by remember {
        mutableStateOf(
            sharedPreferences.getBoolean(
                "darkMode",
                false
            )
        )
    }

    var selectedCountdown by remember {
        mutableStateOf(
            sharedPreferences.getString(
                "countdown",
                "5 Seconds"
            ) ?: "5 Seconds"
        )
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // LANGUAGE

    val selectedLanguage =
        LanguageManager.selectedLanguage

    val appText = when (selectedLanguage) {

        // TAMIL

        "தமிழ்" -> mapOf(

            "title" to "அமைப்புகள்",
            "shake" to "ஷேக் கண்டறிதல்",
            "siren" to "சைரன் ஒலி",
            "flashlight" to "பிளாஷ் லைட்",
            "vibration" to "அதிர்வு",
            "autoLogin" to "தானியங்கி உள்நுழைவு",
            "darkMode" to "டார்க் மோடு",
            "countdown" to "அவசர கவுண்ட்டவுன்",
            "logout" to "வெளியேறு",
            "seconds3" to "3 விநாடிகள்",
            "seconds5" to "5 விநாடிகள்",
            "seconds10" to "10 விநாடிகள்"
        )

        // HINDI

        "हिन्दी" -> mapOf(

            "title" to "सेटिंग्स",
            "shake" to "शेक डिटेक्शन",
            "siren" to "सायरन ध्वनि",
            "flashlight" to "फ्लैशलाइट",
            "vibration" to "वाइब्रेशन",
            "autoLogin" to "ऑटो लॉगिन",
            "darkMode" to "डार्क मोड",
            "countdown" to "आपातकालीन काउंटडाउन",
            "logout" to "लॉगआउट",
            "seconds3" to "3 सेकंड",
            "seconds5" to "5 सेकंड",
            "seconds10" to "10 सेकंड"
        )

        // TELUGU

        "తెలుగు" -> mapOf(

            "title" to "సెట్టింగ్స్",
            "shake" to "షేక్ డిటెక్షన్",
            "siren" to "సైరన్ శబ్దం",
            "flashlight" to "ఫ్లాష్ లైట్",
            "vibration" to "వైబ్రేషన్",
            "autoLogin" to "ఆటో లాగిన్",
            "darkMode" to "డార్క్ మోడ్",
            "countdown" to "ఎమర్జెన్సీ కౌంట్‌డౌన్",
            "logout" to "లాగ్అవుట్",
            "seconds3" to "3 సెకన్లు",
            "seconds5" to "5 సెకన్లు",
            "seconds10" to "10 సెకన్లు"
        )

        // KANNADA

        "ಕನ್ನಡ" -> mapOf(

            "title" to "ಸೆಟ್ಟಿಂಗ್ಸ್",
            "shake" to "ಶೇಕ್ ಡಿಟೆಕ್ಷನ್",
            "siren" to "ಸೈರನ್ ಧ್ವನಿ",
            "flashlight" to "ಫ್ಲಾಶ್ ಲೈಟ್",
            "vibration" to "ವೈಬ್ರೇಶನ್",
            "autoLogin" to "ಆಟೋ ಲಾಗಿನ್",
            "darkMode" to "ಡಾರ್ಕ್ ಮೋಡ್",
            "countdown" to "ತುರ್ತು ಕೌಂಟ್‌ಡೌನ್",
            "logout" to "ಲಾಗ್ ಔಟ್",
            "seconds3" to "3 ಸೆಕೆಂಡುಗಳು",
            "seconds5" to "5 ಸೆಕೆಂಡುಗಳು",
            "seconds10" to "10 ಸೆಕೆಂಡುಗಳು"
        )

        // MALAYALAM

        "മലയാളം" -> mapOf(

            "title" to "സെറ്റിംഗ്സ്",
            "shake" to "ഷേക്ക് ഡിറ്റെക്ഷൻ",
            "siren" to "സൈറൺ ശബ്ദം",
            "flashlight" to "ഫ്ലാഷ് ലൈറ്റ്",
            "vibration" to "വൈബ്രേഷൻ",
            "autoLogin" to "ഓട്ടോ ലോഗിൻ",
            "darkMode" to "ഡാർക്ക് മോഡ്",
            "countdown" to "എമർജൻസി കൗണ്ട്ഡൗൺ",
            "logout" to "ലോഗ്ഔട്ട്",
            "seconds3" to "3 സെക്കൻഡ്",
            "seconds5" to "5 സെക്കൻഡ്",
            "seconds10" to "10 സെക്കൻഡ്"
        )

        // BENGALI

        "বাংলা" -> mapOf(

            "title" to "সেটিংস",
            "shake" to "শেক ডিটেকশন",
            "siren" to "সাইরেন শব্দ",
            "flashlight" to "ফ্ল্যাশলাইট",
            "vibration" to "ভাইব্রেশন",
            "autoLogin" to "অটো লগইন",
            "darkMode" to "ডার্ক মোড",
            "countdown" to "ইমার্জেন্সি কাউন্টডাউন",
            "logout" to "লগআউট",
            "seconds3" to "3 সেকেন্ড",
            "seconds5" to "5 সেকেন্ড",
            "seconds10" to "10 সেকেন্ড"
        )

        // MARATHI

        "मराठी" -> mapOf(

            "title" to "सेटिंग्ज",
            "shake" to "शेक डिटेक्शन",
            "siren" to "सायरेन आवाज",
            "flashlight" to "फ्लॅशलाइट",
            "vibration" to "व्हायब्रेशन",
            "autoLogin" to "ऑटो लॉगिन",
            "darkMode" to "डार्क मोड",
            "countdown" to "आपत्कालीन काउंटडाउन",
            "logout" to "लॉगआउट",
            "seconds3" to "3 सेकंद",
            "seconds5" to "5 सेकंद",
            "seconds10" to "10 सेकंद"
        )

        // ENGLISH

        else -> mapOf(

            "title" to "Settings",
            "shake" to "Shake Detection",
            "siren" to "Siren Sound",
            "flashlight" to "Flashlight Blink",
            "vibration" to "Vibration",
            "autoLogin" to "Auto Login",
            "darkMode" to "Dark Mode",
            "countdown" to "Emergency Countdown",
            "logout" to "Logout",
            "seconds3" to "3 Seconds",
            "seconds5" to "5 Seconds",
            "seconds10" to "10 Seconds"
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
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(20.dp)
        ) {

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // TOP BAR

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Text(
                    text =
                        appText["title"] ?: "",

                    color = Color.White,

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            SettingSwitchCard(
                title =
                    appText["shake"] ?: "",

                checked =
                    shakeDetection,

                onCheckedChange = {

                    shakeDetection = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "shakeDetection",
                            it
                        )
                        .apply()
                }
            )

            SettingSwitchCard(
                title =
                    appText["siren"] ?: "",

                checked =
                    sirenEnabled,

                onCheckedChange = {

                    sirenEnabled = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "sirenEnabled",
                            it
                        )
                        .apply()
                }
            )

            SettingSwitchCard(
                title =
                    appText["flashlight"] ?: "",

                checked =
                    flashlightEnabled,

                onCheckedChange = {

                    flashlightEnabled = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "flashlightEnabled",
                            it
                        )
                        .apply()
                }
            )

            SettingSwitchCard(
                title =
                    appText["vibration"] ?: "",

                checked =
                    vibrationEnabled,

                onCheckedChange = {

                    vibrationEnabled = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "vibrationEnabled",
                            it
                        )
                        .apply()
                }
            )

            SettingSwitchCard(
                title =
                    appText["autoLogin"] ?: "",

                checked =
                    autoLogin,

                onCheckedChange = {

                    autoLogin = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "autoLogin",
                            it
                        )
                        .apply()
                }
            )

            SettingSwitchCard(
                title =
                    appText["darkMode"] ?: "",

                checked =
                    darkMode,

                onCheckedChange = {

                    darkMode = it

                    sharedPreferences.edit()
                        .putBoolean(
                            "darkMode",
                            it
                        )
                        .apply()
                }
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // COUNTDOWN CARD

            Card(
                colors = CardDefaults.cardColors(
                    containerColor =
                        Color(0xFF142850)
                ),

                shape =
                    RoundedCornerShape(20.dp),

                modifier =
                    Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text =
                            appText["countdown"]
                                ?: "",

                        color = Color.White,

                        fontSize = 20.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(15.dp)
                    )

                    Box {

                        Button(
                            onClick = {
                                expanded = true
                            },

                            colors =
                                ButtonDefaults
                                    .buttonColors(
                                        containerColor =
                                            Color.Red
                                    )
                        ) {

                            Text(
                                text =
                                    selectedCountdown
                            )

                            Spacer(
                                modifier =
                                    Modifier.width(6.dp)
                            )

                            Icon(
                                imageVector =
                                    Icons.Default
                                        .ArrowDropDown,

                                contentDescription =
                                    null
                            )
                        }

                        DropdownMenu(
                            expanded = expanded,

                            onDismissRequest = {
                                expanded = false
                            }
                        ) {

                            val countdowns =
                                listOf(
                                    appText["seconds3"],
                                    appText["seconds5"],
                                    appText["seconds10"]
                                )

                            countdowns.forEach { item ->

                                DropdownMenuItem(

                                    text = {
                                        Text(item ?: "")
                                    },

                                    onClick = {

                                        selectedCountdown =
                                            item ?: ""

                                        expanded =
                                            false

                                        sharedPreferences
                                            .edit()

                                            .putString(
                                                "countdown",
                                                item
                                            )

                                            .apply()
                                    }
                                )
                            }
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            // LOGOUT BUTTON

            Button(
                onClick = {

                    sharedPreferences
                        .edit()
                        .putBoolean(
                            "isLoggedIn",
                            false
                        )
                        .apply()

                    navController.navigate(
                        "login"
                    ) {
                        popUpTo(0)
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),

                colors = ButtonDefaults
                    .buttonColors(
                        containerColor =
                            Color.Red
                    ),

                shape =
                    RoundedCornerShape(18.dp)
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Logout,

                    contentDescription =
                        null,

                    tint = Color.White
                )

                Spacer(
                    modifier =
                        Modifier.width(10.dp)
                )

                Text(
                    text =
                        appText["logout"]
                            ?: "",

                    color = Color.White,

                    fontSize = 18.sp,

                    fontWeight =
                        FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(40.dp)
            )
        }
    }
}

@Composable
fun SettingSwitchCard(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor =
                Color(0xFF142850)
        ),

        shape =
            RoundedCornerShape(20.dp),

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text = title,

                color = Color.White,

                fontSize = 18.sp,

                fontWeight = FontWeight.SemiBold,

                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = checked,

                onCheckedChange =
                    onCheckedChange
            )
        }
    }
}