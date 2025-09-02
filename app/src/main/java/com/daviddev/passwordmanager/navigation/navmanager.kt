package com.daviddev.passwordmanager.navigation


import SelectTemplate
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.viewmodels.AddAccountViewModel
import com.daviddev.passwordmanager.viewmodels.SelectTemplateViewModel
import com.daviddev.passwordmanager.viewmodels.ShowAccountsViewModel
import com.daviddev.passwordmanager.views.AddDataView
import com.daviddev.passwordmanager.views.showAccounts
import com.daviddev.passwordmanager.views.showAccount

@Composable
fun NavManager(addAccountVM: AddAccountViewModel, showAccountVM: ShowAccountsViewModel, templateViewModel: SelectTemplateViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Constants.ROUTE_SHOW_ACCOUNTS) {
        composable(Constants.ROUTE_SHOW_ACCOUNTS) {
            showAccounts(navController, showAccountVM)
        }

        composable(Constants.ROUTE_ADD_ACCOUNT) {
            AddDataView(navController, addAccountVM,templateViewModel)
        }

        composable(Constants.ROUTE_SELECT_TEMPLATE) {
            SelectTemplate(navController,templateViewModel)
        }


        composable(
            "AddDataView/{id}", arguments = listOf(
                navArgument("id") { type = NavType.LongType }
            )) {
            val id = it.arguments?.getLong("id") ?: -1
            AddDataView(navController, addAccountVM,templateViewModel,id)
        }

        composable(
            "showAccount/{id}", arguments = listOf(
            navArgument("id") { type = NavType.LongType }
        )) {
            val id = it.arguments?.getLong("id") ?: 0
            showAccount(navController, showAccountVM, id)
        }

//navController.navigate("EditView/${item.id}")

        /*
        composable("EditView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.LongType }
        )){
            val id = it.arguments?.getLong("id") ?: 0
            EditView(navController, cronometroVM, cronosVM, id)
        }*/
    }
}
