package com.daviddev.passwordmanager.views

import com.daviddev.passwordmanager.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.viewmodels.ShowAccountsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showAccounts(navController: NavController, showAccountsVM: ShowAccountsViewModel) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var deleteAll by remember { mutableStateOf(false) }

    val acccountsNames by showAccountsVM.acccountsNames.collectAsState()
    val accountCount by showAccountsVM.accountDataCount.collectAsState()
    val allAccounts by showAccountsVM.acccountList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.SecondaryColor),//MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = colorResource(id = R.color.Verde1)//MaterialTheme.colorScheme.primarycolorResource(id = R.color.Azul1)
                ),
                title = {
                    Text(
                        color = colorResource(id = R.color.TextPrimaryColor),
                        text = "Data Manager",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {


                },
                actions = {
                    // Add icons and actions here
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }

                    IconButton(onClick = { deleteAll =true}) {
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
                    RoundAddButton(
                        onClick = { navController.navigate("showAccount/{}") },
                        Size = 25,
                        icon = Icons.Filled.Add
                    )
                    RoundAddButton(
                        onClick = { navController.navigate(Constants.ROUTE_ADD_ACCOUNT) },
                        icon = Icons.Filled.Add
                    )
                    RoundAddButton(
                        onClick = { navController.navigate(Constants.ROUTE_SELECT_TEMPLATE) },
                        icon = Icons.Filled.Add
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*presses++*/ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize() // Occupy the entire screen
                .padding(innerPadding)
                .padding(
                    start = 20.dp,
                    top = 20.dp,
                    bottom = 20.dp,
                    end = 20.dp
                ), // Add some padding around the column
            verticalArrangement = Arrangement.spacedBy(2.dp), // Adjust spacing as needed
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ) {
            items(allAccounts) { account ->
                if (account.key == Constants.KEY_ACCOUNT_NAME) {
                    val accid = account.accountId
                    ShowDataRow(
                        account,
                        { navController.navigate("showAccount/$accid") })
                }
            }
        }
    }

    if (deleteAll){
        showAccountsVM.deleteAll()
        deleteAll = false
    }
}

