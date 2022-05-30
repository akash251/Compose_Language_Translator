package com.kamatiaakash.compose_language_translator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp)) {
        TextField(
            value = state.textToBeTranslated,
            onValueChange = {
                viewModel.onTextToBeTranslatedChange(it)
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(7.dp))
        Button(onClick = {
            viewModel.onTranslateButtonClick(
                text = state.textToBeTranslated,
                context = context
            )
        },
            enabled = state.isButtonEnabled,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        ) {
            Text(text = "Translate")
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = state.translatedText)
    }
}
