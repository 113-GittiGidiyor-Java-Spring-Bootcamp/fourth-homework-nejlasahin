package spring.bootcamp.week4.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.bootcamp.week4.exceptions.*;
import spring.bootcamp.week4.model.ExceptionLogger;
import spring.bootcamp.week4.repository.ExceptionLoggerRepository;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ExceptionLoggerRepository exceptionLoggerRepository;

    public GlobalExceptionHandler(ExceptionLoggerRepository exceptionLoggerRepository) {
        this.exceptionLoggerRepository = exceptionLoggerRepository;
    }

    private ExceptionLogger prepareErrorResponse(HttpStatus httpStatus, String message){
        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setMessage(message);
        exceptionLogger.setStatus(httpStatus.value());
        exceptionLogger.setDate(LocalDate.now());
        return exceptionLogger;
    }

    @ExceptionHandler(CourseIsAlreadyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(CourseIsAlreadyException exception){
        ExceptionLogger exceptionLogger = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);
        return new ResponseEntity<>(exceptionLogger, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InstructorIsAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(InstructorIsAlreadyExistException exception){
        ExceptionLogger exceptionLogger = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);
        return new ResponseEntity<>(exceptionLogger, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionLogger> handleException(ResourceNotFoundException exception){
        ExceptionLogger exceptionLogger = prepareErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);
        return new ResponseEntity<>(exceptionLogger, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAgeNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(StudentAgeNotValidException exception){
        ExceptionLogger exceptionLogger = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);
        return new ResponseEntity<>(exceptionLogger, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNumberForOneCourseExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionLogger> handleException(StudentNumberForOneCourseExceededException exception){
        ExceptionLogger exceptionLogger = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        exceptionLoggerRepository.save(exceptionLogger);
        return new ResponseEntity<>(exceptionLogger, HttpStatus.BAD_REQUEST);
    }


}
