package com.iqmsoft.boot.moustache.mongodb.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iqmsoft.boot.moustache.mongodb.data.Profile;
import com.iqmsoft.boot.moustache.mongodb.data.ProfileRestRepository;

@Controller
@RequiredArgsConstructor
public class IndexPage {

    final ProfileRestRepository profileRestRepository;

    @GetMapping("/")
    String index(final Model model) {

        model.addAttribute(Profile.MODEL_LIST_NAME, profileRestRepository.findAll());
        return "index";
    }
}
