package spring.bootcamp.week4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.bootcamp.week4.dto.ExceptionLoggerDto;
import spring.bootcamp.week4.model.ExceptionLogger;
import spring.bootcamp.week4.service.ExceptionLoggerService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/exceptions")
public class ExceptionLoggerController {
    private final ExceptionLoggerService exceptionLoggerService;

    @Autowired
    public ExceptionLoggerController(ExceptionLoggerService exceptionLoggerService) {
        this.exceptionLoggerService = exceptionLoggerService;
    }

    @GetMapping(value = "/getByDate/{date}")
    public ResponseEntity<List<ExceptionLoggerDto>> getByDate(@PathVariable String date){
        List<ExceptionLoggerDto> exceptionLoggers = exceptionLoggerService.getByCreatedDate(date);
        return new ResponseEntity<>(exceptionLoggers, HttpStatus.OK);
    }

    @GetMapping(value = "/getByStatusCode/{statusCode}")
    public ResponseEntity<List<ExceptionLoggerDto>> getByStatusCode(@PathVariable int statusCode){
        List<ExceptionLoggerDto> exceptionLoggers = exceptionLoggerService.getByStatusCode(statusCode);
        return new ResponseEntity<>(exceptionLoggers, HttpStatus.OK);
    }

    @GetMapping(value = "/getByExceptionMessage/{exceptionMessage}")
    public ResponseEntity<List<ExceptionLoggerDto>> getByExceptionMessage(@PathVariable String exceptionMessage){
        List<ExceptionLoggerDto> exceptionLoggers = exceptionLoggerService.getByExceptionMessage(exceptionMessage);
        return new ResponseEntity<>(exceptionLoggers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExceptionLoggerDto>> findAll(){
        List<ExceptionLoggerDto> exceptionLoggers = exceptionLoggerService.findAll();
        return new ResponseEntity<>(exceptionLoggers, HttpStatus.OK);
    }
}
