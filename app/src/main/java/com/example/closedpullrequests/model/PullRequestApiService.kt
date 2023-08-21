package com.example.closedpullrequests.model

import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestApiService {

    @GET("/repos/{owner}/{repo}/pulls")
    suspend fun getClosedPullRequests(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<PullRequest>

}