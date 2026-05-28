package com.example.rakshaapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
fun TipsScreen(
    navController: NavHostController
) {

    // LANGUAGE

    val selectedLanguage =
        LanguageManager.selectedLanguage

    // TRANSLATIONS

    val appText = when (selectedLanguage) {

        // TAMIL

        "தமிழ்" -> mapOf(

            "title" to "பாதுகாப்பு குறிப்புகள்",

            "tip1" to
                    "எப்போதும் உங்கள் சுற்றுப்புறத்தை கவனமாக கவனியுங்கள்.",

            "tip2" to
                    "உங்கள் நேரடி இருப்பிடத்தை நம்பகமான தொடர்புகளுடன் பகிருங்கள்.",

            "tip3" to
                    "இரவு நேர பயணங்களில் தனிமையான இடங்களை தவிர்க்கவும்.",

            "tip4" to
                    "பயணத்திற்கு முன் உங்கள் மொபைலை முழுமையாக சார்ஜ் செய்யவும்.",

            "tip5" to
                    "அவசரநிலையில் உடனே SOS பயன்படுத்தவும்.",

            "tip6" to
                    "அவசர உதவி எண்களை சேமித்து வைத்திருங்கள்."
        )

        // HINDI

        "हिन्दी" -> mapOf(

            "title" to "सुरक्षा सुझाव",

            "tip1" to
                    "हमेशा अपने आसपास के वातावरण के प्रति सतर्क रहें।",

            "tip2" to
                    "अपनी लाइव लोकेशन विश्वसनीय संपर्कों के साथ साझा करें।",

            "tip3" to
                    "देर रात यात्रा के दौरान सुनसान जगहों से बचें।",

            "tip4" to
                    "यात्रा से पहले अपना फोन पूरी तरह चार्ज रखें।",

            "tip5" to
                    "आपातकाल में तुरंत SOS का उपयोग करें।",

            "tip6" to
                    "आपातकालीन हेल्पलाइन नंबर सेव रखें।"
        )

        // TELUGU

        "తెలుగు" -> mapOf(

            "title" to "భద్రతా సూచనలు",

            "tip1" to
                    "ఎల్లప్పుడూ మీ పరిసరాలను గమనించండి.",

            "tip2" to
                    "మీ లైవ్ లొకేషన్‌ను నమ్మకమైన వ్యక్తులతో పంచుకోండి.",

            "tip3" to
                    "రాత్రి సమయంలో ఒంటరి ప్రాంతాలను నివారించండి.",

            "tip4" to
                    "ప్రయాణానికి ముందు ఫోన్ పూర్తిగా ఛార్జ్ చేయండి.",

            "tip5" to
                    "అత్యవసర పరిస్థితుల్లో వెంటనే SOS ఉపయోగించండి.",

            "tip6" to
                    "అత్యవసర హెల్ప్‌లైన్ నంబర్లు సేవ్ చేసుకోండి."
        )

        // KANNADA

        "ಕನ್ನಡ" -> mapOf(

            "title" to "ಭದ್ರತಾ ಸಲಹೆಗಳು",

            "tip1" to
                    "ಯಾವಾಗಲೂ ನಿಮ್ಮ ಸುತ್ತಮುತ್ತಲಿನ ಪರಿಸರದ ಬಗ್ಗೆ ಎಚ್ಚರಿಕೆಯಿಂದಿರಿ.",

            "tip2" to
                    "ನಿಮ್ಮ ಲೈವ್ ಸ್ಥಳವನ್ನು ನಂಬಿಕೆಯ ಸಂಪರ್ಕಗಳೊಂದಿಗೆ ಹಂಚಿಕೊಳ್ಳಿ.",

            "tip3" to
                    "ರಾತ್ರಿ ವೇಳೆ ಒಂಟಿ ಪ್ರದೇಶಗಳನ್ನು ತಪ್ಪಿಸಿ.",

            "tip4" to
                    "ಪ್ರಯಾಣಕ್ಕೂ ಮೊದಲು ಫೋನ್ ಸಂಪೂರ್ಣ ಚಾರ್ಜ್ ಮಾಡಿ.",

            "tip5" to
                    "ತುರ್ತು ಪರಿಸ್ಥಿತಿಯಲ್ಲಿ ತಕ್ಷಣ SOS ಬಳಸಿ.",

            "tip6" to
                    "ತುರ್ತು ಸಹಾಯವಾಣಿ ಸಂಖ್ಯೆಗಳು ಉಳಿಸಿ."
        )

        // MALAYALAM

        "മലയാളം" -> mapOf(

            "title" to "സുരക്ഷാ നിർദേശങ്ങൾ",

            "tip1" to
                    "എപ്പോഴും നിങ്ങളുടെ ചുറ്റുപാടുകൾ ശ്രദ്ധിക്കുക.",

            "tip2" to
                    "നിങ്ങളുടെ ലൈവ് ലൊക്കേഷൻ വിശ്വസനീയരായ ആളുകളുമായി പങ്കിടുക.",

            "tip3" to
                    "രാത്രിയിൽ ഒറ്റപ്പെട്ട സ്ഥലങ്ങൾ ഒഴിവാക്കുക.",

            "tip4" to
                    "യാത്രയ്ക്ക് മുമ്പ് ഫോൺ പൂർണ്ണമായി ചാർജ് ചെയ്യുക.",

            "tip5" to
                    "അപകടസാഹചര്യത്തിൽ ഉടൻ SOS ഉപയോഗിക്കുക.",

            "tip6" to
                    "അപകട സഹായ നമ്പറുകൾ സേവ് ചെയ്ത് വയ്ക്കുക."
        )

        // BENGALI

        "বাংলা" -> mapOf(

            "title" to "নিরাপত্তা টিপস",

            "tip1" to
                    "সবসময় আপনার আশেপাশের পরিবেশ সম্পর্কে সচেতন থাকুন।",

            "tip2" to
                    "বিশ্বস্ত ব্যক্তিদের সঙ্গে আপনার লাইভ লোকেশন শেয়ার করুন।",

            "tip3" to
                    "রাতের ভ্রমণে নির্জন জায়গা এড়িয়ে চলুন।",

            "tip4" to
                    "ভ্রমণের আগে ফোন সম্পূর্ণ চার্জ করুন।",

            "tip5" to
                    "জরুরি পরিস্থিতিতে সঙ্গে সঙ্গে SOS ব্যবহার করুন।",

            "tip6" to
                    "জরুরি হেল্পলাইন নম্বর সেভ করে রাখুন।"
        )

        // MARATHI

        "मराठी" -> mapOf(

            "title" to "सुरक्षा टिप्स",

            "tip1" to
                    "नेहमी आपल्या आजूबाजूच्या वातावरणाबद्दल सतर्क रहा.",

            "tip2" to
                    "आपले लाईव्ह लोकेशन विश्वासू संपर्कांसोबत शेअर करा.",

            "tip3" to
                    "रात्रीच्या प्रवासात एकांत ठिकाणे टाळा.",

            "tip4" to
                    "प्रवासापूर्वी फोन पूर्ण चार्ज ठेवा.",

            "tip5" to
                    "आपत्कालीन परिस्थितीत लगेच SOS वापरा.",

            "tip6" to
                    "आपत्कालीन हेल्पलाइन क्रमांक सेव्ह ठेवा."
        )

        // ENGLISH

        else -> mapOf(

            "title" to "Safety Tips",

            "tip1" to
                    "Stay aware of your surroundings at all times.",

            "tip2" to
                    "Share your live location with trusted contacts.",

            "tip3" to
                    "Avoid isolated areas during late night travel.",

            "tip4" to
                    "Keep your phone fully charged before travelling.",

            "tip5" to
                    "Use SOS immediately during emergency situations.",

            "tip6" to
                    "Save emergency helpline numbers."
        )
    }

    // TIPS LIST

    val tips = listOf(

        appText["tip1"] ?: "",
        appText["tip2"] ?: "",
        appText["tip3"] ?: "",
        appText["tip4"] ?: "",
        appText["tip5"] ?: "",
        appText["tip6"] ?: ""
    )

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

            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn {

                items(tips.size) { index ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 18.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF142850)
                        ),

                        shape = RoundedCornerShape(20.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),

                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector =
                                    Icons.Default.Security,

                                contentDescription = null,

                                tint = Color.Red
                            )

                            Spacer(
                                modifier =
                                    Modifier.width(16.dp)
                            )

                            Text(
                                text = tips[index],

                                color = Color.White,

                                fontSize = 17.sp,

                                lineHeight = 28.sp,

                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}