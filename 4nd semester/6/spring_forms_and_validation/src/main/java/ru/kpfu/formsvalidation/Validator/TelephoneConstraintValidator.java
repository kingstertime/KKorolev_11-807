package ru.kpfu.formsvalidation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneConstraintValidator implements ConstraintValidator<Telephone, String> {
        @Override
    public void initialize(Telephone telephone) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isValid(String telephoneField, ConstraintValidatorContext cxt) {
        if(telephoneField == null) {
            return false;
        }
        return telephoneField.matches("[^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$]*");
    }
}
