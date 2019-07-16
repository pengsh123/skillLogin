package com.login.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.login.entity.User;

@Mapper
public interface UserMapper {

	@Insert("insert into t_user (id_,userName_,pwd_tel_,money_) values (id,userName,pwd,tel,0)")
	void addUser(String id, String userName, String pwd, String tel);

	@Update("update t_user money_=money_ <if test=\"i=0\">+</if><if test=\\\"i=1\\\">+</if>#{money} where id_ = #{id}")
	void changeMoney(String id, float money, int i);

	// @Update("update t_user money_=money_-#{money} where id_ = #{id}")
	// void decMoney(String id, float money);

	@Select("select money from t_user where id_ = #{id}")
	float getUserMoney(String id);

	@Select("select id_,userName_,pwd_,tel_,money_ from t_user where id_ = #{id}")
	User getUser(String id);

}
