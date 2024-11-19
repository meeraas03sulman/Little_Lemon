import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.Routes

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Image"
        )
        TextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage = "" // Clear error message when user starts typing
            },
            label = { Text(text = "Username") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = "" // Clear error message when user starts typing
            },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }
        Button(
            onClick = {
                if (username == "admin" && password == "ad123") {
                    navController.navigate(Routes.HomeScreen)
                } else {
                    errorMessage = "Invalid username or password"
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF495E57))
        ) {
            Text(
                text = "Login",
                color = Color(0XFFEDEFEE)
            )
        }
    }
}

/*
@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
*/
