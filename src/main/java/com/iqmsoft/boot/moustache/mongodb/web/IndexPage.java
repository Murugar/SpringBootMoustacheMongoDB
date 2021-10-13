package com.iqmsoft.boot.moustache.mongodb.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iqmsoft.boot.moustache.mongodb.data.Profile;
import com.iqmsoft.boot.moustache.mongodb.data.ProfileRestRepository;

@Controller
@AllArgsConstructor
public class IndexPage {

	@Autowired 
    ProfileRestRepository profileRestRepository;

    @GetMapping("/")
    String index(final Model model) {

    	System.out.println(profileRestRepository.findAll());
        model.addAttribute(Profile.MODEL_LIST_NAME, profileRestRepository.findAll());
        return "index";
    }
}
