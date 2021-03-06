package kr.co.redbrush.webapp.controller.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/*
// TODO : Uncomment @Controller if you want to use custom ErrorController
@Controller
*/
@Slf4j
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(ModelMap model, HttpServletRequest request) {
        model.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        model.put("exceptionType", request.getAttribute("javax.servlet.error.exception_type"));
        model.put("message", request.getAttribute("javax.servlet.error.message"));
        model.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));
        model.put("exception", request.getAttribute("javax.servlet.error.exception"));
        model.put("servletName", request.getAttribute("javax.servlet.error.servlet_name"));

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
