package me.kakutalua.website.infrastructure.repositories

import me.kakutalua.website.domain.BlogPost
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogPostsRepository : PagingAndSortingRepository<BlogPost, Long>, JpaSpecificationExecutor<BlogPost>
