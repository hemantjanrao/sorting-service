package com.kantarmedia.test.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortResponse {
    private Integer[] value;

    public SortResponse(Integer[] value) {
        this.value = value;
    }
}
