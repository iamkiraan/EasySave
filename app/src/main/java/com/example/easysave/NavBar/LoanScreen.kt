package com.example.easysave.NavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easysave.R

@Preview(showBackground = true)
@Composable
fun LoanScreen(){

    var searchText by remember { mutableStateOf("") }
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
            .fillMaxWidth()
            .padding(8.dp),
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
