
package com.daviddev.passwordmanager.Views

import com.daviddev.passwordmanager.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun test2() {
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
                    containerColor = colorResource(id = R.color.PrimaryColor),//MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = colorResource(id = R.color.Verde1)//MaterialTheme.colorScheme.primarycolorResource(id = R.color.Azul1)
                ),
                title = {
                    Text(color=colorResource(id= R.color.SecondaryColor), text ="Data Manager", fontWeight = FontWeight.Bold)
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
                ShowDataRow(i)
                //showDataCard(i)
        }
    }

    }
}
@Composable
fun ShowDataRow(i: Int = 0)
{
            content(i)


    }

@Composable
fun showDataCard(i: Int = 0)
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
        content(i)
    }
}
@Composable
fun content(i: Int = 0)
{
    val textsize = 15

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 5.dp, bottom = 0.dp, end = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


    // Account Name and Creation Date
    Column(
        modifier = Modifier.padding(start = 0.dp)
    ) {
        Row(modifier = Modifier.padding(start = 10.dp, end = 0.dp, top = 5.dp, bottom = 0.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            // Icon
            /*Icon(
                Icons.Rounded.AccountCircle,//painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your actual icon resource ID
                contentDescription = "Account Icon",
                modifier = Modifier.size(60.dp).padding(5.dp)
            )*/
            RoundedLetter("MAIN")
            Text(
                modifier = Modifier.padding(top = 5.dp, start = 15.dp, end = 0.dp, bottom = 0.dp)
                      .padding(horizontal = 8.dp)
                    .border(2.dp, Color.Black)
                   // .size(width = 250.dp, height = 50.dp)
                   // .fillMaxWidth()
                    .weight(1f, fill = false),
                 text= if (i==10) "main account" else "$i - Main Account ahora mismo no se que mas escribir aqui",
                fontSize = (textsize).sp,
                fontWeight = FontWeight.Bold
            )

        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(5.dp)) {
            // Creation Date
            Text(
                modifier = Modifier.padding(
                    top = 5.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 0.dp
                ).weight(1f, fill = false) ,
                text = "Created: 2023-08-01",
                fontSize = (textsize).sp,
                color = androidx.compose.ui.graphics.Color.Gray
            )
            IconButton(onClick = {}, modifier = Modifier
                .clip(CircleShape)
                .size(20.dp)
                .padding(top = 0.dp, end = 5.dp, bottom = 0.dp, start = 5.dp)
                .background(Color.Transparent) // Transparent background
                .border(3.dp, Color.White, CircleShape)) // White border)
            {
                Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

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
            .padding(top = 5.dp, end = 0.dp, bottom = 0.dp, start = 0.dp), // Replace with your desired background color
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
