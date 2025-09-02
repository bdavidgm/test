package com.daviddev.passwordmanager.views

import android.annotation.SuppressLint
import android.util.Log
import com.daviddev.passwordmanager.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.constants.DataType
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import com.daviddev.passwordmanager.viewmodels.AddAccountViewModel
import com.daviddev.passwordmanager.viewmodels.SelectTemplateViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

data class KeyValueView(val key: String, val value: String, val type: DataType) {

}

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataView(
    navController: NavController,
    addAccountVM: AddAccountViewModel,
    templateViewModel: SelectTemplateViewModel,
    templateID: Long = -1
) {
    var title by remember { mutableStateOf("Agregar Cuenta")}
    val context = LocalContext.current

    var itemList = remember { mutableStateListOf<KeyValueAccountData>() }

    var addToDataBase by remember { mutableStateOf(false) }
    var addTemplate by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }


    var key by remember { mutableStateOf("") }

    var value by remember { mutableStateOf("") }

    var itemType: DataType = DataType.UNDEFINED;

    if ((itemList.count() == 0) and (templateID < 0)) {
        itemList.add(
            KeyValueAccountData(
                0,
                0,
                Constants.KEY_ACCOUNT_NAME,
                "",
                Constants.STATUS_ACCOUNT,
                DataType.TEXT.toString()
            )
        )
    }

    if ((templateID >= 0) and (itemList.count() == 0)) {

        LaunchedEffect(Unit) {
           templateViewModel.selectTemplate(templateID ?: 0)
            delay(500)
            templateViewModel.selectedTemplate.value?.let { template ->

                itemList.addAll(template)
                for (i in itemList.indices) {
                    if (itemList[i].key == Constants.KEY_ACCOUNT_NAME)  {
                        title = itemList[i].value
                        itemList[i].value = ""
                    }
                    Log.i(
                        "Seguimiento",
                        "ADD DATA View: template[$i].key = ${template[i].key}  template[$i].value= ${template[i].value}  AccountID:${template[i].accountId}"
                    )
                }
                Log.i(
                    "Seguimiento",
                    "ADD DATA View: Se ejecuta el let, su count es: ${template.count()}"
                )

            }

        }



    }
    Log.i(
        "Seguimiento",
        "ADD DATA View: template.count : ${templateViewModel.selectedTemplate?.value?.count()} "
    )

    Log.i("Seguimiento", "ADD DATA View: templateID : $templateID ")

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
                        text = title,
                        fontWeight = FontWeight.Normal
                    )
                },
                actions = {
                    // Add icons and actions here

                    IconButton(onClick = { /* Handle settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                navigationIcon = {
                    // Solo muestra el icono si hay algo a lo que navegar hacia atrás
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Icono de flecha hacia atrás
                                contentDescription = "Atrás" // Descripción para accesibilidad
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(id = R.color.white),
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
                    OvalSaveButton("Agregar", { showDialog = true })
                    Spacer(modifier = Modifier.width(10.dp))
                    OvalSaveButton("Guardar", { addToDataBase = true })
                    Spacer(modifier = Modifier.width(10.dp))
                    OvalSaveButton("Guardar Plantilla", { addTemplate = true })
                    // RoundAddButton(onClick = { showDialog = true }, icon = Icons.Filled.Add)
                    // RoundAddButton(onClick = {addAccountVM.addAccount(itemList) },50, icon = Icons.Outlined.Check)
                }
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize() // Occupy the entire screen
                .padding(innerPadding)
                .padding(
                    start = 20.dp,
                    top = 20.dp,
                    bottom = 20.dp,
                    end = 20.dp
                ), // Add some padding around the column
            verticalArrangement = Arrangement.spacedBy(20.dp), // Adjust spacing as needed
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ) {

            for (i in itemList.indices) {
                setComposable(
                    DataType.fromString(itemList[i].type),
                    itemList[i].value,
                    itemList[i].key,
                    { data ->
                        itemList[i] = itemList[i].copy(
                            0,
                            0,
                            itemList[i].key,
                            data,
                            itemList[i].type
                        ); /*value = data;*/
                    })
            }


        }

    }



    if (showDialog) {
        DialogAddKeyValue(
            show = showDialog,
            onDismissRequest = { showDialog = false },
            onConfirm = {
                itemList.add(KeyValueAccountData(key = key, value = "", type = itemType.toString()))
                showDialog = false
            },
            key = key,
            onKeyChange = { k -> key = k },
            onOptionSeleted = { valueType -> itemType = valueType; }
        )
    }


    if (addToDataBase) {
        LaunchedEffect(Unit) {
            addAccountVM.addAccount(itemList)
            addToDataBase = false
            // Navegar de vuelta después de un pequeño delay para asegurar que se guarde
            delay(500)
            navController.popBackStack()
        }
    }

    if (addTemplate) {
        LaunchedEffect(Unit) {
            templateViewModel.saveAsTemplate(itemList)
            addTemplate = false
            //templateViewModel.msg(context,"Plantilla Salvada")
            delay(500)
            navController.popBackStack()
        }

    }
}


fun addDataCard() {


}





