package com.example.closedpullrequests.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.closedpullrequests.R
import com.example.closedpullrequests.model.PullRequest

class PullRequestAdapter(
    private val pullRequests: List<PullRequest>
) : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pull_request_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pullRequest = pullRequests[position]

        holder.titleTextView.text = pullRequest.title
        holder.createdAtTextView.text = pullRequest.createdAt
        holder.closedAtTextView.text = pullRequest.closedAt
        holder.userNameTextView.text = pullRequest.user.login

        Glide.with(holder.itemView)
            .load(pullRequest.user.avatarUrl)
            .into(holder.userImageView)
    }

    override fun getItemCount() = pullRequests.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val createdAtTextView = itemView.findViewById<TextView>(R.id.createdAtTextView)
        val closedAtTextView = itemView.findViewById<TextView>(R.id.closedAtTextView)
        val userNameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
        val userImageView = itemView.findViewById<ImageView>(R.id.userImageView)
    }

}