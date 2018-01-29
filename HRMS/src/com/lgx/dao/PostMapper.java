package com.lgx.dao;

import com.lgx.model.Post;

import java.util.List;

public interface PostMapper {
    List<Post> selectPost();
    boolean addPost(Post post);
    List<Post> selectPostByDid(int did);
}
