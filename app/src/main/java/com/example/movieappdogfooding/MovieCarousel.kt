package com.example.movieappdogfooding

import android.view.View.OnClickListener
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlin.math.roundToInt


val posterAspectRatio = 0.674f

@androidx.compose.runtime.Composable
fun Screen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    var offset by remember { mutableStateOf(0f) }
    val ctrlr = rememberScrollableState {
        offset += it
        it
    }
    Box(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
            .scrollable(
                state = ctrlr,
                orientation = Orientation.Horizontal,
            )
    ) {
        movies.forEachIndexed { index, movie ->
            AsyncImage(
                model = movie.bgUrl, contentDescription = "", modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(posterAspectRatio)
            )
        }

        Spacer(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        ),
                        startY = 0f,
                        endY = 100f
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        )

        movies.forEachIndexed { index, movie ->
            MoviePoster(
                movie = movie,
                modifier = Modifier
                    .offset(getX = { offset.dp + (screenWidth * index) }, getY = { 0.dp })
                    .width(screenWidth * .75f)

            )
        }
    }
}

fun Modifier.offset(
    getX: () -> Dp,
    getY: () -> Dp,
    rtlAware: Boolean = true
) = this then object : LayoutModifier {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        return layout(placeable.width, placeable.height) {
            if (rtlAware) {
                placeable.placeRelative(getX().roundToPx(), getY().roundToPx())
            } else {
                placeable.place(getX().roundToPx(), getY().roundToPx())
            }
        }
    }

}

@Composable
fun MoviePoster(movie: Movie, modifier: Modifier = Modifier) {

    Column(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(20.dp)
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(posterAspectRatio)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = movie.title,
            fontSize = 24.sp,
            color = Color.Black
        )

        Row {
            for (chip in movie.chips) {
                Chip(chip)
            }
        }
        StarRating(9.0f)
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