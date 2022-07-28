package org.example.annotations;

import org.example.annotations.validators.ValidLocalDateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:44 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Documented
@Constraint(validatedBy = {ValidLocalDateTimeValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface ValidLocalDateTime {
    String message() default "Field must be valid to date time";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
