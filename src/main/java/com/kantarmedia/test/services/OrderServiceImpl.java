package com.kantarmedia.test.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Integer[] sort(Integer[] arr) {
        Arrays.sort(arr);

        return arr;
    }

    @Override
    public Integer[] reverse(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());

        return arr;
    }
}
