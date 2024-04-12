package com.example.kotlinapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinapp.R


@Composable
fun SignUp(){
    Box(
//        modifier = modifier
//            .requiredWidth(width = 390.dp)
//            .requiredHeight(height = 844.dp)
//            .background(color = Color(0xfff2eee9))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 29.dp,
                    y = 60.dp
                )
                .requiredWidth(width = 320.dp)
                .requiredHeight(height = 188.dp)
        ) {
            Text(
                text = "Nuevo usuario",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 35.sp
                ),
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(
                        x = 0.dp,
                        y = 50.499996185302734.dp
                    )
                    .requiredWidth(width = 320.dp)
                    .requiredHeight(height = 87.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.su_profile_picture_placeholder),
                contentDescription = "SU_ProfilePicturePlaceholder",
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(
                        x = (-0.4396247863769531).dp,
                        y = (-32.907413482666016).dp
                    )
                    .requiredWidth(width = 95.dp)
                    .requiredHeight(height = 123.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
            )
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .offset(
                    x = 0.dp,
                    y = 124.dp
                )
                .requiredWidth(width = 390.dp)
                .requiredHeight(height = 596.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .requiredWidth(width = 390.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(color = Color(0xfffcf8f3))
                    .padding(all = 30.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 1.dp
                                )
                                .requiredWidth(width = 280.dp)
                                .requiredHeight(height = 30.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = (-0.0000057220458984375).dp,
                                    y = 3.dp
                                )
                                .requiredWidth(width = 279.dp)
                                .requiredHeight(height = 30.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .offset(
                                    x = 20.43613624572754.dp,
                                    y = 0.5.dp
                                )
                                .requiredWidth(width = 172.dp)
                                .requiredHeight(height = 27.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = (-53.33333396911621).dp,
                                    y = 0.5.dp
                                )
                                .requiredWidth(width = 172.dp)
                                .requiredHeight(height = 27.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 20.43613624572754.dp,
                                    y = 12.dp
                                )
                                .requiredWidth(width = 172.dp)
                                .requiredHeight(height = 27.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 20.43613624572754.dp,
                                    y = 12.dp
                                )
                                .requiredWidth(width = 172.dp)
                                .requiredHeight(height = 27.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 320.dp)
                            .requiredHeight(height = 100.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 320.dp)
                                .requiredHeight(height = 100.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = Color(0xffd9d9d9))
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            colors = TextFieldDefaults.colors(),
                            modifier = Modifier
                                .align(alignment = Alignment.TopCenter)
                                .offset(
                                    x = (-0.0000019073486328125).dp,
                                    y = 12.dp
                                )
                                .requiredWidth(width = 269.dp)
                                .requiredHeight(height = 74.dp)
                        )
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 163.dp)
                            .requiredHeight(height = 37.dp)
                    ) {
                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xffd4c281)
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 163.dp)
                                .requiredHeight(height = 37.dp)
                        ) { }
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 158.dp)
                                .requiredHeight(height = 37.dp)
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        ) { }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun SignUpPreview() {
    SignUp()
}