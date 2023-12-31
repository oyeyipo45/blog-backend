package com.blog.backend.service;

import com.blog.backend.dtos.PostDto;
import com.blog.backend.entity.Post;

import java.util.List;

public interface PostService {
    PostDto createPost (PostDto postDto);

    List<Post> getAllPosts ();

    Post getPostById (Long id);
}
