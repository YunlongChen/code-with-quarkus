package org.acme;

import org.acme.mapper.UserMapper;
import org.acme.service.TestService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RestController
@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    UserMapper userMapper;
    @Inject
    TestService testService;

    public GreetingResource(TestService testService) {
        this.testService = new TestService();
    }

    @Secured("admin")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return testService.testMethod();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        System.out.println("this is home");
        return "this is home" + userMapper.getUser(1);
    }
}