package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caller")
public class CallerController {

    private final Client client;

    public CallerController(Client client) {
        this.client = client;
    }

    @GetMapping("/{id}")
    public String getI(@PathVariable("id") Long id) {
        return "Caller " + id + " for : " + client.getResponse(1L);
    }
}
