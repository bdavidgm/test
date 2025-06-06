package com.daviddev.passwordmanager.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Selecciona una opción") }
    val options: List<Pair<String, ImageVector>> = listOf(
        Pair("Opción 1", Icons.Default.Favorite),
        Pair("Opción 2", Icons.Default.Star),
        Pair("Opción 3", Icons.Default.Home),
        Pair("Opción 4", Icons.Default.Settings),
        Pair("Opción 5", Icons.Default.Person)
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Abrir menú")
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 8.dp)
        ) {
            options.forEach { (text, icon) ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = text
                        expanded = false
                    },
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color.LightGray.copy(alpha = 0.2f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = text,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}
*/
/*
@Composable
fun IconDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Selecciona una opción") }

    val options = listOf(
        Pair("Opción 1", Icons.Default.Favorite),
        Pair("Opción 2", Icons.Default.Star),
        Pair("Opción 3", Icons.Default.Home),
        Pair("Opción 4", Icons.Default.Settings),
        Pair("Opción 5", Icons.Default.Person)
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {  // Use IconButton here
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Abrir menú")
                }
            },
            shape = RoundedCornerShape(12.dp),
           /* colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )*/
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 8.dp)
        ) {
            options.forEach { (text, icon) ->
                DropdownMenuItem(
                    text = {  },
                    onClick = {
                        selectedText = text
                        expanded = false
                    },
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                    ) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color.LightGray.copy(alpha = 0.2f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = text,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}
*/

@Composable
fun Dropdowntest() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Selecciona una opción") }

    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.TopStart)) {
        TextButton(onClick = { expanded = true }) {
            Text(selectedText)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // Botón como item del menú
            DropdownMenuItem(
                onClick = { /* Acción normal */ },
                text = { Text("Opción normal") }
            )
            // Item personalizado con botón
            DropdownMenuItem(
                onClick = { /* Podrías dejar esto vacío */ },
                text = {
                    Row {
                        Text("Acción: ")
                        Button(
                            onClick = {
                                expanded = false
                                selectedText = "Botón presionado"
                                // Acción específica
                            }
                        ) {
                            Text("Presionar")
                        }
                    }
                }
            )
        }
    }
}
