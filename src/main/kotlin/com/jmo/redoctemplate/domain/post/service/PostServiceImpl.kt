package com.jmo.redoctemplate.domain.post.service

import com.jmo.redoctemplate.domain.post.domain.Post
import com.jmo.redoctemplate.domain.post.dto.request.PostCreateRequest
import com.jmo.redoctemplate.domain.post.dto.response.PostResponse
import com.jmo.redoctemplate.domain.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {
    @Transactional(readOnly = true)
    override fun getPosts(): List<PostResponse> {
        return postRepository.findAll().map { PostResponse.of(it) }
    }

    @Transactional(readOnly = true)
    override fun getPost(id: Long): PostResponse {
        val post = postRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Post not found")

        return PostResponse.of(post)
    }

    @Transactional
    override fun createPost(request: PostCreateRequest): PostResponse {
        var post = Post(
            title = request.title,
            content = request.content
        )

        post = postRepository.save(post)

        return PostResponse.of(post)
    }

    @Transactional
    override fun deletePost(id: Long) {
        postRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    override fun searchPost(keyword: String): List<PostResponse> {
        return postRepository.findAllByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword)
            .map { PostResponse.of(it) }
    }
}