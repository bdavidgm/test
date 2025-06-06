package com.daviddev.passwordmanager.views



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test3() {
    //var presses by remember{ mutableIntStateOf(0) }
    val scrollState = rememberScrollState()
    val gradient =
        Brush.verticalGradient(
            listOf(Color.Red, Color.Blue, Color.Green),
            0.0f,
            10000.0f,
            TileMode.Repeated
        )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                },
                actions = {
                    // Add icons and actions here
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }

                    Text("Top app bar")

                    IconButton(onClick = { /* Handle settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*presses++*/ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column( modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize() // Occupy the entire screen
            .padding(start = 20.dp, top = 100.dp, bottom = 150.dp, end = 20.dp ), // Add some padding around the column
            verticalArrangement = Arrangement.spacedBy(20.dp), // Adjust spacing as needed
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ){
            // fim
            for (i in 1..20) {
                ElevatedCard(
                    colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.surfaceContainer ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth() // Make cards take full width
                        .height(100.dp) // Adjust height as needed
                ) {
                    Text(
                        text = "Outlined $i",
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

    }
}


