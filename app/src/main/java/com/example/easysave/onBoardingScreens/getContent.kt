package com.example.easysave.onBoardingScreens

import androidx.compose.runtime.Composable
import com.example.easysave.R

@Composable
fun getContent():List<HorizontalPagerContent>{
    return listOf(
        HorizontalPagerContent(
            "Track Loans Effortlessly",
            R.drawable.wallet,
            R.drawable.list,
            "Add loans in seconds , see balances and due dates in one tidy place"
        ),
        HorizontalPagerContent(
            "Never Miss a Payment",
            R.drawable.bell,
            R.drawable.calender,
            "Smart remainders keep you schedule with gentle nudges"
        ),

        HorizontalPagerContent(
            "Visualize Your Progress",
            R.drawable.chart,
            R.drawable.monitor,
            "Clear charts and trends help you make better saving decisions"
        )

    )
}