package com.daviddev.passwordmanager.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PasswordManagerView(
    onAddNewEntry: () -> Unit,
    credentials: List<Pair<String, String>> // List of username-password pairs
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Gestor de Contraseñas",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // List of credentials
        LazyColumn {
            items(credentials) { (username, password) ->
                CredentialItem(username, password)
                Divider()
            }
        }

        // Add new entry button
        Button(
            onClick = onAddNewEntry,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Agregar nueva entrada")
        }
    }
}

@Composable
fun CredentialItem(username: String, password: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Usuario: $username",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Contraseña: $password",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}