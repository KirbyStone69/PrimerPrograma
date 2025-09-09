package upv_dap.sep_dic_25.itiid_76129.piu1.zuniga_zavala.primerprograma

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import upv_dap.sep_dic_25.itiid_76129.piu1.zuniga_zavala.primerprograma.ui.theme.PrimerProgramaTheme
//private val FabPosition.Companion.CenterEnd: FabPosition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerProgramaTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android Marco Aurelio Nuno Maganda",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                MyScreen()
            }
        }
    }
}

class Lista {
    val stringList : MutableList<String> = mutableListOf()
    fun append(X : String) {
        stringList.add(X)
    }
    fun remove (X : String) {
        stringList.remove(X)
    }
    fun toCadena  () : String {
        return (stringList.toString())
    }
}

class Counter {
    var count by mutableStateOf(0)
        private set

    fun increment() {
        count++
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen() {
    val counter = remember { Counter() }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Primera Aplication Jetpack Compose") })
        },
        /*
        bottomBar = {
            BottomAppBar {
                Text("Barra de Estatus")
            }
        },*/
        floatingActionButton = {
            val context = LocalContext.current
            FloatingActionButton(
                modifier = Modifier.offset(x = 0.dp, y = -60.dp),
                onClick = { /* Handle click */
                    val sum: (Int, Int) -> Int = { a, b -> a + b }
                    Toast.makeText(context,
                        "Evento de Click Sobre boton floante: "+sum(5,7)+ " clicks"+counter.count,
                        Toast.LENGTH_SHORT).show()
                    counter.increment()
                }) {
                Icon(Icons.Default.Build, contentDescription = "Add")
            }

            // Add some spacing between FABs
            ExtendedFloatingActionButton(
                //modifier = Modifier.offset(x = 10.dp, y = 10.dp),
                text = {  },
                icon = { Icon(Icons.Filled.Call, "Edit button") },
                onClick = { /* Handle FAB 2 click */
                    Toast.makeText(context,
                        "CLick Segundo Boton",
                        Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(top = 8.dp) // Add padding between FABs
            )

        },
        //floatingActionButtonPosition = FabPosition.CenterEnd,

        content = { paddingValues ->
            // Main content goes here
            Column(modifier = Modifier.padding(paddingValues)) {
                //UserCard("Marco","Nuño-Maganda")
                //Text("Hello from the content!")
                //Greeting(name = "Android")
                MyPanelDeControlesUI()
            }
        }
    )
}


// Demo 6
@Composable
fun MyPanelDeControlesUI() {
    val lista = remember {  Lista() }

    val context = LocalContext.current
    // Remember the text entered in the TextField
    var text by remember { mutableStateOf("") }

    // Layout to organize the TextField and the Text below it
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        // TextField for user input
        // TextField for user input
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            modifier = Modifier.fillMaxWidth(), // Equivalente a match_parent en el XML
            onClick = { /* Handle button click */
                lista.append(text)
                //Toast.makeText(context,"Dato ingresado por USER en el TextField: "+text,Toast.LENGTH_SHORT).show()
                Toast.makeText(context,"Dato ingresado por USER en el TextField: "+lista.toCadena(),Toast.LENGTH_SHORT).show()
                text="" //Borar el TextField
            }) {
            Text(text = "Formatear")
        }

        // Displaying the text entered by the user
        Text(text = "You entered: $text")

        //Greeting("Android")
        FancyButton("Mejor Instalar Windows")
        UserCard("Pluto","Gomez")

    }
}

@Composable
fun FancyButton(label: String) {
    val context = LocalContext.current
    Button(
        modifier = Modifier.fillMaxWidth(), // Equivalente a match_parent en el XML
        onClick = { /* Handle button click */
            Toast.makeText(context,"Dios mios, porque me as abandonado?",Toast.LENGTH_SHORT).show()
        }) {

        Text(text = label)
    }
}

@Composable
fun UserCard(first: String, second: String) {
    Row (
        //modifier = Modifier.fillMaxWidth().background(Color.Yellow)  {// Ademas agregar un colorcito
        //modifier = Modifier.fillMaxSize().padding(16.dp)) {
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)) {
        Text(text = first, fontSize=32.sp)
        //Text(text = second)
    }
    Row (
        //modifier = Modifier.fillMaxWidth().background(Color.Yellow)  {// Ademas agregar un colorcito
        //modifier = Modifier.fillMaxSize().padding(16.dp)) {
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
        //Text(text = first)
        Text(text = second, fontSize=32.sp)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerProgramaTheme {
        Greeting("Android")
    }
}