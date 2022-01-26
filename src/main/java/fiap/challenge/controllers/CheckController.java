package fiap.challenge.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CheckController {

    @RequestMapping(value = "status", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String CheckHealth() {
        return "online";
    }
    
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html#/");
    }
}
