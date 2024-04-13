package com.example.kotlinapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.R
import com.example.kotlinapp.view.components.RoundedTextField
import com.example.kotlinapp.viewmodel.AuthViewModel

@Composable
fun SignIn(
    authViewModel: AuthViewModel,
    onNavigateToSignUp: () -> Unit
) {
    Surface {
        SignInBody(authViewModel, onNavigateToSignUp)
    }
}

@Composable
fun SignInBody(
    authViewModel: AuthViewModel,
    onNavigateToSignUp: () -> Unit
) {
    val authState by authViewModel.authState.collectAsState()
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    when (authState) {
        is AuthViewModel.AuthState.Loading -> {
            // Muestra un indicador de carga
            CircularProgressIndicator()
        }
        is AuthViewModel.AuthState.Success -> {
            // La autenticación fue exitosa, puedes navegar a la siguiente pantalla
            // Por ejemplo:
            // onSignInSuccess(authState.user)
        }
        is AuthViewModel.AuthState.Error -> {
            // Hubo un error durante la autenticación, muestra un mensaje de error
            // Por ejemplo:
            // showErrorDialog(authState.message)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bkg_sign_in),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(50.dp))
                .requiredHeight(height = 490.dp)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            RoundedTextField(
                hint = "Username",
                value = username,
                onValueChange = { username = it },
            )
            RoundedTextField(
                hint = "Password",
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
            )
            TextButton(
                onClick = { authViewModel.signInUser(username, password) },
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .requiredWidth(width = 100.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
            ClickableText(
                text = AnnotatedString("¿Aún no tienes cuenta?\n¡Regístrate!"),
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(10.dp),
                onClick = { onNavigateToSignUp() }
            )
        }
    }
    Image(
        painter = painterResource(id = R.drawable.logo_base),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .requiredHeight(height = 180.dp)
            .padding(bottom = 30.dp)
    )
}

//@Preview(widthDp = 390, heightDp = 844)
//@Composable
//fun SignInPreview() {
//    KotlinAppTheme {
//        SignIn {  }
//    }
//}
