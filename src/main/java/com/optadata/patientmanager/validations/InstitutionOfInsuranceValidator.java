package com.optadata.patientmanager.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstitutionOfInsuranceValidator implements ConstraintValidator<IkValidation, Long> {
    @Override
    public boolean isValid(Long institutionOfInsurance, ConstraintValidatorContext constraintValidatorContext) {
        return isValidIK(institutionOfInsurance);
    }

    public static boolean isValidIK(long ik) {
        String ikAsString = ik + "";
        int sum = 0;
        if (ikAsString.length() == 9) {
            char[] digits = (ikAsString.substring(2, ikAsString.length() - 1)).toCharArray();
            int length = digits.length;
            for (int i = 0; i < length; i++) {
                int digit = Integer.parseInt(digits[length - i - 1] + "");
                if (i % 2 == 1) {
                    digit *= 2;
                }
                sum += digit > 9 ? digit - 9 : digit;
            }
            return sum % 10 == ik % 10;
        }
        return false;
    }
}
