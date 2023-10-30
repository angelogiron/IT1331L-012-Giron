package com.uap.it1311l.passwordencryptorapi.repository;


import com.uap.it1311l.passwordencryptorapi.models.password;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface passwordMyBatis {

    @Insert("INSERT INTO password (encryptedPassword) VALUES (#{encryptedPassword})")
    void savePassword(@Param("encryptedPassword") String encryptedPassword);

    @Select("SELECT encryptedPassword FROM password WHERE encryptedPassword = #{encryptedPassword}")
    String findbyEncryptedPassword(String encryptedPassword);
}
