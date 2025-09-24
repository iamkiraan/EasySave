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
fun HomeScreen(){
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
            Box(
                modifier = Modifier.fillMaxWidth(.9f)
                    .height(320.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .verticalScroll(totalScrollable)
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

            Column(modifier = Modifier.fillMaxSize()
                .padding(bottom = 10.dp)
                .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                RecentLoans()
                RecentLoans()
                RecentLoans()
                RecentLoans()
                RecentLoans()
                RecentLoans()
                RecentLoans()
                RecentLoans()
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

//recent loans
@Preview(showBackground = true)
@Composable
fun RecentLoans() {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(80.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
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
                    text = "Today",
                    color = MaterialTheme.colorScheme.surfaceBright,
                    fontSize = 14.sp
                )
            }

            // Amount + status
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Rs.45,000",
                    color = MaterialTheme.colorScheme.surfaceDim,
                    fontSize = 18.sp
                )
                Text(
                    text = "Pending",
                    color = MaterialTheme.colorScheme.surfaceBright,
                    fontSize = 14.sp
                )
            }
        }
    }
}


