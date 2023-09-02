package group.goit.devmodule13.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public ModelAndView test() {
        ModelAndView test = new ModelAndView("test/test");
        test.addObject("test", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        return test;
    }
}
