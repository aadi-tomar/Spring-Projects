package com.aadi.conduit.repositories;

import com.aadi.conduit.entities.ArticleEntity;
import com.aadi.conduit.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRespository extends JpaRepository<ArticleEntity, Long> {


}
