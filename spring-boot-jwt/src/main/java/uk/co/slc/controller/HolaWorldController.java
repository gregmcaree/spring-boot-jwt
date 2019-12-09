package uk.co.slc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaWorldController {
    @RequestMapping({ "/hola" })
    @PreAuthorize("hasAuthority('ROLE_HOLA')")
    public String firstPage() {
        return "Hola World";
    }
}