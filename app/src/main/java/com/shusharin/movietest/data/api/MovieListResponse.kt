package com.shusharin.movietest.data.api

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("has_more")
    val has_more: Boolean,

    @SerializedName("num_results")
    val num_results: Int,

    @SerializedName("results")
    val results: List<MovieListItem>
)

data class MovieListItem(

    @SerializedName("display_title")
    val display_title: String,

    @SerializedName("mpaa_rating")
    val mpaa_rating: String,

    @SerializedName("critics_pick")
    val critics_pick: Int,

    @SerializedName("byline")
    val byline: String,

    @SerializedName("headline")
    val headline: String,

    @SerializedName("summary_short")
    val summary_short: String,

    @SerializedName("publication_date")
    val publication_date: String,

    @SerializedName("opening_date")
    val opening_date: String,

    @SerializedName("date_updated")
    val date_updated: String,

    @SerializedName("link")
    val link: LinkData,

    @SerializedName("multimedia")
    val multimedia: LinkMultimedia

)

data class LinkData(

    @SerializedName("type")
    val type: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("suggested_link_text")
    val suggested_link_text: String,

    )

data class LinkMultimedia(

    @SerializedName("type")
    val type: String,

    @SerializedName("src")
    val src: String,

    @SerializedName("height")
    val height: Int,

    @SerializedName("width")
    val width: Int
)
