package com.kantarmedia.test.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer[] value;

    public Order(Integer[] value) {
        this.value = value;
    }
}