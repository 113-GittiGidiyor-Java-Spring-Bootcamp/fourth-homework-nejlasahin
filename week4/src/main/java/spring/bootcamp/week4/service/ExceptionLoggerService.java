package spring.bootcamp.week4.service;

import spring.bootcamp.week4.dto.ExceptionLoggerDto;
import spring.bootcamp.week4.model.ExceptionLogger;

import java.time.LocalDate;
import java.util.List;

public interface ExceptionLoggerService {
    List<ExceptionLoggerDto> getByCreatedDate(String date);

    List<ExceptionLoggerDto> findAll();

    List<ExceptionLoggerDto> getByStatusCode(int statusCode);

    List<ExceptionLoggerDto> getByExceptionMessage(String exceptionMessage);
}
