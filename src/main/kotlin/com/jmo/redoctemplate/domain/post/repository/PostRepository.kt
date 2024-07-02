package com.jmo.redoctemplate.domain.post.repository

import com.jmo.redoctemplate.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(title: String, content: String): List<Post>
}