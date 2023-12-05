package org.recherche.app_allocation_gestion_part

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.recherche.app_allocation_gestion_part.ui.theme.AppallocationgestionpartTheme
import org.recherche.app_allocation_gestion_part.ui.theme.Components
import org.recherche.app_allocation_gestion_part.viewmodels.HistoryDetailsViewModel
import org.recherche.app_allocation_gestion_part.viewmodels.HistoryViewModel

class HistoryDetailsViewModel : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppallocationgestionpartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting10("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting10(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview10() {
    AppallocationgestionpartTheme {
        HistoryDetailsScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryDetailsScreen(historyViewModel: HistoryDetailsViewModel) {


    val localContext = LocalContext.current as Activity
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar =  { Components.TopAppBar_(title = "History") {localContext.finish()}},
        snackbarHost = { SnackbarHost(snackbarHostState) },

        ) {paddingValues ->


        Box(modifier = Modifier.padding(paddingValues)) {

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryDetailsScreen() {


//    val localContext = LocalContext.current as Activity
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var isMapped by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar =  { Components.TopAppBar_(title = "History Details") {}},
        snackbarHost = { SnackbarHost(snackbarHostState) },
        ) {paddingValues ->


        Box(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            Column {

                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "User Info", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = "got user", tint = Color.Blue)
                        
                    }
                }

                Divider()

                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Car Info", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = "got Car", tint = Color.Blue)
                    }
                }

                Divider()

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Date get", style = MaterialTheme.typography.labelSmall)
                    Text(text = "yyyy/mm/dd")
                }

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Date return", style = MaterialTheme.typography.labelSmall)
                    Text(text = "yyyy/mm/dd" )
                }

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "price", style = MaterialTheme.typography.labelSmall)
                    Text(text = "234.4")

                }


                Divider()



                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Dis-Active", style = MaterialTheme.typography.labelSmall)
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_do_not_disturb_on_24,)   , contentDescription = "Dis Active", tint = Color.Blue)
                    }
                    
                }
                Divider()


                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "enable mapping", style = MaterialTheme.typography.labelSmall,)
                    Switch(checked = isMapped, onCheckedChange = { isMapped = it})


                }


                if (isMapped) {

                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "google maps", style = MaterialTheme.typography.labelSmall)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_fmd_good_24), contentDescription = "map enable" , tint = Color.Blue)
                        }

                    }

                }






            }
        }

    }

}