package com.daviddev.passwordmanager.views

import com.daviddev.passwordmanager.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.constants.DataType
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import com.daviddev.passwordmanager.viewmodels.AddAccountViewModel
import kotlinx.coroutines.delay


@Composable
fun ShowDataRow(acc: KeyValueAccountData,onClick: () -> Unit)
{
   Content(acc,onClick)
    //ShowDataCard(acc,onClick)
}

@Composable
fun ShowDataCard(acc: KeyValueAccountData,onClick: () -> Unit)
{
    OutlinedCard(
        //colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.onTertiaryContainer ),
        /*elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),*/
        modifier = Modifier
            .fillMaxWidth() // Make cards take full width
            .height(90.dp) // Adjust height as needed
    ) {
        Content(acc,onClick)
    }
}
@Composable
fun Content(acc:KeyValueAccountData,onClick: () -> Unit)
{
    val textsize = 15

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 10.dp, bottom = 0.dp, end = 0.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {


        // Account Name and Creation Date
        Column(
            modifier = Modifier.padding(start = 0.dp)
        ) {
            Row(modifier = Modifier
                .padding(start = 10.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Icon
                /*Icon(
                    Icons.Rounded.AccountCircle,//painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your actual icon resource ID
                    contentDescription = "Account Icon",
                    modifier = Modifier.size(60.dp).padding(5.dp)
                )*/
                RoundedLetter(acc.value)
                Column(modifier = Modifier.padding(start = 0.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(
                            top = 0.dp,
                            start = 5.dp,
                            end = 0.dp,
                            bottom = 0.dp
                        ) ,//.weight(1f, fill = true),
                          //  .padding(horizontal = 8.dp)
                            // .border(2.dp, Color.Black)
                            // .size(width = 250.dp, height = 50.dp)
                            // .fillMaxWidth()
                          //
                        text = acc.value,
                        fontSize = textsize.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(
                            top = 0.dp,
                            start = 0.dp,
                            end = 10.dp,
                            bottom = 0.dp
                        ),
                        text = acc.creationDate.toString(),
                        fontSize = (textsize).sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                }

                IconButton(onClick = {}, modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
                    .padding(top = 0.dp, end = 5.dp, bottom = 0.dp, start = 5.dp)
                    .background(colorResource(R.color.PrimaryColor)) // Transparent background
                    .border(3.dp, Color.White, CircleShape)) // White border)
                {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

            }

            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(5.dp)) {
                // Creation Date



                /*Icon(
                    Icons.Outlined.Create,//painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your actual icon resource ID
                    contentDescription = "Editar",
                    modifier = Modifier.size(25.dp)
                        .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 0.dp)
                )*/




            }
            Divider(
                modifier = Modifier.padding(top = 5.dp,bottom = 0.dp), // Optional horizontal padding
                color = Color.LightGray, // Optional color, defaults to a subtle divider
                thickness = 1.dp // Optional thickness, defaults to 1 dp
            )


        }

    }

}



@Composable
fun RoundedLetter(letter: String) {
    Box(
        modifier = Modifier
            .size(40.dp) // Adjust the size as needed
            .clip(CircleShape)
            .background(colorResource(R.color.PrimaryColor))
            .padding(top = 0.dp, end = 0.dp, bottom = 0.dp, start = 0.dp), // Replace with your desired background color
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter.take(2).uppercase(), // Display one or two letters in uppercase
            style = MaterialTheme.typography.bodyLarge, // Adjust text style as needed
            color = Color.White, // Text color
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun RoundAddButton(onClick: () -> Unit, Size: Int = 48, icon: ImageVector) {
    IconButton(onClick = onClick, modifier = Modifier
        .clip(CircleShape)
        .size(Size.dp)
        .padding(top = 0.dp, end = 5.dp, bottom = 0.dp, start = 5.dp)
        .background(Color.Transparent) // Transparent background
        .border(3.dp, Color.White, CircleShape)) // White border)
    {
        Icon(
            imageVector = icon,
            contentDescription = "Add",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun OvalSaveButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .clip(CircleShape), // This makes the button oval/circular
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.PrimaryColor),
            contentColor = colorResource(R.color.black)
        )
    )
        {
        Text(
            text = text,
            //modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = colorResource(R.color.white)
        // Add some padding for the text
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffoldView(navController: NavController,title:String, view: @Composable () -> Unit){

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

                    /*IconButton(onClick = { /* Handle settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }*/
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
                    //OvalSaveButton("Agregar",{ showDialog = true })
                    Spacer(modifier = Modifier.width(40.dp))
                    //OvalSaveButton("Guardar",{ addToDataBase = true })
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


            Text(
                text = " fontWeight = FontWeight.Bold", // Display one or two letters in uppercase
                style = MaterialTheme.typography.bodyLarge, // Adjust text style as needed
                color = Color.White, // Text color
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

          view();

        }

    }

}
@Composable
fun PasswordTextFieldWithVisibilityToggle(
    modifier: Modifier = Modifier,
    label: String = "Contraseña",
    textToShow: String,
    onValueChange: (String) -> Unit,
) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = textToShow,
        onValueChange = { password = it ; onValueChange(it)},
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                painterResource(id = R.drawable.baseline_visibility_24)
            else painterResource(id = R.drawable.baseline_visibility_off_24)

            // Descripción para accesibilidad
            val description = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(image, description)
            }
        }
    )
}


@Composable
fun ItemCardConAcciones(
    texto: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onEditarClick: () -> Unit, // Función anónima para la acción de editar
    onEliminarClick: () -> Unit  // Función anónima para la acción de eliminar
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 2.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.PrimaryColor))
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Para espaciar el texto y los botones
        ) {
            // Texto
            Text(
                text = texto,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f).clickable { onClick() },// Permite que el texto ocupe el espacio disponible
                color = colorResource(R.color.TextPrimaryColor)                                   // y se ajuste si es largo, antes que los botones.
            )

            // Espacio entre el texto y los botones (opcional, para más separación)
            // Spacer(modifier = Modifier.width(8.dp))

            // Botones de acción
            Row {
                IconButton(onClick = onEditarClick) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Editar",
                        tint = colorResource(R.color.white) // Opcional: para darle color
                    )
                }
                IconButton(onClick = onEliminarClick) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Eliminar",
                        tint = colorResource(R.color.white) // Opcional: para darle color de error
                    )
                }
            }
        }
    }
}





