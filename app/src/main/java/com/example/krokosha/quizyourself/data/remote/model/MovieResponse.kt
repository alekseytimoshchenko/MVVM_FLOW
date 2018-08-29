package com.example.krokosha.quizyourself.data.remote.model

import com.squareup.moshi.Json

data class MovieResponse(@Json(name ="page")  var page: Int = 0, //
                         @Json(name ="total_pages")  var totalPages: Int = 0)