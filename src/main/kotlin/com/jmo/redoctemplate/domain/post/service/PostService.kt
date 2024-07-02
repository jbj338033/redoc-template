package com.jmo.redoctemplate.domain.post.service

import com.jmo.redoctemplate.domain.post.dto.request.PostCreateRequest
import com.jmo.redoctemplate.domain.post.dto.response.PostResponse

interface PostService {
    fun getPosts(): List<PostResponse>
    fun getPost(id: Long): PostResponse
    fun createPost(request: PostCreateRequest): PostResponse
    fun deletePost(id: Long)
    fun searchPost(keyword: String): List<PostResponse>
}