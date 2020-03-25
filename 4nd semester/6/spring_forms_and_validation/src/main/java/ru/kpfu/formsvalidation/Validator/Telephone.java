package ru.kpfu.formsvalidation.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {
    String message() default "{Telephone}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
