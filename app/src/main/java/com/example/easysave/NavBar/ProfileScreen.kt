package com.example.easysave.NavBar

import android.annotation.SuppressLint
import android.graphics.Paint
import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.easysave.R
import kotlin.math.sign


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun ProfileScreen(){
    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    val totalScrollable = rememberScrollState()

    var isChecked by remember { mutableStateOf(false) }
    Scaffold (
        topBar = {EasySaveTopBar("DashBoard")},

        ){ innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            Spacer(modifier = Modifier.height(20.dp))
            Column(){
                Text(
                    text = "User Info",
                    color = MaterialTheme.colorScheme.surfaceDim
                )
                Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 10.dp, bottom = 10.dp),
                    //.height(80.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Circle with icon
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.person),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))


                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Kiran Acharya",
                            color = MaterialTheme.colorScheme.surfaceDim,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "kishoracharya844@gmail.com",
                            color = MaterialTheme.colorScheme.surfaceBright,
                            fontSize = 12.sp
                        )
                    }

                    OutlinedActionButton("Change")

                }
            }


            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier.fillMaxWidth(.9f)
            ){

                Text(
                    text = "Appearance",
                    color = MaterialTheme.colorScheme.surfaceDim
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                       // .height(120.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),

                    ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.outline_light_mode_24),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                        )
                        Column(){
                            Text(
                                text = "App Theme",
                                color = MaterialTheme.colorScheme.surfaceDim
                            )
                            Text(
                                text = "Choos Light or Dark mode",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.surfaceBright
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.outline
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp
                            )
                        ) {

                            Text(
                                text = "Light",
                                fontSize = 12.sp
                            )
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.surfaceDim
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp
                            )
                        ) {
                            Text (
                                text = "Dark",
                                fontSize = 12.sp
                            )
                        }




                    }



                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(.9f)
            ) {

                Text(
                    text = "Notifications",
                    color = MaterialTheme.colorScheme.surfaceDim
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),

                    ){

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ){

                        Image(
                            painter = painterResource(R.drawable.bell),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(-5.dp)
                        ){
                            Text(
                                text = "Reminders",
                                color = MaterialTheme.colorScheme.surfaceDim
                            )
                            Text(
                                text = "Due dates and repayment updates",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.surfaceBright
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Switch(
                            checked = isChecked,
                            onCheckedChange = {isChecked = it},
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.outline,
                                checkedTrackColor = MaterialTheme.colorScheme.primary,
                                uncheckedThumbColor = MaterialTheme.colorScheme.primary,
                                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceBright
                            )
                        )



                    }

                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier.fillMaxWidth(.9f)
            ){

                Text(
                    text = "Data",
                    color = MaterialTheme.colorScheme.surfaceDim
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    // .height(120.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),

                    ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.outline_download_24),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                        )
                        Column(){
                            Text(
                                text = "Backup & Export",
                                color = MaterialTheme.colorScheme.surfaceDim
                            )
                            Text(
                                text = "Save your data offline",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.surfaceBright
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.surfaceDim
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp
                            )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.outline_file_export_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim),
                                    modifier = Modifier.size(18.dp)
                                )

                                Text(
                                    text = "Export PDF",
                                    fontSize = 12.sp
                                )
                            }
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.surfaceDim
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp
                            )
                        ) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ){
                                Image(
                                    painter = painterResource(R.drawable.outline_file_export_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim),
                                    modifier = Modifier.size(18.dp)
                                )

                                Text (
                                    text = "Export Excel",
                                    fontSize = 12.sp
                                )

                            }

                        }




                    }



                }

            }












            }

    }


}



@Composable
fun OutlinedActionButton(text: String) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Color(0xFF000000)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        modifier = Modifier
          //  .weight(1f)
            .padding(horizontal = 4.dp)
            .height(35.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically

        ){

            Image(
                painter = painterResource(R.drawable.camera),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
            )

            Text(text = text, fontSize = 12.sp)

        }

    }
}


