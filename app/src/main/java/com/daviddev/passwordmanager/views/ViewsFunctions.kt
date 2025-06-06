package com.daviddev.passwordmanager.views

import com.daviddev.passwordmanager.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun ShowDataRow(i: Int = 0)
{
    Content(i)
}

@Composable
fun ShowDataCard(i: Int = 0)
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
        Content(i)
    }
}
@Composable
fun Content(i: Int = 0)
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
                        // .border(2.dp, Color.Black)
                        // .size(width = 250.dp, height = 50.dp)
                        // .fillMaxWidth()
                        .weight(1f, fill = true),
                    text= if (i==10) "main account $i - Main Account ahora mismo no se que mas escribir aqui$i - Main Account ahora mismo no se que mas escribir aqui$i - Main Account ahora mismo no se que mas escribir aqui$i - Main Account ahora mismo no se que mas escribir aqui"
                    else
                        if (i==11) "Twittter"
                        else "main account $i - Main Account ahora mismo no se que mas escribir aqui",
                    fontSize = (textsize).sp,
                    fontWeight = FontWeight.Bold
                )

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

