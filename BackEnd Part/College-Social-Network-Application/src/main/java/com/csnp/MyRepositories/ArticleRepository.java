package com.csnp.MyRepositories;
 
import com.csnp.Enum.Status;
import com.csnp.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import java.util.List;
import java.util.Optional;
 
@Repository
public interface ArticleRepository  extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a WHERE a.status = :status")
    List<Article> findAllByStatus(Status status);

//	@Query("SELECT a FROM Article a WHERE a.status = :status")
//    List<Article> findAllByStatus(@Param("status") Status status);
}