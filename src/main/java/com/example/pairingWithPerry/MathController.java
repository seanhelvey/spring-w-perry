package com.example.pairingWithPerry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MathController {

    @GetMapping("/{x}/{y}/{z}")
    public String volume(@PathVariable Integer x, @PathVariable Integer y, @PathVariable Integer z) {
        return String.valueOf(x * y * z);
    }

    @GetMapping("/math/sum")
    public Object sum(@RequestParam Map queryString) {
        int sum = 0;
        for (Object value : queryString.values()) {
            sum += Integer.valueOf((String) value);
        }
        return sum;
    }

    @GetMapping("/tasks")
    public String getTasks(TaskInfo taskInfo) {
        return String.format("sort-by is %s; owner is %s", taskInfo.getSortBy(), taskInfo.getOwner());
    }

}
