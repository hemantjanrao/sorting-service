package com.kantarmedia.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class SortingController {

    @GetMapping("/{order}")
    public Integer[] sort(@PathVariable String order, @RequestParam(value = "values") Integer[] values) {

        if (order.equalsIgnoreCase("sort"))
            Arrays.sort(values);

        if (order.equalsIgnoreCase("reverse"))
            Arrays.sort(values, Collections.reverseOrder());

        return values;
    }
}
