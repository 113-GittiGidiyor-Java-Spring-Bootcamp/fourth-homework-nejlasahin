package spring.bootcamp.week4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bootcamp.week4.dto.ExceptionLoggerDto;
import spring.bootcamp.week4.mapper.ExceptionLoggerMapper;
import spring.bootcamp.week4.model.ExceptionLogger;
import spring.bootcamp.week4.repository.ExceptionLoggerRepository;
import spring.bootcamp.week4.service.ExceptionLoggerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExceptionLoggerServiceImpl implements ExceptionLoggerService {
    private final ExceptionLoggerRepository exceptionLoggerRepository;
    private final ExceptionLoggerMapper exceptionLoggerMapper;

    @Override
    public List<ExceptionLoggerDto> getByCreatedDate(String date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
        LocalDate resultDate = LocalDate.parse(date, formatter);
        List<ExceptionLogger> exceptionLoggers = exceptionLoggerRepository.getByCreatedDate(resultDate);
        return exceptionLoggerMapper.mapFromExceptionLoggersToExceptionLoggerDto(exceptionLoggers);
    }

    @Override
    public List<ExceptionLoggerDto> findAll() {
        List<ExceptionLogger> exceptionLoggers = exceptionLoggerRepository.findAll();
        return exceptionLoggerMapper.mapFromExceptionLoggersToExceptionLoggerDto(exceptionLoggers);
    }

    @Override
    public List<ExceptionLoggerDto> getByStatusCode(int statusCode) {
        List<ExceptionLogger> exceptionLoggers = exceptionLoggerRepository.getByStatusCode(statusCode);
        return exceptionLoggerMapper.mapFromExceptionLoggersToExceptionLoggerDto(exceptionLoggers);
    }

    @Override
    public List<ExceptionLoggerDto> getByExceptionMessage(String exceptionMessage) {
        List<ExceptionLogger> exceptionLoggers = exceptionLoggerRepository.getByExceptionMessage(exceptionMessage);
        return exceptionLoggerMapper.mapFromExceptionLoggersToExceptionLoggerDto(exceptionLoggers);
    }
}
