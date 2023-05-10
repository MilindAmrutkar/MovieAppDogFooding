package com.example.movieappdogfooding

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@androidx.compose.runtime.Composable
fun Screen() {
    Column(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        MoviePoster()
    }
}

@Composable
fun MoviePoster(modifier: Modifier = Modifier) {
    Column(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://cdn.shopify.com/s/files/1/1057/4964/products/Joker-Vintage-Movie-Poster-Original-Bus-Stop-48x70_9824def5-900b-4d29-ae2d-0277316895a0.jpg?v=1668661284",
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .width(180.dp)
                .aspectRatio(.674f)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = "Joker",
            fontSize = 24.sp,
            color = Color.Black
        )

        Row {
            Chip("Action")
            Chip("Drama")
            Chip("History")
        }
    }
}

@Composable
fun Chip(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        color = Color.Gray,
        modifier = modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(50))
            .padding(horizontal = 16.dp, vertical = 2.dp),
        fontSize = 12.sp
    )
}