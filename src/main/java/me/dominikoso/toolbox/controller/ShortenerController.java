package me.dominikoso.toolbox.controller;

import me.dominikoso.toolbox.dto.UrlDto;
import me.dominikoso.toolbox.model.Url;
import me.dominikoso.toolbox.repository.UrlRepository;
import me.dominikoso.toolbox.tools.ShortenerTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/shortener")
public class ShortenerController {

    @Autowired
    UrlRepository urlRepository;
    @Autowired
    private HttpServletRequest request;

    ShortenerTools shortenerTools = ShortenerTools.INSTANCE;

    @RequestMapping(method = RequestMethod.GET)
    public List<Url> getUrls(){ return urlRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public Url createUrl(@RequestBody UrlDto orginalUrl){
        Url toSave = new Url();
        Long newId = 1L;
        if (urlRepository.findTopByOrderByIdDesc() != null){
            newId = urlRepository.findTopByOrderByIdDesc().getId()+1;
        }
        toSave.setOrginalUrl(orginalUrl.getOrginalUrl());
        toSave.setShortenedUrl(ShortenerTools.createUniqueID(newId));
        toSave.setOwner(request.getRemoteAddr());
        return urlRepository.save(toSave);
    }

}
