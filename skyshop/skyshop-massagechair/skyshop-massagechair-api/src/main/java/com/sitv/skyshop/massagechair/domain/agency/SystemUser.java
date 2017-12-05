/**
 *
 */
package com.sitv.skyshop.massagechair.domain.agency;

import com.sitv.skyshop.massagechair.domain.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zfj20 @ 2017年12月8日
 */
@Getter
@Setter
@ToString(callSuper = true)
public class SystemUser extends User {
	private Agency agency;

	protected SystemUser() {
	}

	public SystemUser(Long id, String code, String name, String password, UserStatus status, UserType type, DeleteStatus deleteStatus) {
		super(id, code, name, "", password, "", "", status, type, deleteStatus);
	}

	public UserType getType() {
		return UserType.SYSTEM;
	}

	public String calcCheckCode() {
		setCheckCode("");
		return "";
	}
}
