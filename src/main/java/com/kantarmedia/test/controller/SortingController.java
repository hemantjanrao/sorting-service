package com.kantarmedia.test.controller;

import com.kantarmedia.test.domain.Order;
import com.kantarmedia.test.services.OrderService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SortingController {

    private OrderService orderService;

    @Autowired
    public void setProductService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/getsort")
    public String getAscendSort(Model model){
        model.addAttribute("sorting", new Order());
        return "sorting";
    }

    @PostMapping(value = "/sort")
    public String ascendSort(@PathVariable(value = "value", required = true) @NonNull Integer[] values, Model model){
        model.addAttribute("result", orderService.sort(values));
        return "result";
    }

    @PostMapping(value = "/reverse")
    public String reverseSort(@RequestParam(value = "value", required = true) @NonNull Integer[] values, Model model){
        model.addAttribute("reverse", orderService.reverse(values));
        return "reverse";
    }
}
