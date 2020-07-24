package com.kantarmedia.test;

import com.kantarmedia.test.response.SortResponse;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class SortingController {

    @GetMapping("/{order}")
    public SortResponse sort(@PathVariable String order, @RequestParam(value = "values") @NonNull Integer[] values) throws Exception {

        if (values.length == 0)
            throw new Exception();

        switch (order) {
            case "sort":
                Arrays.sort(values);
                break;

            case "reverse":
                Arrays.sort(values, Collections.reverseOrder());
                break;

            default:
                throw new Exception();
        }

        return new SortResponse(values);
    }
}
