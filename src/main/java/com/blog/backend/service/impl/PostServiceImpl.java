package com.blog.backend.service.impl;

import com.blog.backend.dtos.PostDto;
import com.blog.backend.entity.Post;
import com.blog.backend.repository.PostRepository;
import com.blog.backend.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    final private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapPostDtoToEntity(postDto);
        Post newPost = postRepository.save(post);

        PostDto response = mapEntityToDto(newPost);
        return response;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post getPostById(Long id) {
        Post post = postRepository.getOne(id);
        return post;
    }


    private PostDto mapEntityToDto(Post post){
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }


    private Post mapPostDtoToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }

}
