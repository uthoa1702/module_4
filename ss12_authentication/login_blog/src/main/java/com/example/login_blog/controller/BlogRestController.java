package com.example.login_blog.controller;

import com.example.login_blog.model.Blog;
import com.example.login_blog.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping ("")
    public ResponseEntity<Page<Blog>> getBlogList(@PageableDefault(size = 2) Pageable pageable) {

//            Pageable pageable = PageRequest.of(p.orElse(0),2);
        Page<Blog> page = blogService.findPage(pageable);


        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchPost(@RequestParam("title") String title) {

        List<Blog> list = blogService.getListOfObjectFromDbBasedOnQuery("%"+title+"%");

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/loadMore")
    public ResponseEntity<Slice<Blog>> loadMore(@RequestParam("page")Integer page){
        return new ResponseEntity<>(blogService.findAllBlogBySlice(page), HttpStatus.OK);
    }
}
