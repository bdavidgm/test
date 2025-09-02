import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.daviddev.passwordmanager.constants.Constants
import com.daviddev.passwordmanager.room.model.KeyValueAccountData
import com.daviddev.passwordmanager.viewmodels.SelectTemplateViewModel
import com.daviddev.passwordmanager.views.ItemCardConAcciones
import com.daviddev.passwordmanager.views.OvalSaveButton
import com.daviddev.passwordmanager.views.scaffoldView
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SelectTemplate(navController: NavController, templateViewModel: SelectTemplateViewModel) {
    var openTemplate by remember{ mutableStateOf( false) }
    var templateNames = templateViewModel.templatesNames.collectAsState()
   var mutableTemplateList = templateNames.value.toMutableList()
    var selectedTemplate by remember{ mutableStateOf( 0L) }


    mutableTemplateList.add(0, KeyValueAccountData(-1,-1,
        key = Constants.KEY_ACCOUNT_NAME,
        value = "Plantilla en blanco",
        Constants.STATUS_TEMPLATE,
        )
    )

    scaffoldView(navController, "Selecionar Plantilla") {
        Column(
            modifier = Modifier.fillMaxSize()
        )
        {
            for (template in mutableTemplateList) {


                    if (template.key == Constants.KEY_ACCOUNT_NAME) {
                        //OvalSaveButton(template.value+" ${template.accountId}",onClick = {})
                        ItemCardConAcciones(template.value, modifier = Modifier.fillMaxWidth(), {openTemplate = true; selectedTemplate = template.accountId},{},{})
                    }
            }
        }
    }
    if (openTemplate) {
        openTemplate = false
        navController.navigate("AddDataView/${selectedTemplate}")
    }


    }

