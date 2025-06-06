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
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import com.daviddev.passwordmanager.constants.DataType


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataView() {
    val itemList = remember { mutableStateListOf<KeyValueAccountData>() }

    var showDialog by remember { mutableStateOf(false) }

    var showEnterNameDialog by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }

    var key by remember { mutableStateOf("") }

    var itemType :DataType;


    //var presses by remember{ mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.PrimaryColor),//MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = colorResource(id = R.color.SecondaryColor)//MaterialTheme.colorScheme.primarycolorResource(id = R.color.Azul1)
                ),
                title = {
                    Text(
                        color = colorResource(id = R.color.TextPrimaryColor),
                        text = "Add Data",
                        fontWeight = FontWeight.Normal
                    )
                },
                actions = {
                    // Add icons and actions here

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
                modifier = Modifier
                    .height(90.dp)
                    .padding(bottom = 5.dp /*WindowInsets.navigationBars.getBottom(LocalDensity.current).dp*/)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    // RoundAddButton(onClick = { println("Add button clicked!") },25,Icons.Filled.Add)
                    RoundAddButton(onClick = { showDialog = true }, icon = Icons.Filled.Add)
                    // RoundAddButton(onClick = { println("Add button clicked!") },25, icon = Icons.Filled.Add)
                }
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize() // Occupy the entire screen
                .padding(
                    start = 20.dp,
                    top = 100.dp,
                    bottom = 150.dp,
                    end = 20.dp
                ), // Add some padding around the column
            verticalArrangement = Arrangement.spacedBy(20.dp), // Adjust spacing as needed
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ) {
            if (showDialog) //{ dialogAddKeyValue(showDialog, { showDialog = false},{})}
            {
                DatePickerOutlinedTextFieldPreview(label = "date",{date->println(date)})
            }

        }

    }



    if (showDialog) {
        DialogAddKeyValue(  show=showDialog,
                            onDismissRequest =  { showDialog = false},
                            onConfirm = {
                                            itemList.add(KeyValueAccountData(key=key,type=itemType.type,value="", account_id = 0, id=0))
                                             showDialog = false
                                        },
                            key=key,
                            onKeyChange = {k->key=k},
                            onOptionSeleted = {valueType-> itemType= valueType; getComposableType(valueType)}
        )
    }

}
 fun addDataCard()
 {


 }





