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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "필수 입력입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required", "필수 입력입니다.");
		
		if ( mEmail == null || mEmail.trim().isEmpty()) {
			errors.rejectValue("email", "이메일 주소를 입력하세요.");
		}
		
		if ( mPwd == null || mPwd.trim().isEmpty()) {
			errors.rejectValue("pwd", "비밀번호를 입력하세요.");
		}
		
	}

}
