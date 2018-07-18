package com.example.pairingWithPerry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/{x}/{y}/{z}")
    String volume(@PathVariable Integer x, @PathVariable Integer y, @PathVariable Integer z) {
        return String.valueOf(x * y * z);
    }

}
