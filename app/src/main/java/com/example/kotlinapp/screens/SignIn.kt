package com.example.kotlinapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.R

@Composable
fun SignIn(onNavigateToSignUp: () -> Unit) {
    Surface(
        //color = MaterialTheme.colorScheme.background ,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
            //.requiredWidth(width = 390.dp)
            //.requiredHeight(height = 844.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bkg_sign_in),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
//                    .offset(x = (-16).dp, y = (-190).dp)
//                    .requiredWidth(width = 456.dp)
//                    .requiredHeight(height = 858.dp)
                    .fillMaxWidth()
                //.blur(radius = 4.dp,
                //     edgeTreatment = BlurredEdgeTreatment.Unbounded)
            )
            Column(
                //verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    // Falta editar para responsive
                    .align(alignment = Alignment.BottomCenter)
                    //.padding(10.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    //.offset(x = 0.dp, y = 465.dp)
                    .requiredWidth(width = 400.dp)
                    .requiredHeight(height = 400.dp)
                    //.wrapContentHeight(align = Alignment.CenterVertically)
                    .background(color = MaterialTheme.colorScheme.background)
            ) {

                RoundedTextField(
                    modifier = Modifier
                        .padding(20.dp),
                    //.requiredWidth(width = 320.dp)
                    //.requiredHeight(height = 50.dp),
                    hint = "Username",
                )
                RoundedTextField(
                    modifier = Modifier
                        .padding(15.dp),
                    //.requiredWidth(width = 320.dp)
                    //.requiredHeight(height = 50.dp),
                    hint = "Password",
                )
                TextButton(
                    onClick = {
//                        val request = LoginRequest(username, password)
//
//                        GlobalScope.launch(Dispatchers.IO) {
//                            try {
//                                val response = RetrofitInstance.api.login(request)
//                                if (response.isSuccessful) {
//                                    // La solicitud fue exitosa
//                                    // Por ejemplo, iniciar una nueva actividad
//                                    val nextActivity = Intent(this@SignInActivity, NextActivity::class.java)
//                                    startActivity(nextActivity)
//                                    // Opcional: finaliza la actividad actual para evitar que el
//                                    // usuario regrese presionando el botón de retroceso
//                                    //finish()
//
//                                } else {
//                                    // La solicitud no fue exitosa, maneja el error aquí
//
//                                }
//                            } catch (e: Exception) {
//                                // Ocurrió un error de red, maneja la excepción aquí
//
//                            }
//                        }
                    },
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(),
                    modifier = Modifier
                        .requiredWidth(width = 100.dp)
                    //.requiredHeight(height = 40.dp)
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            //.align(alignment = Alignment.Center)
                            //.offset(x = (-0.5).dp, y = 0.dp)
                            // Fill para responsive
                            //.requiredWidth(width = 86.dp)
                            //.requiredHeight(height = 38.dp)
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
                    //.requiredWidth(width = 183.dp)
                    //.requiredHeight(height = 46.dp)
                    onClick = { onNavigateToSignUp() }
                )
            }
            Image(
                painter = painterResource(id = R.drawable.logo_base),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.Center)
                    //.offset(x = 0.dp, y = (-75).dp)
                    //.requiredWidth(width = 150.dp)
                    .requiredHeight(height = 180.dp)
            )
        }
    }
}

@Composable
fun RoundedTextField(modifier: Modifier = Modifier, hint: String) {
    TextField(
        value = "",//username,
        onValueChange = { /*username = it*/ },
        shape = RoundedCornerShape(25.dp),
        label = {
            Text(
                text = hint,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 15.sp
                ),
                modifier = Modifier,
                //.requiredHeight(height = 50.dp)
            )
        },
        modifier = modifier, // Meter responsive aqui
    )
}