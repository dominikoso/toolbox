package me.dominikoso.toolbox.controller;

import me.dominikoso.toolbox.repository.UrlRepository;
import me.dominikoso.toolbox.tools.DeveloperResource;
import me.dominikoso.toolbox.tools.ShortenerTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        //TODO dynamic link generation
        model.addAttribute("links", "http://localhost:8080/s/" + urlRepository.findAllByOwner(request.getRemoteAddr()));
        return "home";
    }

    //TODO Secure checking is domain exist and add 404 template
    @RequestMapping(value = "/s/{shortenedUrl}")
    public ModelAndView redirectUrl(@PathVariable String shortenedUrl){
        String projectUrl = urlRepository.findById(ShortenerTools.getDictionaryKeyFromUniqueID(shortenedUrl)).get().getOrginalUrl();
        System.out.println("Redirected to: "+ projectUrl);
        return new ModelAndView("redirect:" + projectUrl);
    }
}
