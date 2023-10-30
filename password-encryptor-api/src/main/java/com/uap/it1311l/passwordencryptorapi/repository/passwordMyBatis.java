package com.uap.it1311l.passwordencryptorapi.repository;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface passwordMyBatis {

    @Insert("INSERT INTO password (encryptedPassword) VALUES (#{encryptedPassword})")
    public void insert(String password);

    @Select("SELECT encryptedPassword FROM password WHERE encryptedPassword = #{encryptedPassword}")
    public String findbyEncryptedPassword(String encryptedPassword);
}
