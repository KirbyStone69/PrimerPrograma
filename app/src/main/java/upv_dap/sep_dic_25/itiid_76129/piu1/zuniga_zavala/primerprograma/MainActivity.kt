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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerProgramaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Eder",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                MyScreen()
            }
        }
    }
}

class Counter {
    var count by mutableStateOf(0)
        private set

    fun increment() {
        count++
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen() {
    val counter = remember { Counter() }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My App") })
        },
        bottomBar = {
            BottomAppBar {
                Text("Bottom Bar")
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            FloatingActionButton(onClick = { /* Handle click */
                val sum: (Int, Int) -> Int = { a, b -> a + b }
                Toast.makeText(context,"Evento de Click Sobre boton floante: "+sum(5,7)+ "clicks"+counter.count,Toast.LENGTH_SHORT).show()
                counter.increment()
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            // Main content goes here
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("Hello from the content!")
                Greeting(name = "Android")
                MyTextFieldUI()
            }
        }
    )
}

// Demo 6
@Composable
fun MyTextFieldUI() {
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
            label = { Text(text = "Enter your text") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(), // Equivalente a match_parent en el XML
            onClick = { /* Handle button click */
                Toast.makeText(context,"Dato ingresado por USER en el TextField: "+text,Toast.LENGTH_SHORT).show()
                text="" //Borar el TextField
            }) {
            Text(text = "Irse ALV")
        }

        // Displaying the text entered by the user
        Text(text = "You entered: $text")

        //Greeting("Android")
        FancyButton("Mejor instalar windows")
        UserCard("Eder","Omar")

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
        Text(text = first, fontSize = 32.sp)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
        Text(text = second, fontSize = 50.sp)
    }
}
class Lista {

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerProgramaTheme {
        Greeting("Android")
    }
}