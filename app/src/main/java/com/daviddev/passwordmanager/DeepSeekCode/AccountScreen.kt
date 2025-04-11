package com.daviddev.passwordmanager.DeepSeekCode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.daviddev.passwordmanager.Model.KeyValueAccountData
import java.time.LocalDateTime
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen() {
    var accountName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf(LocalDateTime.now()) }
    var daysValid by remember { mutableStateOf("") }
   // var expirationDate by remember { mutableStateOf(LocalDateTime.now()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Account Details") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                      Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = accountName,
                onValueChange = { accountName = it },
                label = { Text("Account Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("User Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = daysValid,
                onValueChange = { daysValid = it },
                label = { Text("Days Valid") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                 onClick = {/*
                   // Handle save action

                   val accountData = AccountData(
                       account_id = 0, // This should be generated or fetched
                       user_name = userName,
                       password = password,
                       creation_date = LocalDateTime.now(),
                       expiration_date = expirationDate.plusDays(daysValid.toLong())
                   )
                  val accountNameData = AccountName(
                       account_name = accountName
                   )
                   // Save or process the data
                     */
               },
               modifier = Modifier.fillMaxWidth()
           ) {
               Text("Save")
           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        AccountScreen()
    }
}