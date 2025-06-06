
package com.daviddev.passwordmanager.views

import com.daviddev.passwordmanager.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test2() {
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
                    containerColor = colorResource(id = R.color.SecondaryColor),//MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = colorResource(id = R.color.Verde1)//MaterialTheme.colorScheme.primarycolorResource(id = R.color.Azul1)
                ),
                title = {
                    Text(color=colorResource(id= R.color.TextPrimaryColor), text ="Data Manager", fontWeight = FontWeight.Bold)
                },
                actions = {
                    // Add icons and actions here
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }

                    IconButton(onClick = { /* Handle settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.PrimaryColor),
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.height(60.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RoundAddButton(onClick = { println("Add button clicked!") },25,Icons.Filled.Add)
                    RoundAddButton(onClick = { println("Add button clicked!") }, icon = Icons.Filled.Add)
                    RoundAddButton(onClick = { println("Add button clicked!") },25, icon = Icons.Filled.Add)
                }
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
                com.daviddev.passwordmanager.views.ShowDataRow(i)
                //showDataCard(i)
        }
    }

    }
}