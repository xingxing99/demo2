package com.lgx.service;

import com.lgx.model.Post;

import java.util.List;

public interface PostService {
    List<Post> selectPostByDid(int did);
    List<Post> selectPost();
    boolean deletePostByDid(int did);
    boolean addPost(Post post);
    boolean deletePostById(int id);
}
