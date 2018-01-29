package com.lgx.service.impl;

import com.lgx.dao.PostMapper;
import com.lgx.model.Post;
import com.lgx.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;

    @Override
    public List<Post> selectPostByDid(int did) {
        return postMapper.selectPostByDid(did);
    }

    @Override
    public List<Post> selectPost() {
        return postMapper.selectPost();
    }
}
