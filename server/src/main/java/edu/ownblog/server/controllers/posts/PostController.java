package edu.ownblog.server.controllers.posts;

import edu.ownblog.server.controllers.MessageResponse;
import edu.ownblog.server.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request, Principal principal) {
        return ResponseEntity.ok(new PostResponse(postService.createPost(request, principal)));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId, Principal principal) {
        return ResponseEntity.ok(new PostResponse(postService.getPostById(postId, principal)));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<MessageResponse> deletePost(@PathVariable("postId") Long postId, Principal principal) {
        postService.dropPost(postId, principal);
        return ResponseEntity.ok(new MessageResponse("Post was deleted"));
    }
}
