package com.duksung.dukjins.src.user;

import com.duksung.dukjins.config.BaseResponse;
import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.user.model.post.PostJoinReq;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Slf4j
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //회원가입(open API)
    public BaseResponseStatus createUser(PostJoinReq postJoinReq){
        String createUserQuery = "insert into user(userIdx,email,pw) values (?,'e','p')";
        this.jdbcTemplate.update(createUserQuery,postJoinReq.getUserIdx());

        return BaseResponseStatus.SUCCESS;
    }
}
