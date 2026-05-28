# Raksha – Women Safety Application

## Abstract

Raksha is an Android-based women safety application developed to provide immediate emergency assistance and improve personal security during critical situations. The application enables users to send SOS alerts, share live location details, and communicate with emergency contacts through both online and offline mechanisms.

The primary goal of the application is to ensure that emergency alerts can be delivered reliably even when internet connectivity is unavailable. Raksha combines real-time location tracking, SMS-based emergency communication, and modern Android technologies to create a dependable safety solution.

The system is designed with a simple and user-friendly interface to allow users to access emergency services quickly during panic situations.

---

# Introduction

Personal safety has become one of the most important concerns in modern society, especially for women traveling alone, working late hours, or staying in unfamiliar environments. During emergency situations, immediate communication and accurate location sharing can play a major role in ensuring safety and receiving timely assistance.

Raksha is developed as a smart safety application that helps users send emergency alerts instantly to predefined contacts. The application supports both internet-based communication and offline SMS services to maintain reliability in all network conditions.

The application focuses on:

* Fast emergency response
* Reliable communication
* Real-time location access
* Easy user interaction
* Offline support capability

Raksha provides an efficient solution for emergency management using mobile technology and Android-based services.

---

# Problem Statement

In many emergency situations, victims may not have enough time to make phone calls or communicate their exact location manually. Existing safety systems often depend entirely on internet connectivity, which may not always be available.

Major issues faced in traditional emergency communication systems include:

* Dependence on internet availability
* Delayed emergency response
* Difficulty in sharing accurate location
* Complex emergency procedures
* Lack of quick-access emergency features

Raksha addresses these issues by integrating automatic SOS functionality, live location sharing, and offline SMS alert mechanisms.

---

# Proposed Solution

Raksha provides a smart emergency response system that enables users to notify emergency contacts instantly with minimal user interaction.

The proposed system works as follows:

1. User activates the SOS feature.
2. Application checks internet availability.
3. If online:

   * Live GPS location is fetched.
   * Alert messages are sent through internet services.
4. If offline:

   * SMS alert is automatically sent with the user's last known location.
5. Emergency contacts receive the alert and location information immediately.

This dual-mode communication system ensures continuous emergency support regardless of network conditions.

---

# Key Features

## Emergency SOS Alert

Users can trigger emergency alerts instantly using a single tap.

## Live Location Sharing

The application shares the user's real-time GPS location with emergency contacts.

## Offline SMS Support

If internet connectivity is unavailable, Raksha sends emergency messages through SMS using the device network.

## Emergency Contact Management

Users can save and manage trusted emergency contacts within the application.

## Internet Connectivity Detection

The system automatically detects online and offline states and switches communication methods accordingly.

## Last Known Location Tracking

The application stores the last available GPS location to support offline emergency alerts.

## User Authentication

Firebase Authentication is used to secure user accounts and application access.

## Modern User Interface

Raksha uses Jetpack Compose and Material Design 3 to provide a clean and responsive user experience.

---

# System Architecture

The Raksha application consists of the following major components:

* User Interface Layer
* Authentication Module
* SOS Management Module
* Location Tracking Module
* SMS Service Module
* Internet Connectivity Checker
* Firebase Database Integration

These modules work together to provide reliable emergency communication and location tracking services.

---

# Workflow

## Online Mode

1. User activates SOS.
2. Internet connection is detected.
3. GPS location is fetched.
4. Emergency alert is sent online.
5. Contacts receive live location information.

## Offline Mode

1. User activates SOS.
2. No internet connection is detected.
3. Last known location is retrieved.
4. SMS alert is sent automatically.
5. Emergency contacts receive emergency SMS.

---

# Technologies Used

## Programming Language

* Kotlin

## UI Development

* Jetpack Compose
* Material Design 3

## Backend Services

* Firebase Authentication
* Firebase Realtime Database

## Android Services

* Location Services
* SMS Manager
* Connectivity Manager

## Development Tools

* Android Studio
* Gradle
* GitHub

---

# Advantages

* Fast emergency response
* Works in both online and offline environments
* Real-time location tracking
* Easy to use interface
* Reliable emergency communication
* Secure authentication system
* Lightweight Android application

---

# Future Enhancements

The following improvements can be added in future versions:

* Voice Activated SOS System
* AI-Based Threat Detection
* Smartwatch Integration
* Automatic Audio Recording
* Real-Time Police Notification
* Cloud Backup and Analytics
* Multi-Language Support
* Shake Detection SOS Trigger

---

# Conclusion

Raksha is a reliable women safety application developed to provide quick emergency communication and location sharing during dangerous situations. The application ensures continuous support using both internet-based alerts and offline SMS services.

By combining Android technologies, location tracking, and emergency communication systems, Raksha provides an effective and user-friendly safety solution capable of improving emergency response efficiency and enhancing personal security.

---

# Developer

Ughasri P

---

# GitHub Repository

https://github.com/ughasrip-git/Raksha-Women-Safety-App
