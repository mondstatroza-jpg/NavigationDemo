package com.example.navigationdemo

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Ключ для главного экрана
@Serializable
data object HomeScreen : NavKey

// Ключ для экрана приветствия. Принимает имя пользователя.
@Serializable
data class WelcomeScreen(val name: String) : NavKey

// Ключ для экрана профиля. Тоже принимает имя, чтобы показать его на аватаре.
@Serializable
data class ProfileScreen(val name: String) : NavKey