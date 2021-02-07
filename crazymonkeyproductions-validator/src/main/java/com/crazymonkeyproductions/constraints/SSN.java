package com.crazymonkeyproductions.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crazymonkeyproductions.validators.SsnValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = SsnValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SSN {

	String message() default "Invalid SSN";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
