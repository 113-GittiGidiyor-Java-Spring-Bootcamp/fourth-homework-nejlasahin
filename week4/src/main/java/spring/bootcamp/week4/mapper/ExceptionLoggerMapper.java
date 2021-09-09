package spring.bootcamp.week4.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import spring.bootcamp.week4.dto.CourseDto;
import spring.bootcamp.week4.dto.ExceptionLoggerDto;
import spring.bootcamp.week4.model.Course;
import spring.bootcamp.week4.model.ExceptionLogger;

import java.util.List;

@Mapper
public interface ExceptionLoggerMapper {
    ExceptionLogger mapFromExceptionLoggerDtoToExceptionLogger(ExceptionLoggerDto exceptionLoggerDto);

    @Named("mapFromExceptionLoggerToExceptionLoggerDto")
    ExceptionLoggerDto mapFromExceptionLoggerToExceptionLoggerDto(ExceptionLogger exceptionLogger);

    @IterableMapping(qualifiedByName = "mapFromExceptionLoggerToExceptionLoggerDto")
    List<ExceptionLoggerDto> mapFromExceptionLoggersToExceptionLoggerDto(List<ExceptionLogger> exceptionLoggers);
}
