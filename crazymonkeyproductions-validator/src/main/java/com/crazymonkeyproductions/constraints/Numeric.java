package com.crazymonkeyproductions.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crazymonkeyproductions.validators.NumericValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = NumericValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {

	String message() default "Non-numeric characters detected";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
