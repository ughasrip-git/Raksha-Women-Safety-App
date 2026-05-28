package com.example.rakshaapplication

import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.os.*
import kotlinx.coroutines.*

object EmergencyEffects {

    private var mediaPlayer: MediaPlayer? = null

    // SIREN SOUND

    fun startSiren(context: Context) {

        if (mediaPlayer == null) {

            mediaPlayer = MediaPlayer.create(
                context,
                R.raw.siren
            )

            mediaPlayer?.isLooping = true
            mediaPlayer?.start()

            // AUTO STOP AFTER 10 SECONDS

            CoroutineScope(Dispatchers.Main).launch {

                delay(10000)

                stopSiren()
            }
        }
    }

    // STOP SIREN

    fun stopSiren() {

        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    // VIBRATION

    fun vibrate(context: Context) {

        val vibrator =
            context.getSystemService(Context.VIBRATOR_SERVICE)
                    as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            vibrator.vibrate(
                VibrationEffect.createWaveform(
                    longArrayOf(0, 500, 500),
                    0
                )
            )

        } else {

            vibrator.vibrate(5000)
        }

        // STOP VIBRATION AFTER 10 SECONDS

        CoroutineScope(Dispatchers.Main).launch {

            delay(10000)

            vibrator.cancel()
        }
    }

    // FLASHLIGHT ON

    fun startFlashlight(context: Context) {

        try {

            val cameraManager =
                context.getSystemService(Context.CAMERA_SERVICE)
                        as CameraManager

            val cameraId =
                cameraManager.cameraIdList[0]

            cameraManager.setTorchMode(
                cameraId,
                true
            )

        } catch (e: Exception) {

            e.printStackTrace()
        }
    }

    // FLASHLIGHT OFF

    fun stopFlashlight(context: Context) {

        try {

            val cameraManager =
                context.getSystemService(Context.CAMERA_SERVICE)
                        as CameraManager

            val cameraId =
                cameraManager.cameraIdList[0]

            cameraManager.setTorchMode(
                cameraId,
                false
            )

        } catch (e: Exception) {

            e.printStackTrace()
        }
    }
}