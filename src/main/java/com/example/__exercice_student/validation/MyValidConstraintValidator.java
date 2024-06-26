package com.example.__exercice_student.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyValidConstraintValidator implements ConstraintValidator<MyValid, String>{
    private String charContain;
    @Override
    public void initialize(MyValid constraintAnnotation) {
        charContain = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if(s != null) {
            result = s.contains(charContain);
        } else {
            result = true;
        }
        return result;
    }

}
