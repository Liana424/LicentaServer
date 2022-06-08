package ubb.licenta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

    @Query(value = "SELECT c FROM Comment c WHERE c.event.name=:eventname")
    List<Comment> findCommentByEventName(String eventname);


}
