package ubb.licenta.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.licenta.entity.Comment;

import ubb.licenta.repository.CommentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public Integer insert(Comment comment) {
        Comment savedEvent = commentRepository.save(comment);
        return savedEvent.getId();
    }

    public Comment findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            throw new EntityNotFoundException("Comentariul cu id = " + id + " nu a fost gasit!");
        }
        return comment.get();
    }

    public List<Comment> findCommentByEventName (String eventname) {
        return commentRepository.findCommentByEventName(eventname);
    }

    public Comment update(Comment comment) {
        Optional<Comment> oldComment = commentRepository.findById(comment.getId());

        if (oldComment.isEmpty()) {
            return null;
        }

        return commentRepository.save(comment);
    }


    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }


}



