package com.daviddev.passwordmanager.Views

//

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.runtime.*
import com.daviddev.passwordmanager.constants.DataType


@Composable
fun getComposableType(type: DataType, source: String, label: String="",onChange:(String) -> Unit) {
    when(type) {
        DataType.TEXT -> {
            OutlinedTextField(
                value = source,
                onValueChange = onChange,
                label = { Text(label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            ) }
        DataType.PARAGRAPH ->{
            OutlinedTextField(
                value = source,
                onValueChange = onChange,
                label = { Text(label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            ) }
        DataType.PASSWORD ->{
            OutlinedTextField(
                value = source,
                onValueChange = onChange,
                label = { Text(label) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            ) }
        DataType.DATE -> { DatePickerOutlinedTextFieldPreview(label,onChange)}



       /* TYPE_TIME_PICKER -> { {} }
        TYPE_SWITCH -> { {} }*/
        else -> { }

    }
}

@Composable
fun enterKey( ) {
    var showDialog by remember { mutableStateOf(false) }

}



