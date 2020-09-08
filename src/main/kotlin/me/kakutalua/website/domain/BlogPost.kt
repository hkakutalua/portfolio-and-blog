package me.kakutalua.website.domain

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "blog_posts")
open class BlogPost(
    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "subtitle")
    var subtitle: String?,

    @Column(name = "content", nullable = false)
    var content: String
) : BaseEntity() {
    @Column(name = "publishing_status", nullable = false)
    @Enumerated(EnumType.STRING)
    var publishingStatus = PublishingStatus.DRAFT
        set(value) {
            field = value
            publishingDate = OffsetDateTime.now()
        }

    @Column(name = "publishing_date")
    var publishingDate: OffsetDateTime? = null
        private set
}