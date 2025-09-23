package com.example.easysave.NavBar

import android.annotation.SuppressLint
import android.graphics.Paint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun HomeScreen(){
    val navController = rememberNavController()
    Scaffold (
        topBar = {EasySaveTopBar()},

    ){ innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)

            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.fillMaxWidth(.9f)
                    .height(320.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(top = 10.dp, bottom = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TotalCalculation(
                        R.drawable.wallet,
                        "Total Money Lent",
                        "12,45,000",
                        "Updated just now"
                    )

                    TotalCalculation(
                        R.drawable.wallet,
                        "Total Money Lent",
                        "12,45,000",
                        "Updated just now"
                    )

                    TotalCalculation(
                        R.drawable.wallet,
                        "Total Money Lent",
                        "12,45,000",
                        "Updated just now"
                    )

                    TotalCalculation(
                        R.drawable.wallet,
                        "Total Money Lent",
                        "12,45,000",
                        "Updated just now"
                    )
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Recent Loans",
                    color = MaterialTheme.colorScheme.surfaceDim

                )

                Text(
                    text = "View All",
                    color = MaterialTheme.colorScheme.surfaceDim

                    )

            }


        }

    }


}


//total

@Composable
fun TotalCalculation(
    image: Int,
    title : String,
    amount : String,
    time : String
){
    Box(
        modifier = Modifier.fillMaxWidth(.9f)
            .height(60.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surface)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
           // horizontalArrangement = Arrangement.SpaceBetween
            verticalAlignment = Alignment.CenterVertically

        ) {

            Box(
                modifier = Modifier.padding(8.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,

                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                )
            }

            //row wala
            Column(
                modifier = Modifier.fillMaxHeight(),
               // horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ){
                Text(
                    text =title,
                    color = MaterialTheme.colorScheme.surfaceBright,
                    fontSize = 14.sp
                )

                Text(
                    text = "Rs.$amount",
                    color = MaterialTheme.colorScheme.surfaceDim
                )

            }

            //update kati khera vayeko ho vanne kuraw
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = time,
                color = MaterialTheme.colorScheme.surfaceDim,
                fontSize = 12.sp
            )
        }


    }

}
