package com.example.movieappdogfooding

import android.view.View.OnClickListener
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.math.roundToInt


@androidx.compose.runtime.Composable
fun Screen() {
    var offset by remember { mutableStateOf(0f) }
    val ctrlr = rememberScrollableState {
        offset += it
        it
    }
    Row(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
            .scrollable(
                state = ctrlr,
                orientation = Orientation.Horizontal,
            )
    ) {
        Row(Modifier.offset(getX = { offset }, getY = { 0f })) {
            MoviePoster()
            MoviePoster()
            MoviePoster()
        }
    }
}

fun Modifier.offset(
    getX: () -> Float,
    getY: () -> Float,
    rtlAware: Boolean = true
) = this then object: LayoutModifier {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        return layout(placeable.width, placeable.height) {
            if (rtlAware) {
                placeable.placeRelative(getX().roundToInt(), getY().roundToInt())
            } else {
                placeable.place(getX().roundToInt(), getY().roundToInt())
            }
        }
    }

}

@Composable
fun MoviePoster(modifier: Modifier = Modifier) {
    val screenSize = LocalConfiguration.current.screenWidthDp.dp * .75f

    Column(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .width(screenSize)
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
        StarRating(9.0f)
        Spacer(modifier = Modifier.height(30.dp))
        BuyTicketButton(buttonClick = {

        })
    }
}

@Composable
fun BuyTicketButton(buttonClick: () -> Unit) {
    Button(
        onClick = buttonClick,
        elevation = ButtonDefaults.buttonElevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Buy Ticket", color = Color.White)
    }
}

@Composable
fun StarRating(rating: Float) {

}

@Composable
fun Chip(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 9.sp,
        color = Color.Gray,
        modifier = modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 2.dp),
    )
}