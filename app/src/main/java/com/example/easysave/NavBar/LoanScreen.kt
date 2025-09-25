package com.example.easysave.NavBar

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import com.example.easysave.R

@Preview(showBackground = true)
@Composable
fun LoanScreen(){

    var searchText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Scaffold (
        topBar = {EasySaveTopBar("Loans")}
    )
    {innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            //search bar
            SearchBar(
                query = searchText,
                onQueryChanged = { searchText = it },
                onSearchClicked = {
                    println("Searching for $searchText")
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                ReuseableButtons(
                    leadingIcons = R.drawable.tune,
                    text = "Filter",
                    trailingIcons = R.drawable.outline_keyboard_arrow_down_24,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(5.dp))

                ReuseableButtons(
                    leadingIcons = R.drawable.swap_vert_24px,
                    text = "Sort: Date",
                    trailingIcons = R.drawable.outline_keyboard_arrow_down_24,
                    modifier = Modifier.weight(1f)
                )

            }

            //next row
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                ReuseableButtons(
                    leadingIcons = R.drawable.person,
                    text = "Borrower",
                    trailingIcons = null,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(5.dp))

                ReuseableButtons(
                    leadingIcons = R.drawable.calender,
                    text = "Date",
                    trailingIcons = null,
                    modifier = Modifier.weight(1f)
                )

            }

            //final row

            //next row
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                ReuseableButtons(
                    leadingIcons = R.drawable.outline_money_24,
                    text = "Amount",
                    trailingIcons = null,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(5.dp))

                ReuseableButtons(
                    leadingIcons = R.drawable.verified_24px,
                    text = "Status",
                    trailingIcons = null,
                    modifier = Modifier.weight(1f)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Recent Loans",
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

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearchClicked: () -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth(.9f)
        ,
        placeholder = { Text("Search loans, borrowers") },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search"
                )
            }
        },
        colors = TextFieldDefaults.colors(
          focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            unfocusedContainerColor =MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = RoundedCornerShape(15.dp)
    )
}

//outline button

    @Composable
    fun ReuseableButtons(
        leadingIcons : Int? = null,
        text : String,
        trailingIcons : Int? = null,
        modifier : Modifier = Modifier

    ){
        OutlinedButton(
            onClick = {},
            modifier = modifier
                .size(35.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colorScheme.surfaceContainer
            ),
            elevation = ButtonDefaults.elevation(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                if (leadingIcons != null) {
                    Image(
                        painter = painterResource(leadingIcons),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                    )
                }

                    Text(
                        text = text,
                        color = MaterialTheme.colorScheme.surfaceDim,
                        fontSize = 12.sp,

                        )



                Spacer(modifier = Modifier.weight(1f))
                if (trailingIcons != null) {
                    Image(
                        painter =painterResource(trailingIcons),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceDim)
                    )
                }
            }
        }



    }

