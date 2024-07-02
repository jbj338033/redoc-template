package com.jmo.redoctemplate.domain.post.controller

import com.jmo.redoctemplate.domain.post.dto.request.PostCreateRequest
import com.jmo.redoctemplate.domain.post.service.PostService
import com.jmo.redoctemplate.global.common.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "게시글", description = "Post")
@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {
    @Operation(summary = "게시글 목록 조회")
    @GetMapping
    fun getPosts() = BaseResponse(postService.getPosts(), 200).entity

    @Operation(summary = "게시글 상세 조회")
    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: Long) = BaseResponse(postService.getPost(postId), 200).entity

    @Operation(summary = "게시글 생성")
    @PostMapping
    fun createPost(@RequestBody request: PostCreateRequest) = BaseResponse(postService.createPost(request), 201).entity

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{postId}")
    fun deletePost(@PathVariable postId: Long) = BaseResponse(postService.deletePost(postId), 204).entity

    @Operation(summary = "게시글 검색")
    @GetMapping("/search")
    fun searchPost(@RequestParam keyword: String) = BaseResponse(postService.searchPost(keyword), 200).entity
}