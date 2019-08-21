package me.dominikoso.toolbox.controller;

import me.dominikoso.toolbox.repository.UrlRepository;
import me.dominikoso.toolbox.tools.DeveloperResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/")
    public String generateHome(Model model) {
        DeveloperResource[] devResources = {
                new DeveloperResource("Home", "/"),
                new DeveloperResource("My Github", "https://github.com/dominikoso")
        };
        model.addAttribute("resources", devResources);
        model.addAttribute("links", urlRepository.findAllByOwner(request.getRemoteAddr()));
        return "home";
    }
}
