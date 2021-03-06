package com.crazymonkeyproductions.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.crazymonkeyproductions.validators.AlphaValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AlphaValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphaNumeric {

	String message() default "Non-alpha characters detected";
	
	int min() default 1;
	
	int max() default Integer.MAX_VALUE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
