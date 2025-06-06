package com.daviddev.passwordmanager.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.daviddev.passwordmanager.constants.DataType

@Composable
fun AddItemMenu(expanded: Boolean, onClick: () -> Unit, onDismissRequest: () -> Unit, onOptionSeleted: (DataType) -> Unit  ){
    var text by remember { mutableStateOf("Nombre de elemento") }
    Box(
        modifier = Modifier
            .padding(start=10.dp,end=10.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Tipo de elemento") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth().padding(start=0.dp,end=0.dp),
            trailingIcon = { IconButton(onClick = onClick) {
                Icon(Icons.Default.MoreVert, contentDescription = "tipo de elemento")

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = onDismissRequest,
                    offset = DpOffset(x = 0.dp, y = 0.dp),

                ) {
                    for (type in DataType.values()) {
                        DropdownMenuItem(
                            text = { Text(type.name) },
                            onClick = { text=type.name; onOptionSeleted(type); onDismissRequest(); /* Do something... */ }
                        )
                    }
                }

            }} ,
            readOnly = true,
            //onClick = onClick
        )



    }


}