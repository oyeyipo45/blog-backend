package com.blog.backend.service.impl;

import com.blog.backend.dtos.PostDto;
import com.blog.backend.entity.Post;
import com.blog.backend.repository.PostRepository;
import com.blog.backend.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    final private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

       Post newPost =  postRepository.save(post);

       PostDto response = new PostDto();
        response.setId(newPost.getId());
        response.setTitle(newPost.getTitle());
        response.setContent(newPost.getContent());
        response.setDescription(newPost.getDescription());

       return response;
    }
}
