package by.bsuir.nesenchuk.dto.validator.impl;

import by.bsuir.nesenchuk.dto.DTO;
import by.bsuir.nesenchuk.dto.validator.DTOValidator;
import by.bsuir.nesenchuk.dto.validator.exception.DTOValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DTOValidatorImpl implements DTOValidator {
    @Autowired
    private Validator validator;

    @Override
    public void validate(DTO dto) {
        Set<ConstraintViolation<DTO>> constraintViolations = validator.validate(dto);
        if (!constraintViolations.isEmpty()) {
            List<String> validationExceptionMessages = new ArrayList<>(constraintViolations.size());
            for (ConstraintViolation<DTO> constraintViolation : constraintViolations) {
                validationExceptionMessages.add(constraintViolation.getMessage());
            }
            throw new DTOValidationException(validationExceptionMessages);
        }
    }
}
