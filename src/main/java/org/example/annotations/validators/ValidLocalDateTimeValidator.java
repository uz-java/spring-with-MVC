package org.example.annotations.validators;

import org.example.annotations.ValidLocalDateTime;
import org.example.util.Utils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Clock;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:45 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
public class ValidLocalDateTimeValidator implements ConstraintValidator<ValidLocalDateTime, String> {
    private String message;

    @Override
    public void initialize(ValidLocalDateTime constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (Utils.isParsable(value)) {
            LocalDateTime localDateTime = Utils.toLocalDateTime(value);
            return !localDateTime.isBefore(LocalDateTime.now(Clock.systemDefaultZone()));
        }
        return StringUtils.hasText(value);
    }
}
