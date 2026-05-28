package com.example.rakshaapplication

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.SmsManager
import android.widget.Toast
import com.google.android.gms.location.LocationServices

object SOSManager {

    @SuppressLint("MissingPermission")
    fun sendSOS(
        context: Context,
        contacts: List<String>
    ) {

        val fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(
                context
            )

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->

                if (location != null) {

                    val latitude = location.latitude
                    val longitude = location.longitude

                    val message =
                        """
HELP! I need assistance.

My live location:
https://maps.google.com/?q=$latitude,$longitude
                        """.trimIndent()

                    try {

                        for (number in contacts) {

                            SmsManager
                                .getDefault()
                                .sendTextMessage(
                                    number,
                                    null,
                                    message,
                                    null,
                                    null
                                )
                        }

                        Toast.makeText(
                            context,
                            "SOS Sent Successfully",
                            Toast.LENGTH_LONG
                        ).show()

                    } catch (e: Exception) {

                        Toast.makeText(
                            context,
                            "SMS Failed: ${e.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } else {

                    Toast.makeText(
                        context,
                        "Location not found",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
}