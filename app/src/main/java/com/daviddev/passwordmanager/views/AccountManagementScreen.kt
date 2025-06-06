package com.daviddev.passwordmanager.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountManagementScreen(
    onSaveAccount: (String, String, String, LocalDateTime, LocalDateTime) -> Unit
) {
    var accountName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var useExpirationDate by remember { mutableStateOf(true) }
    var expirationDays by remember { mutableStateOf("30") }
    var selectedDate by remember { mutableStateOf(LocalDateTime.now().plusDays(30)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Gestión de Cuenta",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedTextField(
                value = accountName,
                onValueChange = { accountName = it },
                label = { Text("Nombre de la cuenta") },
                modifier = Modifier.fillMaxWidth(),
                /*colors = TextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )*/
            )

            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Nombre de usuario") },
                modifier = Modifier.fillMaxWidth(),
                /*colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )*/
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                /*colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )*/
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Método de expiración:", style = MaterialTheme.typography.bodyLarge)
                Row(
                    modifier = Modifier.padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = useExpirationDate,
                        onClick = { useExpirationDate = true }
                    )
                    Text("Fecha específica", modifier = Modifier.padding(start = 8.dp))
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    RadioButton(
                        selected = !useExpirationDate,
                        onClick = { useExpirationDate = false }
                    )
                    Text("Días", modifier = Modifier.padding(start = 8.dp))
                }
            }

            if (useExpirationDate) {
                // Here you would typically add a date picker
                Text(
                    text = "Fecha de expiración: ${selectedDate.format(DateTimeFormatter.ISO_DATE)}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Button(
                    onClick = { /* Implement date picker */ },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Icon(Icons.Default.DateRange, contentDescription = "Seleccionar fecha")
                    Text("Seleccionar fecha", modifier = Modifier.padding(start = 8.dp))
                }
            } else {
                OutlinedTextField(
                    value = expirationDays,
                    onValueChange = { 
                        if (it.isEmpty() || it.toIntOrNull() != null) {
                            expirationDays = it
                            if (it.isNotEmpty()) {
                                selectedDate = LocalDateTime.now().plusDays(it.toLong())
                            }
                        }
                    },
                    label = { Text("Días hasta expiración") },
                    modifier = Modifier.fillMaxWidth(),
                    /*colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )*/
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val creationDate = LocalDateTime.now()
                    onSaveAccount(
                        accountName,
                        userName,
                        password,
                        creationDate,
                        selectedDate
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                //Icon(Icons.Default.Add, contentDescription = "Guardar")
                Text(
                    "Guardar cuenta",
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}