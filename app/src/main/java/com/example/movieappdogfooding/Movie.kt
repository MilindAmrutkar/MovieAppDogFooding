package com.example.movieappdogfooding

data class Movie(
    val title: String,
    val posterUrl: String,
    val bgUrl: String,
    val chips: List<String>
)

val movies = listOf(
    Movie(
        title = "Good Boys",
        posterUrl = "https://m.media-amazon.com/images/M/MV5BMTc1NjIzODAxMF5BMl5BanBnXkFtZTgwMTgzNzk1NzM@._V1_.jpg",
        bgUrl = "https://m.media-amazon.com/images/M/MV5BMTc1NjIzODAxMF5BMl5BanBnXkFtZTgwMTgzNzk1NzM@._V1_.jpg",
        chips = listOf("Action", "Drama", "History"),
    ),
    Movie(
        title = "Joker",
        posterUrl = "https://i.etsystatic.com/15963200/r/il/25182b/2045311689/il_794xN.2045311689_7m2o.jpg",
        bgUrl = "https://images-na.ssl-images-amazon.com/images/I/61gtGlalRvL._AC_SY741_.jpg",
        chips = listOf("Action", "Drama", "History"),
    ),
    Movie(
        title = "The Hustle",
        posterUrl = "https://m.media-amazon.com/images/M/MV5BMTc3MDcyNzE5N15BMl5BanBnXkFtZTgwNzE2MDE0NzM@._V1_.jpg",
        bgUrl = "https://m.media-amazon.com/images/M/MV5BMTc3MDcyNzE5N15BMl5BanBnXkFtZTgwNzE2MDE0NzM@._V1_.jpg",
        chips = listOf("Action", "Drama", "History"),
    )
)
