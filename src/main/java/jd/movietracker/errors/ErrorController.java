package jd.movietracker.errors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @Autowired
    private ErrorService service;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        service.parseRequest(request);
        model.addAttribute("error_code", service.getErrorCode());
        model.addAttribute("error_type", service.getErrorType());
        return "error";
    }
}
