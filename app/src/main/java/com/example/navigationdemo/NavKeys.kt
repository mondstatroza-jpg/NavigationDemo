package com.example.navigationdemo

import android.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Ключ для главного экрана
@Serializable
data object HomeScreen : NavKey

// Ключ для экрана приветствия. Принимает имя пользователя.
@Serializable
data class WelcomeScreen(val name: String) : NavKey

// Ключ для экрана профиля
@Serializable
data object ProfileScreen : NavKey