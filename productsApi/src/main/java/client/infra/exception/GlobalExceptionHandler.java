package client.infra.exception;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(HttpServletRequest httpRequest) throws URISyntaxException {
        URI type = new URI("http://localhost:8080/generic-exception");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Generic exception");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handleHttpMessageNotReadableException(HttpServletRequest httpRequest) throws URISyntaxException {
        URI type = new URI("http://localhost:8080/errors/empty-body");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Requisição inválida");
        problemDetail.setDetail("A requisição deve conter o body corretamento preenchido");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValiException(MethodArgumentNotValidException e, HttpServletRequest httpRequest) throws URISyntaxException {
        URI type = new URI("http://localhost:8080/errors/invalid-output");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        BindingResult result = e.getBindingResult();
        List<String> errors = new ArrayList<>();
        for(FieldError fieldError : result.getFieldErrors()) {
            errors.add("campo: " + fieldError.getField() + " | mensagem: " + fieldError.getDefaultMessage());
        }

        ProblemDetail response = ProblemDetail.forStatus(status);
        response.setType(type);
        response.setTitle("Requisição inválida");
        response.setDetail("A requisição contém campos inválidos ou obrigatórios ausentes");
        response.setProperty("erros", errors);
        response.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(response);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException e) {

        return ResponseEntity
                .status(e.status())
                .body(e.contentUTF8());
    }
}
