package com.testing.springcloud.persona.error.procesar;

import com.testing.springcloud.persona.error.ProcesarError;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProcesarErrorMethodArgumentNotValidException implements ProcesarError {
	@Override
	public Object procesar(Exception e) {
		MethodArgumentNotValidException ex = ((MethodArgumentNotValidException) e);
		List<ValidationError> errors = new ArrayList();
		BindingResult result = ex.getBindingResult();

		ValidationError error;
		for (Iterator var7 = result.getAllErrors().iterator(); var7.hasNext(); errors.add(error)) {
			ObjectError objectError = (ObjectError) var7.next();
			error = new ValidationError();
			error.setMessage(objectError.getDefaultMessage());
			if (objectError instanceof FieldError) {
				error.setField(((FieldError) objectError).getField());
			}
		}
		return new ValidationErrorResponse("fallo", errors);
	}
}
