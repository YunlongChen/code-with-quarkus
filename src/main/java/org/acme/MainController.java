package org.acme;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.*;

/**
 * @author Stan
 */
@Controller
@Path("/home")
public class MainController {
    @Path("/test")
    @GET
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
