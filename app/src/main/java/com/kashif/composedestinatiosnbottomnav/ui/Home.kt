package com.kashif.composedestinatiosnbottomnav.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kashif.composedestinatiosnbottomnav.R
import com.kashif.composedestinatiosnbottomnav.ui.destinations.HomeDetailsDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun Home(destinationsNavigator: DestinationsNavigator) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home")

        Button(onClick = { destinationsNavigator.navigate(HomeDetailsDestination) }) {
            Text(text = stringResource(R.string.go_to_details))
        }
    }
}