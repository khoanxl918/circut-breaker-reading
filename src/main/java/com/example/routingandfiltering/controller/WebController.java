package com.example.routingandfiltering.controller;

import com.example.routingandfiltering.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    BookService bookService;

    @RequestMapping("/to-read")
    public String toRead() {
        return bookService.readingList();
    }
}
