package com.login.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.login.entity.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user (id_,userName_,pwd_,tel_,money_) values (#{id},#{userName},#{pwd},#{tel},0)")
	void addUser(@Param("id") String id, @Param("userName") String userName, @Param("pwd") String pwd,
			@Param("tel") String tel);

	@Update("update user money_=money_ <if test=\"i=0\">+</if><if test=\"i=1\">+</if>#{money} where id_ = #{id}")
	void changeMoney(@Param("id") String id, @Param("id") float money, int i);

	// @Update("update user money_=money_-#{money} where id_ = #{id}")
	// void decMoney(String id, float money);

	@Select("select money from user where id_ = #{id}")
	float getUserMoney(@Param("id") String id);

	@Select("select id_,userName_,pwd_,tel_,money_ from user where id_ = #{id}")
	User getUser(@Param("id") String id);
	
	@Select("select id_,userName_,pwd_,tel_,money_ from user where userName_ = #{userName}")
	User getUserByName(@Param("userName") String userName);

}
