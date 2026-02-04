package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class ResponderController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id) {
        System.out.println("Received");
        return "patient-" + id;
    }
}
