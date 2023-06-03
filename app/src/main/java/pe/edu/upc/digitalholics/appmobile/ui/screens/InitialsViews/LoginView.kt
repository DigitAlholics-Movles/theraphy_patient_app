package pe.edu.upc.digitalholics.appmobile.ui.screens.InitialsViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.upc.digitalholics.appmobile.R
import pe.edu.upc.digitalholics.appmobile.data.model.User
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(users: List<User>, navController: NavController) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.branding),
                contentDescription = "Logo",
                modifier = Modifier.size(250.dp)
            )

            Text(
                text = "Login",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, end = 12.dp)
            )

            Spacer(modifier = Modifier.padding(top = 15.dp))

            val email = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }
            val passwordVisibility = remember { mutableStateOf(false) }
            val errorState = remember { mutableStateOf(false) }

            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                        Icon(
                            painter = painterResource(if (passwordVisibility.value) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                            contentDescription = if (passwordVisibility.value) "Show Password" else "Hide Password"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Forgot Password?",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(29, 35, 102, 500)
                    ),
                    modifier = Modifier.clickable {
                        // Lógica al hacer clic en el texto
                    }
                )
            }

            Button(
                onClick = {
                    if (email.value.isEmpty() || password.value.isEmpty()) {
                        errorState.value = true
                    } else {
                        users.forEach{
                            if(email.value == it.email && password.value==it.password && it.type.lowercase()=="patient"){
                                navController.navigate("HomePatient/${it.id}")
                            }
                        }
                    }
                     },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Login")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(modifier = Modifier.weight(1f), color = Color.Black)
                Text(
                    text = "OR",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Divider(modifier = Modifier.weight(1f), color = Color.Black)
            }

            Spacer(modifier = Modifier.padding(top = 15.dp))

            Button(
                onClick = { /* Acción al hacer clic en "Login with Google" */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Login with Google")
            }

            val text = AnnotatedString("New to Theraphy? ") + buildAnnotatedString {
                pushStringAnnotation("URL", "new_in_therapy")
                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                    append(" Register")
                }
                pop()
            }

            ClickableText(
                text = text,
                onClick = {  navController.navigate("SignUPView") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

        }
    }
}