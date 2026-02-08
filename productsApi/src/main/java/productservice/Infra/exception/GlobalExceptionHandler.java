package productservice.Infra.exception;

import clientservice.Client.exception.ClientException;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import productservice.Auth.exception.AuthException;
import productservice.Product.exception.ProductException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Atributos
    private Logger logger = LoggerFactory.getLogger(clientservice.Infra.exception.GlobalExceptionHandler.class);

    // Handlers
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ProblemDetail> handleHttpRequestMethodNotSupportedException(HttpServletRequest httpRequest) throws URISyntaxException {
        logger.warn("Erro ao processar a requisião, método HTTP não suportado: " + httpRequest.getRequestURI());

        URI type = new URI("http://localhost:8080/errors/method-not-allowed");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Método HTTP não suportado");
        problemDetail.setDetail("O método http " + httpRequest.getMethod() + " não é suportado no caminho " + httpRequest.getRequestURI());
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ProblemDetail> handleAuthException(AuthException e, HttpServletRequest httpRequest) throws URISyntaxException {
        logger.warn("Erro ao processar a requisião, falha na autenticação");

        URI type = new URI("http://localhost:8080/errors/authentication");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.FORBIDDEN;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Regra de autenticação violada");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setInstance(instance);;

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ProblemDetail> handleClientException(ClientException e, HttpServletRequest request) throws URISyntaxException {
        logger.warn("Erro ao processar a requisião, regra de negocio em Client violada");

        URI type = new URI("http://localhost:8080/errors/client-exception");
        URI instance = new URI(request.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Regras de negócio violadas");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setInstance(instance);;

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ProblemDetail> handleProductException(ProductException e, HttpServletRequest request) throws URISyntaxException {
        logger.warn("Erro ao processar a requisião, regra de negocio em Product violada");

        URI type = new URI("http://localhost:8080/errors/product-exception");
        URI instance = new URI(request.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Regras de negócio violadas");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setInstance(instance);;

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception e, HttpServletRequest httpRequest) throws URISyntaxException {
        logger.error("Excecao inesperada: " + e);

        URI type = new URI("http://localhost:8080/errors/generic-exception");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Generic exception");
        problemDetail.setTitle("Exceção genérica");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handleHttpMessageNotReadableException (HttpServletRequest httpRequest) throws URISyntaxException {
        logger.error("Erro ao processar a requisião, body inválido");

        URI type = new URI("http://localhost:8080/errors/invalid-body");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Requisição inválida");
        problemDetail.setDetail("A requisição deve conter o body corretamente preenchido");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException (MethodArgumentNotValidException e, HttpServletRequest httpRequest) throws URISyntaxException {
        logger.error("Erro ao processar a requisião, campos violados");

        URI type = new URI("http://localhost:8080/errors/invalid-output");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        BindingResult result = e.getBindingResult();
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : result.getFieldErrors()) {
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
    public ResponseEntity<ProblemDetail> handleFeignException(FeignException e, HttpServletRequest httpRequest) {
        logger.warn("Ocorreu um erro ao se comunicar com um sistema externo: " + e.request().url() + " " + e.getMessage());

        URI type = URI.create("http://localhost:8081/errors/external-server");
        URI instance = URI.create(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Erro ao se comunicar com sistema externo");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    // Handlers
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ProblemDetail> handleNoResourceFoundException(HttpServletRequest httpRequest) throws URISyntaxException {
        logger.warn("Erro durante o processamento da requisição, recurso não encontrado");

        URI type = new URI("http://localhost:8081/errors/resource-not-found");
        URI instance = new URI(httpRequest.getRequestURI());
        HttpStatus status = HttpStatus.NOT_FOUND;

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(type);
        problemDetail.setTitle("Recurso não encontrado");
        problemDetail.setInstance(instance);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }
}
