package me.kakutalua.website.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "blog_posts")
class BlogPost(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "subtitle")
    var subtitle: String?,

    @Column(name = "content", nullable = false)
    var content: String
) : BaseEntity()