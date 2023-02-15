package edu.ownblog.server.services;

import edu.ownblog.server.controllers.posts.PostRequest;
import edu.ownblog.server.controllers.posts.PostResponse;
import edu.ownblog.server.exceptions.PostNotFoundException;
import edu.ownblog.server.model.Post;
import edu.ownblog.server.model.User;
import edu.ownblog.server.repositories.PostRepository;
import edu.ownblog.server.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.1
 */

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(PostRequest request, Principal principal) {
        User user = getUserByPrincipal(principal);
        Post post = Post.builder()
                .title(request.getTitle())
                .text(request.getText())
                .viewsCount(0)
                .author(user)
                .createdDate(LocalDateTime.now())
                .build();

        return postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAllByOrderByCreatedDateDesc().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public List<Post> getAllPostsByUser(Principal principal) {
        User user = getUserByPrincipal(principal);
        return postRepository.findAllByAuthorOrderByCreatedDateDesc(user);
    }


    public Post getPostById(Long postId) {
        Post post = postRepository.findPostById(postId)
                .orElseThrow(() -> new PostNotFoundException("The post with ID: " + postId + " doesn't exist"));

        return post;
    }

    public void dropPost(Long postId, Principal principal) {
        Post post = getPostById(postId);
        if (post.getAuthor() == getUserByPrincipal(principal)) {
            postRepository.delete(post);
        }
    }

    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }
}
