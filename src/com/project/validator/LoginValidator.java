package com.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.model.Member;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Member.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Member member = (Member)obj;
		String mEmail = member.getEmail();
		String mPwd = member.getPwd();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "�ʼ� �Է��Դϴ�.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required", "�ʼ� �Է��Դϴ�.");
		
		if ( mEmail == null || mEmail.trim().isEmpty()) {
			errors.rejectValue("email", "�̸��� �ּҸ� �Է��ϼ���.");
		}
		
		if ( mPwd == null || mPwd.trim().isEmpty()) {
			errors.rejectValue("pwd", "��й�ȣ�� �Է��ϼ���.");
		}
		
	}

}
