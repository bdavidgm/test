package com.daviddev.passwordmanager.QwenPlus

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
import com.daviddev.passwordmanager.Model.AccountData
import com.daviddev.passwordmanager.Model.AccountName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.daviddev.passwordmanager.ViewModels.AddAccountViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(addVM : AddAccountViewModel/*navController: NavController*/) {
    Log.i("Seguimiento","dentro de AccountScreen" )
    var accountName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf("") }
    var daysValid by remember { mutableStateOf("") }
    var useDays by remember { mutableStateOf(false) } // Indica si se usa días válidos o fecha manual

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gestión de Cuentas", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /*navController.popBackStack()*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2E7D32))
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Campo para el nombre de la cuenta
                OutlinedTextField(
                    value = accountName,
                    onValueChange = { accountName = it },
                    label = { Text("Nombre de la cuenta") },
                    modifier = Modifier.fillMaxWidth(),
                    /*colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF2E7D32),
                        unfocusedBorderColor = Color.Gray
                    )*/
                )

                // Campo para el nombre de usuario
                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text("Nombre de usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF2E7D32),
                        unfocusedBorderColor = Color.Gray
                    )
                )

                // Campo para la contraseña
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                   /* colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )*/
                )

                // Opción para elegir entre fecha de expiración o días válidos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RadioButton(
                        selected = !useDays,
                        onClick = { useDays = false }
                    )
                    Text("Fecha de Expiración")
                    RadioButton(
                        selected = useDays,
                        onClick = { useDays = true }
                    )
                    Text("Días Válidos")
                }

                if (!useDays) {
                    // Campo para la fecha de expiración
                    OutlinedTextField(
                        value = expirationDate,
                        onValueChange = { expirationDate = it },
                        label = { Text("Fecha de expiración (YYYY-MM-DD)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.fillMaxWidth(),
                        /*colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF2E7D32),
                            unfocusedBorderColor = Color.Gray
                        )*/
                    )
                } else {
                    // Campo para el número de días válidos
                    OutlinedTextField(
                        value = daysValid,
                        onValueChange = { daysValid = it },
                        label = { Text("Número de días válidos") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        /*colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF2E7D32),
                            unfocusedBorderColor = Color.Gray
                        )*/
                    )
                }

                // Botón para guardar los datos
                Button(
                    onClick = {
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        val creationDate = LocalDateTime.now()

                        val expirationDateValue = if (!useDays) {
                            try {
                                LocalDateTime.parse(expirationDate, formatter)
                            } catch (e: Exception) {
                                println("Error al parsear fecha: ${e.message}")
                                return@Button
                            }
                        } else {
                            try {
                                val days = daysValid.toInt()
                                creationDate.plus(days.toLong(), ChronoUnit.DAYS)
                            } catch (e: Exception) {
                                println("Error al procesar días válidos: ${e.message}")
                                return@Button
                            }
                        }

                        val accountData = AccountData(
                            account_id = 0, // ID generado automáticamente
                            user_name = userName,
                            password = password,
                            creation_date = creationDate,
                            expiration_date = expirationDateValue
                        )
                       val accountNameData = AccountName(
                            account_id = 0, // ID generado automáticamente
                            account_name = accountName
                        )

                        // Aquí puedes agregar la lógica para guardar los datos en la base de datos
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
                ) {
                    Text("Guardar", color = Color.White)
                }
            }
        }
    )
}

