package me.kakutalua.website.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import xyz.downgoon.snowflake.Snowflake
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    companion object {
        private val ID_GENERATOR = Snowflake(0,0)
    }

    @Id
    val id: Long = ID_GENERATOR.nextId()

    @Column(name = "creation_date", nullable = false)
    @CreatedDate
    val creationDate: OffsetDateTime = OffsetDateTime.now()

    @Column(name = "last_modified_date")
    @LastModifiedDate
    var lastModifiedDate: OffsetDateTime = OffsetDateTime.now()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}