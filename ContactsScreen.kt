package com.example.rakshaapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.google.firebase.database.*

@Composable
fun ContactsScreen(
    navController: NavHostController
) {

    // LANGUAGE

    val selectedLanguage =
        LanguageManager.selectedLanguage

    val appText = when (selectedLanguage) {

        // TAMIL

        "தமிழ்" -> mapOf(

            "title" to "அவசர தொடர்புகள்",
            "add" to "தொடர்பு சேர்க்க",
            "edit" to "தொடர்பை திருத்து",
            "save" to "சேமிக்க",
            "cancel" to "ரத்து",
            "name" to "பெயர்",
            "phone" to "தொலைபேசி எண்"
        )

        // HINDI

        "हिन्दी" -> mapOf(

            "title" to "आपातकालीन संपर्क",
            "add" to "संपर्क जोड़ें",
            "edit" to "संपर्क संपादित करें",
            "save" to "सहेजें",
            "cancel" to "रद्द करें",
            "name" to "नाम",
            "phone" to "फ़ोन नंबर"
        )

        // TELUGU

        "తెలుగు" -> mapOf(

            "title" to "అత్యవసర సంప్రదింపులు",
            "add" to "సంప్రదింపును జోడించండి",
            "edit" to "సంప్రదింపును సవరించండి",
            "save" to "సేవ్ చేయండి",
            "cancel" to "రద్దు",
            "name" to "పేరు",
            "phone" to "ఫోన్ నంబర్"
        )

        // KANNADA

        "ಕನ್ನಡ" -> mapOf(

            "title" to "ತುರ್ತು ಸಂಪರ್ಕಗಳು",
            "add" to "ಸಂಪರ್ಕ ಸೇರಿಸಿ",
            "edit" to "ಸಂಪರ್ಕ ತಿದ್ದು",
            "save" to "ಉಳಿಸಿ",
            "cancel" to "ರದ್ದು",
            "name" to "ಹೆಸರು",
            "phone" to "ದೂರವಾಣಿ ಸಂಖ್ಯೆ"
        )

        // MALAYALAM

        "മലയാളം" -> mapOf(

            "title" to "അടിയന്തര ബന്ധങ്ങൾ",
            "add" to "ബന്ധം ചേർക്കുക",
            "edit" to "ബന്ധം തിരുത്തുക",
            "save" to "സേവ് ചെയ്യുക",
            "cancel" to "റദ്ദാക്കുക",
            "name" to "പേര്",
            "phone" to "ഫോൺ നമ്പർ"
        )

        // BENGALI

        "বাংলা" -> mapOf(

            "title" to "জরুরি যোগাযোগ",
            "add" to "যোগাযোগ যোগ করুন",
            "edit" to "যোগাযোগ সম্পাদনা করুন",
            "save" to "সংরক্ষণ করুন",
            "cancel" to "বাতিল",
            "name" to "নাম",
            "phone" to "ফোন নম্বর"
        )

        // MARATHI

        "मराठी" -> mapOf(

            "title" to "आपत्कालीन संपर्क",
            "add" to "संपर्क जोडा",
            "edit" to "संपर्क संपादित करा",
            "save" to "जतन करा",
            "cancel" to "रद्द करा",
            "name" to "नाव",
            "phone" to "फोन नंबर"
        )

        // ENGLISH

        else -> mapOf(

            "title" to "Emergency Contacts",
            "add" to "Add Contact",
            "edit" to "Edit Contact",
            "save" to "Save",
            "cancel" to "Cancel",
            "name" to "Name",
            "phone" to "Phone Number"
        )
    }

    // FIREBASE

    val database =
        FirebaseDatabase.getInstance()

    val contactsRef =
        database.getReference("contacts")

    // CONTACT LIST

    var contactList by remember {
        mutableStateOf(listOf<ContactModel>())
    }

    // DIALOG

    var showDialog by remember {
        mutableStateOf(false)
    }

    // TEXTFIELDS

    var name by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    // EDIT MODE

    var editingId by remember {
        mutableStateOf<String?>(null)
    }

    // LOAD CONTACTS

    LaunchedEffect(Unit) {

        contactsRef.addValueEventListener(
            object : ValueEventListener {

                override fun onDataChange(
                    snapshot: DataSnapshot
                ) {

                    val list =
                        mutableListOf<ContactModel>()

                    for (data in snapshot.children) {

                        val contact =
                            data.getValue(
                                ContactModel::class.java
                            )

                        if (contact != null) {

                            list.add(contact)
                        }
                    }

                    contactList = list
                }

                override fun onCancelled(
                    error: DatabaseError
                ) {

                }
            }
        )
    }

    // UI

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
                    text = appText["title"] ?: "",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            // ADD BUTTON

            Button(
                onClick = {

                    editingId = null
                    name = ""
                    phone = ""

                    showDialog = true
                },

                modifier =
                    Modifier.fillMaxWidth(),

                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    ),

                shape =
                    RoundedCornerShape(16.dp)
            ) {

                Icon(
                    imageVector =
                        Icons.Default.Add,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = appText["add"] ?: ""
                )
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            // CONTACT LIST

            LazyColumn {

                items(contactList) { contact ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),

                        colors =
                            CardDefaults.cardColors(
                                containerColor =
                                    Color(0xFF142850)
                            ),

                        shape =
                            RoundedCornerShape(20.dp)
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

                            // LEFT SIDE

                            Row(
                                verticalAlignment =
                                    Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector =
                                        Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.Red
                                )

                                Spacer(
                                    modifier =
                                        Modifier.width(14.dp)
                                )

                                Column {

                                    Text(
                                        text =
                                            contact.name ?: "",

                                        color =
                                            Color.White,

                                        fontSize =
                                            20.sp,

                                        fontWeight =
                                            FontWeight.Bold
                                    )

                                    Spacer(
                                        modifier =
                                            Modifier.height(4.dp)
                                    )

                                    Text(
                                        text =
                                            contact.phone ?: "",

                                        color =
                                            Color.LightGray
                                    )
                                }
                            }

                            // EDIT + DELETE

                            Row {

                                // EDIT

                                IconButton(
                                    onClick = {

                                        editingId =
                                            contact.id

                                        name =
                                            contact.name ?: ""

                                        phone =
                                            contact.phone ?: ""

                                        showDialog = true
                                    }
                                ) {

                                    Icon(
                                        imageVector =
                                            Icons.Default.Edit,

                                        contentDescription =
                                            null,

                                        tint =
                                            Color.White
                                    )
                                }

                                // DELETE

                                IconButton(
                                    onClick = {

                                        contact.id?.let {

                                            contactsRef
                                                .child(it)
                                                .removeValue()
                                        }
                                    }
                                ) {

                                    Icon(
                                        imageVector =
                                            Icons.Default.Delete,

                                        contentDescription =
                                            null,

                                        tint =
                                            Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // DIALOG

            if (showDialog) {

                AlertDialog(

                    onDismissRequest = {
                        showDialog = false
                    },

                    confirmButton = {

                        Button(
                            onClick = {

                                if (
                                    name.isNotEmpty() &&
                                    phone.isNotEmpty()
                                ) {

                                    val id =
                                        editingId
                                            ?: contactsRef
                                                .push()
                                                .key
                                            ?: ""

                                    val contact =
                                        ContactModel(
                                            id = id,
                                            name = name,
                                            phone = phone
                                        )

                                    contactsRef
                                        .child(id)
                                        .setValue(contact)

                                    editingId = null
                                    name = ""
                                    phone = ""

                                    showDialog = false
                                }
                            }
                        ) {

                            Text(
                                appText["save"] ?: ""
                            )
                        }
                    },

                    dismissButton = {

                        TextButton(
                            onClick = {
                                showDialog = false
                            }
                        ) {

                            Text(
                                appText["cancel"] ?: ""
                            )
                        }
                    },

                    title = {

                        Text(

                            if (editingId == null)
                                appText["add"] ?: ""
                            else
                                appText["edit"] ?: ""
                        )
                    },

                    text = {

                        Column {

                            OutlinedTextField(
                                value = name,

                                onValueChange = {
                                    name = it
                                },

                                label = {
                                    Text(
                                        appText["name"] ?: ""
                                    )
                                },

                                singleLine = true
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(12.dp)
                            )

                            OutlinedTextField(
                                value = phone,

                                onValueChange = {
                                    phone = it
                                },

                                label = {
                                    Text(
                                        appText["phone"] ?: ""
                                    )
                                },

                                singleLine = true
                            )
                        }
                    }
                )
            }
        }
    }
}