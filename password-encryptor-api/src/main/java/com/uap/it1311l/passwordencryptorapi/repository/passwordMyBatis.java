package com.uap.it1311l.passwordencryptorapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface passwordMyBatis 
{
		@Insert("INSERT INTO password(encryptedPassword) VALUES (#{password})")
		public void insert(String password);
		
		@Select("SELECT COUNT(*) FROM password WHERE encryptedPassword = #{password}")
	    public int exists(String password);
}