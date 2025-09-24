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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
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
    Scaffold (
        topBar = {EasySaveTopBar("DashBoard")},

        ){ innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(80.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ){

                Row(
                    modifier = Modifier
                      .fillMaxSize()
                    .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically){
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

                    // Name + date
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Kiran Acharya",
                            color = MaterialTheme.colorScheme.surfaceDim,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "kishoracharya844@gmail.com",
                            color = MaterialTheme.colorScheme.surfaceBright,
                            fontSize = 14.sp
                        )
                    }
                }

            }









        }

    }


}


