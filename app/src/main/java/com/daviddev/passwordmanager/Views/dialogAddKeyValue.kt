package com.daviddev.passwordmanager.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.daviddev.passwordmanager.R
import com.daviddev.passwordmanager.constants.DataType

@Composable
fun dialogAddKeyValue (show:Boolean = true, onDismissRequest:()-> Unit, onConfirm:()->Unit,key:String,onKeyChange:(String)->Unit,onOptionSeleted: (DataType) -> Unit){
    var menuExpanded by remember { mutableStateOf(false) }
    //var key by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    if (show) {
        Dialog(onDismissRequest =onDismissRequest,) {
            // Dialog content
            OutlinedCard(
                //colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.onTertiaryContainer ),
                /*elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),*/
                modifier = Modifier
                    .height(250.dp) // Adjust height as needed
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(5.dp), // Adjust spacing as needed
                    horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                )
                {

                    Text(
                        text = "Agregar Elemento",
                        color = colorResource(id = R.color.TextPrimaryColor),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                end = 5.dp,
                                top = 5.dp,
                                bottom = 1.dp
                            )
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.PrimaryColor)),


                        )
                    OutlinedTextField(
                        value = key,
                        onValueChange = onKeyChange,
                        label = { Text("Nombre de elemento") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.fillMaxWidth().padding(start=10.dp,end=10.dp),

                    )
                    addItemMenu(menuExpanded,{ menuExpanded = !menuExpanded },{ menuExpanded = false },onOptionSeleted)

                    /* Divider(
                         modifier = Modifier.padding(top = 0.dp,bottom = 0.dp), // Optional horizontal padding
                         color = Color.LightGray, // Optional color, defaults to a subtle divider
                         thickness = 1.dp // Optional thickness, defaults to 1 dp
                     )*/

                }
                Row(Modifier.padding(start=20.dp,end=20.dp,top=20.dp,bottom=0.dp)) {
                    Button(onClick = onConfirm, modifier = Modifier.padding(start = 50.dp,end = 50.dp), colors = ButtonDefaults.buttonColors(
                        colorResource(id = R.color.PrimaryColor)
                    )){
                        Text("Ok")
                    }
                    Button(onClick = onDismissRequest , colors = ButtonDefaults.buttonColors(
                        colorResource(id = R.color.PrimaryColor)
                    )){
                        Text("Cancel")
                    }


                }
            }

        }
    }
}