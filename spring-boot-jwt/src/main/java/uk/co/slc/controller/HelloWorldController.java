package uk.co.slc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    @PreAuthorize("hasAuthority('HELLO')")
    public String firstPage() {
        return "Hello World";
    }
}