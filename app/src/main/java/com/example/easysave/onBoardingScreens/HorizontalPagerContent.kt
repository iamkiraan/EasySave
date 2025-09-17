package com.example.easysave.onBoardingScreens

import androidx.annotation.DrawableRes

data class HorizontalPagerContent(
    val title : String,
    @DrawableRes val res1 : Int,
    @DrawableRes val res2 : Int,
    val description : String
)
