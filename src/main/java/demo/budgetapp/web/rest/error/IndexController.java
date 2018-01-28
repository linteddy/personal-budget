package demo.budgetapp.web.rest.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping(PATH)
    @ResponseBody
    public String error() {
        return "index";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
