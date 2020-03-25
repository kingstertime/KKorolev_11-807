package ru.kpfu.formsvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.formsvalidation.model.NewBook;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class JTwigController {

    @RequestMapping(method = RequestMethod.GET)
    public String jtwig2(ModelMap map) {
        List<NewBook> list = new ArrayList<>();
        NewBook book = new NewBook("ORG", "There my description");
        NewBook book1 = new NewBook("Twelewqwe", "There my second description");
        NewBook book2 = new NewBook("I'm so fffff", "Ha-ha-ha. My third description");
        list.add(book);
        list.add(book1);
        list.add(book2);
        map.put("books", list);
        return "test";
    }

}
