package com.board.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Pattern(regexp="[a-z0-9_-]{5,20}", message="아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.")
	private String userId;
	@Pattern(regexp="[A-z0-9]{8,16}", message="비밀번호는 8~16자 영문 대 소문자, 숫자를 사용하세요." )
	private String password;
	@NotBlank(message="이름은 필수정보입니다.")
	private String name;
	@Email(message="이메일 주소를 다시 확인해주세요.")
	private String email;
	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public User() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public boolean isSameUser(String userId) {
		if(this.userId==null)
			return false;
		return this.userId.equals(userId);
	}
	public boolean matchPassword(String newPassword) {
		return this.password.equals(newPassword);
	}
	public static boolean login(String userId, String password) throws UserNotFoundException, PasswordMismatchException {
		UserDAO userDAO=new UserDAO();
		User user = userDAO.findByUserId(userId);
		
		if(user==null) {
			throw new UserNotFoundException();
		}
		if(!user.matchPassword(password)) {
			throw new PasswordMismatchException();
		}
		return true;
	}
}
