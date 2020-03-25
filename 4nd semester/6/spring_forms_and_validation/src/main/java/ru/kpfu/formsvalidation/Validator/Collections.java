package ru.kpfu.formsvalidation.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneConstraintValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Collections {
    String message() default "{Collection}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
