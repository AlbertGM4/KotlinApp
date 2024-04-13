package com.example.kotlinapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.R
import com.example.kotlinapp.components.RoundedTextField
import com.example.kotlinapp.ui.theme.KotlinAppTheme

@Composable
fun SignUp(
    onNavigateToSignIn: () -> Unit
) {
    Scaffold(
        topBar = { SignUpTopBar() },
        containerColor = MaterialTheme.colorScheme.background
    )
    { innerPadding ->
        SignUpBody(onNavigateToSignIn, innerPadding)
    }
}

@Composable
fun SignUpTopBar() {
    Column(
        modifier = Modifier
//            .background(MaterialTheme.colorScheme.background)
            .padding(top = 25.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.logo_base
            ),
            contentDescription = "",
            modifier = Modifier
                .aspectRatio(10f / 3f)

        )
        Text(
            text = "Nuevo usuario",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 35.sp
            ),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth(),
        )
    }
}

@Composable
fun SignUpBody(
    onNavigateToSignIn: () -> Unit,
    innerPadding: PaddingValues,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }


    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(innerPadding)
            .clip(shape = RoundedCornerShape(50.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(top = 10.dp)
            .fillMaxWidth(),
    ) {
        item {
            RoundedTextField(
                hint = "Correo electronico",
                value = email,
                onValueChange = { email = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Contraseña",
                value = password,
                onValueChange = { password = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Nombre de Usuario",
                value = username,
                onValueChange = { username = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Nombre",
                value = name,
                onValueChange = { name = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Apellido",
                value = surname,
                onValueChange = { surname = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Movil",
                value = mobile,
                onValueChange = { mobile = it },
            )
        }
        item {
            RoundedTextField(
                hint = "Sobre ti",
                value = about,
                onValueChange = { about = it },
            )
        }
        item {
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
                    .padding(top = 20.dp)
                    .requiredWidth(width = 200.dp)
            ) {
                Text(
                    text = "Registrarse",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
            ClickableText(
                text = AnnotatedString("¿Ya tienes cuenta?\n¡Login!"),
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .padding(10.dp),
                onClick = { onNavigateToSignIn() }
            )
        }
    }
}


@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun SignUpPreview() {
    KotlinAppTheme {
        SignUp { }
    }
}

// BUENO
//Box(
////        modifier = modifier
////            .requiredWidth(width = 390.dp)
////            .requiredHeight(height = 844.dp)
////            .background(color = Color(0xfff2eee9))
//) {
//    Box(
//        modifier = Modifier
//            .align(alignment = Alignment.TopStart)
//            .offset(
//                x = 29.dp,
//                y = 60.dp
//            )
//            .requiredWidth(width = 320.dp)
//            .requiredHeight(height = 188.dp)
//    ) {
//        Text(
//            text = "Nuevo usuario",
//            color = Color.Black,
//            textAlign = TextAlign.Center,
//            style = TextStyle(
//                fontSize = 35.sp
//            ),
//            modifier = Modifier
//                .align(alignment = Alignment.Center)
//                .offset(
//                    x = 0.dp,
//                    y = 50.499996185302734.dp
//                )
//                .requiredWidth(width = 320.dp)
//                .requiredHeight(height = 87.dp)
//                .wrapContentHeight(align = Alignment.CenterVertically)
//        )
//        Image(
//            painter = painterResource(id = R.drawable.su_profile_picture_placeholder),
//            contentDescription = "SU_ProfilePicturePlaceholder",
//            modifier = Modifier
//                .align(alignment = Alignment.Center)
//                .offset(
//                    x = (-0.4396247863769531).dp,
//                    y = (-32.907413482666016).dp
//                )
//                .requiredWidth(width = 95.dp)
//                .requiredHeight(height = 123.dp)
//                .clip(shape = RoundedCornerShape(20.dp))
//        )
//    }
//    Box(
//        modifier = Modifier
//            .align(alignment = Alignment.Center)
//            .offset(
//                x = 0.dp,
//                y = 124.dp
//            )
//            .requiredWidth(width = 390.dp)
//            .requiredHeight(height = 596.dp)
//    ) {
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .requiredWidth(width = 390.dp)
//                .clip(shape = RoundedCornerShape(50.dp))
//                .background(color = Color(0xfffcf8f3))
//                .padding(all = 30.dp)
//        ) {
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 0.dp
//                            )
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 1.dp
//                            )
//                            .requiredWidth(width = 280.dp)
//                            .requiredHeight(height = 30.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 0.dp
//                            )
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = (-0.0000057220458984375).dp,
//                                y = 3.dp
//                            )
//                            .requiredWidth(width = 279.dp)
//                            .requiredHeight(height = 30.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 0.dp
//                            )
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.CenterStart)
//                            .offset(
//                                x = 20.43613624572754.dp,
//                                y = 0.5.dp
//                            )
//                            .requiredWidth(width = 172.dp)
//                            .requiredHeight(height = 27.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = (-53.33333396911621).dp,
//                                y = 0.5.dp
//                            )
//                            .requiredWidth(width = 172.dp)
//                            .requiredHeight(height = 27.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.TopStart)
//                            .offset(
//                                x = 20.43613624572754.dp,
//                                y = 12.dp
//                            )
//                            .requiredWidth(width = 172.dp)
//                            .requiredHeight(height = 27.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 50.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 50.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.TopStart)
//                            .offset(
//                                x = 20.43613624572754.dp,
//                                y = 12.dp
//                            )
//                            .requiredWidth(width = 172.dp)
//                            .requiredHeight(height = 27.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 320.dp)
//                        .requiredHeight(height = 100.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .requiredWidth(width = 320.dp)
//                            .requiredHeight(height = 100.dp)
//                            .clip(shape = RoundedCornerShape(15.dp))
//                            .background(color = Color(0xffd9d9d9))
//                    )
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        colors = TextFieldDefaults.colors(),
//                        modifier = Modifier
//                            .align(alignment = Alignment.TopCenter)
//                            .offset(
//                                x = (-0.0000019073486328125).dp,
//                                y = 12.dp
//                            )
//                            .requiredWidth(width = 269.dp)
//                            .requiredHeight(height = 74.dp)
//                    )
//                }
//            }
//            item {
//                Box(
//                    modifier = Modifier
//                        .requiredWidth(width = 163.dp)
//                        .requiredHeight(height = 37.dp)
//                ) {
//                    Button(
//                        onClick = { },
//                        shape = RoundedCornerShape(15.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xffd4c281)
//                        ),
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 0.dp
//                            )
//                            .requiredWidth(width = 163.dp)
//                            .requiredHeight(height = 37.dp)
//                    ) { }
//                    Button(
//                        onClick = { },
//                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(
//                                x = 0.dp,
//                                y = 0.dp
//                            )
//                            .requiredWidth(width = 158.dp)
//                            .requiredHeight(height = 37.dp)
//                            .wrapContentHeight(align = Alignment.CenterVertically)
//                    ) { }
//                }
//            }
//        }
//    }
//}
