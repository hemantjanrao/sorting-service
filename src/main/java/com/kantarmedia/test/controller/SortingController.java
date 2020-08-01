package com.kantarmedia.test.controller;

import com.kantarmedia.test.services.OrderService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("value")
public class SortingController {

    private OrderService orderService;

    @Autowired
    public void setProductService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/sort")
    public String ascendSort(@RequestParam(value = "value", required = true) @NonNull Integer[] values, Model model){
        model.addAttribute("sort", orderService.sort(values));
        return "sorting";
    }
}
