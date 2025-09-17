package com.example.easysave.onBoardingScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.easysave.R
import com.example.easysave.ui.theme.EasySaveTheme
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.launch
import kotlin.math.sin


@Composable
fun IntroScreen(){
    val list = getContent()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = {list.size}
    )

    val isNextVisible = remember {
        derivedStateOf {
            pagerState.currentPage!=list.size-1
        }
    }
    val isBackVisible = remember {
        derivedStateOf {
            pagerState.currentPage!=0
        }
    }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(WindowInsets.statusBars.asPaddingValues())
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(120.dp))


        Box(
            modifier = Modifier.fillMaxWidth(.9f)
                .height(350.dp)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer),
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,


                ) {page ->


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth(.8f)
                        .padding(top = 20.dp)
                        .height(150.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .border(2.dp, MaterialTheme.colorScheme.outline),
                    contentAlignment = Alignment.Center

                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(list[page].res1),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Fit
                            )
                        }
                        Spacer(modifier = Modifier.width(20.dp))




                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(list[page].res2),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(30.dp),
                                contentScale = ContentScale.Fit
                            )
                        }

                    }

                }


                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = list[page].title,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 20.sp
                )


                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 20.dp, end = 20.dp),
                    text = list[page].description,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )


                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = 3,
                    modifier = Modifier.padding(16.dp),
                    indicatorWidth = 10.dp,
                    indicatorHeight = 10.dp,
                    spacing = 8.dp,


                    )
            }


            }
        }


        Row(
            modifier = Modifier.fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            if(isBackVisible.value){

                Button(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage-1)
                        }
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_24),
                            contentDescription = null
                        )
                        Text("Back")
                    }
                }

            }

            if(isNextVisible.value){
                Button(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage+1)
                        }
                    },
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Next",
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(R.drawable.outline_arrow_right_alt_24),
                            contentDescription = null,
                            tint = Color.White
                        )

                    }
                }
            }



        }

    }




}

@Preview
@Composable
 fun ShowPreview() {

     EasySaveTheme(darkTheme = false, dynamicColor = false) {
         IntroScreen()

     }



}