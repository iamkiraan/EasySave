package com.example.easysave.VerificationScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easysave.R
import com.example.easysave.onBoardingScreens.IntroScreen
import com.example.easysave.ui.theme.EasySaveTheme


@Composable
fun LoginScreen(){

    val name by remember { mutableStateOf("") }
    val email by remember{ mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier.fillMaxSize(.9f)
                .padding(top=30.dp, bottom = 180.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)

        ){

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "Fill  Up Your Details"
                )

                Column(
                    modifier = Modifier.fillMaxWidth(.9f)
                ){
                    Text(
                        text = "Profile Picture (optional)"
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .height(80.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(Color.White)
                    ){
                        Row(
                            modifier = Modifier.fillMaxSize()
                                .padding(start = 10.dp,end = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Image(
                                modifier = Modifier.size(50.dp),
                                painter = painterResource(R.drawable.person),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceContainer)
                            )

                            Column(){
                                Text(
                                    text = "Add a photo"
                                )

                                Text(
                                    text ="PNG of JPG up to 2MB",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }

                            Button(
                                onClick = {},
                              shape = RoundedCornerShape(40.dp),

                            ) {
                                Text(
                                    text = "Upload",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                        }


                    }


                    Column(){

                        Text(
                            text = "Name"
                        )
                        OutlinedTextField(
                            value = name,
                            onValueChange = {name == it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(Color.White),
                            leadingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.person),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Black)
                                )
                            },
                            placeholder = {
                                Text(
                                    "your name here",
                                    color = Color.Gray
                                )
                            }


                        )

                    }
                    
                    
                    //email
                    Column(){

                        Text(
                            text = "Email"
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = {email == it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(Color.White),
                            leadingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.person),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Black)
                                )
                            },
                            placeholder = {
                                Text(
                                    "your email  here",
                                    color = Color.Gray
                                )
                            }


                        )

                    }
                }

            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun showBackground(){
    EasySaveTheme(darkTheme = false, dynamicColor = false) {
        LoginScreen()


    }
}