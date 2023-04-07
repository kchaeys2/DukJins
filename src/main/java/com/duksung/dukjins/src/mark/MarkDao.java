package com.duksung.dukjins.src.mark;

import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.mark.model.GetMarkRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Slf4j
public class MarkDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //즐겨찾기 모두 조회
    public List<GetMarkRes>getMark(int userIdx){
        String getMarkQuery = "select routeIdx,routeName,endX,endY from route where userIdx = ? and mark = 1";
        int getMarkParam = userIdx;
        return this.jdbcTemplate.query(getMarkQuery,
                (rs, rowNum) -> {
                    GetMarkRes getMarkRes = new GetMarkRes(
                            rs.getInt("routeIdx"),
                            rs.getString("routeName"),
                            rs.getFloat("endX"),
                            rs.getFloat("endY")
                    );
                    return getMarkRes;
                },getMarkParam);
    }

    //즐겨찾기 삭제 - 테이블 고민
}

