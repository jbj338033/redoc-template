package com.jmo.redoctemplate.domain.post.dto.response

import com.jmo.redoctemplate.domain.post.domain.Post

data class PostResponse(
    val id: Long,
    val title: String,
    val content: String
) {
    companion object {
        fun of(post: Post) = PostResponse(
            id = post.id!!,
            title = post.title,
            content = post.content
        )
    }
}