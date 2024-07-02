package com.jmo.redoctemplate.domain.post.domain

import com.jmo.redoctemplate.global.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "posts")
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", nullable = false)
    val content: String
) : BaseEntity()