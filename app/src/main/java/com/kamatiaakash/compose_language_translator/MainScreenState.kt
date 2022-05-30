package com.kamatiaakash.compose_language_translator

data class MainScreenState(
    val textToBeTranslated:String = "",
    val translatedText:String = "",
    val isButtonEnabled:Boolean = true
)
