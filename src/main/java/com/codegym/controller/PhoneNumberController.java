package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneNumberController {
    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView checkValidation(@Validated @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/index");
        } else {
            modelAndView = new ModelAndView("/result");
            modelAndView.addObject("phoneNumber", phoneNumber);
        }
        return modelAndView;
    }
}
