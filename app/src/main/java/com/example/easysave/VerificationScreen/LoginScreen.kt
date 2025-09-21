package com.example.easysave.VerificationScreen

import android.net.Uri
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.easysave.R
import com.example.easysave.onBoardingScreens.IntroScreen
import com.example.easysave.ui.theme.EasySaveTheme


@Composable
fun LoginScreen(){

    var selectImageUri by remember { mutableStateOf<Uri?>(null) }

    var name by remember { mutableStateOf("") }
    var email by remember{ mutableStateOf("") }

    //launcher to pick image from gallery
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {uri : Uri? ->
        selectImageUri = uri

    }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color.White,MaterialTheme.colorScheme.primary)
                )
            ),
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

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(.9f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
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
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .background(Color.White)
                                .padding(horizontal = 10.dp)
                        ) {

                            if (selectImageUri != null) {
                                Image(
                                    painter = rememberAsyncImagePainter(selectImageUri),
                                    contentDescription = "Profile Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                )
                            } else {
                                Image(
                                    painter = painterResource(R.drawable.person),
                                    contentDescription = "Default Image",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape),
                                    colorFilter = ColorFilter.tint(Color.Gray)
                                )
                            }

                            Column {
                                Text(text = "Add a photo")
                                Text(text = "PNG or JPG up to 2MB", fontSize = 12.sp, color = Color.Gray)
                            }

                            Button(
                                onClick = { launcher.launch("image/*") },
                                shape = RoundedCornerShape(40.dp)
                            ) {
                                Text(text = "Upload", fontSize = 12.sp)
                            }
                        }


                    }


                    Column(){

                        Text(
                            text = "Name"
                        )
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(15.dp),
                            leadingIcon = {
                                Image(
                                    painter = painterResource(R.drawable.person),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(Color.Black)
                                )
                            },
                            placeholder = { Text("your name here", color = Color.Gray) },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,   // background when focused
                                unfocusedContainerColor = Color.White, // background when not focused
                                disabledContainerColor = Color.LightGray,
                                errorContainerColor = Color.White,
                                focusedIndicatorColor = MaterialTheme.colorScheme.primary,   // border color when focused
                                unfocusedIndicatorColor = Color.Gray,  // border color when not focused
                                disabledIndicatorColor = Color.LightGray,
                                errorIndicatorColor = Color.Red
                            )
                        )


                    }
                    
                    
                    //email
                    Column(){

                        Text(
                            text = "Email"
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = {email = it},
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(15.dp),
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
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,   // background when focused
                                unfocusedContainerColor = Color.White, // background when not focused
                                disabledContainerColor = Color.LightGray,
                                errorContainerColor = Color.White,
                                focusedIndicatorColor = MaterialTheme.colorScheme.primary,   // border color when focused
                                unfocusedIndicatorColor = Color.Gray,  // border color when not focused
                                disabledIndicatorColor = Color.LightGray,
                                errorIndicatorColor = Color.Red
                            )


                        )

                    }
                }

                Spacer(
                    modifier = Modifier.height(80.dp)
                )

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(.9f)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.primary),


                ){

                    Text(
                        text = "Sign Up",
                        color = Color.White
                    )

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