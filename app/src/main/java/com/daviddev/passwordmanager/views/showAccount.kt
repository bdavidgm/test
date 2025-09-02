package com.daviddev.passwordmanager.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.constants.DataType
import com.daviddev.passwordmanager.viewmodels.ShowAccountsViewModel

@Composable
fun showAccount(navController: NavController, showAccountsVM: ShowAccountsViewModel, accountId:Long)
{
    LaunchedEffect(accountId) {
        showAccountsVM.loadSingleAccountData(accountId)
    }

    val account =showAccountsVM.SelectedAccount.collectAsState()

    var name : String  = ""

        account.value.forEach{ if (it.key == Constants.KEY_ACCOUNT_NAME){ name = it.value;} }

    scaffoldView(navController,name) {
          //  Text("¡Hola esto es View!   ${account.value.count()}  $accountId")

        account.value.forEach { acc ->
            //val type = DataType(acc.type)
            setComposable(DataType.fromString(acc.type), acc.value, acc.key, {})
        }
    }

}