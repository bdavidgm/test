package com.daviddev.passwordmanager.views

//

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.daviddev.passwordmanager.constants.DataType


@Composable
fun setComposable(type: DataType, textToShow: String, label: String="", onChange:(String) -> Unit) {
    when(type) {
        DataType.TEXT -> {
            OutlinedTextField(
                value = textToShow,
                onValueChange = onChange,
                label = { Text(label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            ) }
        DataType.PARAGRAPH ->{
            OutlinedTextField(
                value = textToShow,
                onValueChange = onChange,
                label = { Text(label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            ) }
        DataType.PASSWORD ->{
            PasswordTextFieldWithVisibilityToggle(Modifier.fillMaxWidth(), label,textToShow,onChange)
            }
        DataType.DATE -> { DatePickerOutlinedTextFieldPreview(label,onChange)}
       /* TYPE_TIME_PICKER -> { {} }
        TYPE_SWITCH -> { {} }*/
        else -> { }

    }
}

@Composable
fun EnterKey( ) {
    var showDialog by remember { mutableStateOf(false) }

}



