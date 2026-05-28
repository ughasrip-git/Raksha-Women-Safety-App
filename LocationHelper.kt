package com.example.rakshaapplication

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

object LocationHelper {

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(
        context: Context,
        onLocationReceived: (Double, Double) -> Unit
    ) {

        val fusedLocationClient =
            LocationServices
                .getFusedLocationProviderClient(context)

        // LAST KNOWN LOCATION

        fusedLocationClient.lastLocation

            .addOnSuccessListener { location: Location? ->

                if (location != null) {

                    onLocationReceived(
                        location.latitude,
                        location.longitude
                    )

                } else {

                    // REALTIME GPS LOCATION

                    fusedLocationClient
                        .getCurrentLocation(
                            Priority.PRIORITY_HIGH_ACCURACY,
                            null
                        )

                        .addOnSuccessListener { currentLocation ->

                            if (currentLocation != null) {

                                onLocationReceived(
                                    currentLocation.latitude,
                                    currentLocation.longitude
                                )

                            } else {

                                // DEFAULT LOCATION IF FAILED

                                onLocationReceived(
                                    0.0,
                                    0.0
                                )
                            }
                        }

                        .addOnFailureListener {

                            onLocationReceived(
                                0.0,
                                0.0
                            )
                        }
                }
            }

            .addOnFailureListener {

                onLocationReceived(
                    0.0,
                    0.0
                )
            }
    }
}