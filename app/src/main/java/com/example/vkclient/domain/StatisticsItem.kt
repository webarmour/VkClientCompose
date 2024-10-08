package com.example.vkclient.domain

data class StatisticsItem(
    val type: StatisticType,
    val count: Int = 0
)

enum class StatisticType{
    VIEWS, COMMENT, SHARES, LIKES
}