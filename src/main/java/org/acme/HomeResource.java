package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.ResourcePath;
import org.acme.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Stan
 */
@Controller
@Path("/home")
public class HomeResource {


    /**
     * <p>
     * If there is no @ResourcePath qualifier provided, the field name is used to locate the template
     * In this particular case, we’re injecting a template with path templates/hello.txt.
     * </p>
     */
    @ResourcePath("haha.txt")
    @Inject
    Template hello;

    /**
     * 方法注解信息给你了
     *
     * @return model and view
     */
    @Path(value = "/test")
    @GetMapping("test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GET
    @Path("test2")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {
        Item item = new Item();
        item.name = name;
        BigDecimal price = item.price;
        TemplateInstance data = hello.data("name", item.name);
        data.data("home", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return data;
    }
}
