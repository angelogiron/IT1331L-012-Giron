package com.uap.it1311l.passwordencryptorapi.repository;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface passwordMyBatis {

	@Insert("INSERT INTO password(encryptedPassword) VALUES (#{password})")
	public void insert(String password);
	
	@Select("SELECT encryptedPassword FROM password WHERE encryptedPassword = #{encryptedPassword}")
	public String findEncryptedPassword(String encryptedPassword);
}
