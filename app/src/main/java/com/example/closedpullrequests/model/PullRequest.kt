package com.example.closedpullrequests.model

data class PullRequest(
    val title: String,
    val createdAt: String,
    val closedAt: String,
    val user: User
)

data class User(
    val login: String,
    val avatarUrl: String
)
