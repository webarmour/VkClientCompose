package com.example.vkclient.domain

import com.example.vkclient.R

data class FeedPost(
    val id: Int = 0,
    val publicName: String = "blank",
    val publicationDate: String = "14:00",
    val imageId: Int = R.drawable.post_comunity_thumbnail,
    val postText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticsItem> = listOf(
        StatisticsItem(type = StatisticType.VIEWS, 966),
        StatisticsItem(type = StatisticType.SHARES, 7),
        StatisticsItem(type = StatisticType.COMMENT, 8),
        StatisticsItem(type = StatisticType.LIKES, 27)
    )

)