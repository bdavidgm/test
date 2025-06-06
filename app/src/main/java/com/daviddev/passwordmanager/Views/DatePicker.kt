package com.daviddev.passwordmanager.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange // Icono de calendario
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String = "Fecha",
    initialDate: Long? = null, // Fecha inicial en milisegundos
    onDateSelected: (Long?) -> Unit // Lambda para notificar la fecha seleccionada (en milisegundos)
)  {
    var dateStr: String

    var selectedDateMillis by remember { mutableStateOf(initialDate) }
    var showDatePickerDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDateMillis
    )

    // Formateador para mostrar la fecha en el TextField
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    val focusManager = LocalFocusManager.current

    val displayedText = selectedDateMillis?.let { dateFormatter.format(Date(it)) } ?: ""

    OutlinedTextField(
        value = displayedText,
        onValueChange = { dateStr = it },
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { // Hacer todo el campo clickable
                showDatePickerDialog = true
                focusManager.clearFocus() // Quitar foco para que no interfiera el teclado
            }),
        label = { Text(label) },
        readOnly = true, // Importante para que no se pueda escribir directamente
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Seleccionar fecha",
                modifier = Modifier.clickable { // Hacer solo el icono clickable (alternativa)
                    showDatePickerDialog = true
                    focusManager.clearFocus()
                }
            )
        }
    )

    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val newSelectedMillis = datePickerState.selectedDateMillis
                        selectedDateMillis = newSelectedMillis
                        onDateSelected(newSelectedMillis) // Notificar la nueva fecha
                        showDatePickerDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDatePickerDialog = false }
                ) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

// --- Preview para probar ---
@Preview(showBackground = true)
@Composable
fun DatePickerOutlinedTextFieldPreview(label: String = "Fecha", onChange:(String)->Unit) {
    var dateStr : String
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    Column(modifier = Modifier.padding(16.dp)) {
        DatePickerOutlinedTextField(
            label = label,
            initialDate = System.currentTimeMillis(), // Fecha actual como ejemplo
            onDateSelected = { millis ->
                selectedDate = millis
                dateStr = selectedDate?.let { dateFormatter.format(Date(it)) } ?: "Ninguna"
                onChange(dateStr)
            }
        )
        Text(
            text = "Fecha seleccionada: ${selectedDate?.let { dateFormatter.format(Date(it)) } ?: "Ninguna"}",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}