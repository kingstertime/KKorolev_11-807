//package ru.kpfu.formsvalidation.Validator;
//
//import javax.validation.Constraint;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class MailConstraintValidator implements ConstraintValidator<Mail, String> {
//
//    @Override
//    public void initialize(Mail mail) {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    @Override
//    public boolean isValid(String mailField, ConstraintValidatorContext cxt) {
//        if(mailField == null) {
//            return false;
//        }
//        return mailField.matches("[/^[^@]+@[^@.]+\\.[^@]+$/]*");
//    }
//}
