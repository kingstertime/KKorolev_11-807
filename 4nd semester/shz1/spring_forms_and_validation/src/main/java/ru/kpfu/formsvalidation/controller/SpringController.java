package ru.kpfu.formsvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.formsvalidation.captcha.CaptchaGenerator;
import ru.kpfu.formsvalidation.model.Author;
import ru.kpfu.formsvalidation.model.AuthorValidator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/spring")
public class SpringController {

  @Autowired
  private CaptchaGenerator captchaGenerator;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(new AuthorValidator());// Task: NPE
  }

  @RequestMapping(value = "/new_author", method = RequestMethod.GET)
  public String newAuthor(ModelMap map) {
    map.put("author", new Author());
    return "author_form";
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String captcha() {
    captchaGenerator.drawRandomCharacters();
    captchaGenerator.save();
    return "index";
  }

  @RequestMapping(value = "/image", method = RequestMethod.GET)
  public @ResponseBody byte[] getImage(HttpServletRequest request) throws IOException {
    return captchaGenerator.getImage();
  }


  @RequestMapping(value = "/new_author", method = RequestMethod.POST)
  public String springHandler(
    RedirectAttributes redirectAttributes,
    @Validated @ModelAttribute("author") Author author,
    BindingResult result,
    ModelMap map
  ) {
    if (result.hasErrors()) {
      return "author_form";
    } else {
      redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Author \"" + author.getName() + "\" has been added successfully</span>");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#newAuthor").build();
    }

  }
}
