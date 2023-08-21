package jd.movietracker.errors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ErrorService {
    private int errorCode;
    private String errorType;

    public void parseRequest(HttpServletRequest request) {
        errorCode = Integer.parseInt(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString());
        errorType = HttpStatus.resolve(errorCode).toString();
    }
}
