package com.iddel.spt.validation;

import org.springframework.stereotype.Component;

@Component
public abstract class FormValidationFactory {
	public static IFormValidation getInstance(String formName){
		switch (formName){
		case "basic":
		default:
			return null;
		}
	}
}
