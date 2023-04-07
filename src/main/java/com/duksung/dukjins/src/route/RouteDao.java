package com.duksung.dukjins.src.route;

import com.duksung.dukjins.config.BaseResponseStatus;
import com.duksung.dukjins.src.route.model.post.PostRouteReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
@Slf4j
public class RouteDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //경로 저장
    public BaseResponseStatus createRoute(PostRouteReq postRouteReq){
        String createRouteQuery = "";
        Object[] createRouteParams = new Object[0];
        //이름과 경유지가 모두 없는 경우
        if(postRouteReq.getRouteName()==null && postRouteReq.getPassPoint() == null) {
            createRouteQuery = "insert into route (userIdx, mark, good, startX, startY, endX, endY) values (?,?,?,?,?,?,?)";
            createRouteParams = new Object[]{postRouteReq.getUserIdx(),postRouteReq.isMark(),postRouteReq.isGood(),
                    postRouteReq.getStartX(),postRouteReq.getStartY(),postRouteReq.getEndX(),postRouteReq.getEndY()};

        }//이름과 경유지가 모두 있는 경우
        else if (postRouteReq.getRouteName() != null && postRouteReq.getPassPoint() !=null) {
            createRouteQuery = "insert into route (userIdx, routeName, mark, good, startX, startY, endX, endY, passPoint) VALUES (?,?,?,?,?,?,?,?,?)";
            createRouteParams = new Object[]{postRouteReq.getUserIdx(),postRouteReq.getRouteName(),postRouteReq.isMark(),postRouteReq.isGood(),
                    postRouteReq.getStartX(),postRouteReq.getStartY(),postRouteReq.getEndX(),postRouteReq.getEndY(),postRouteReq.getPassPoint()};

        }//이름만 있는 경우
        else if (postRouteReq.getRouteName() != null) {
            createRouteQuery = "insert into route (userIdx, routeName, mark, good, startX, startY, endX, endY) values (?,?,?,?,?,?,?,?)";
            createRouteParams = new Object[]{postRouteReq.getUserIdx(),postRouteReq.getRouteName(),postRouteReq.isMark(),postRouteReq.isGood(),
                    postRouteReq.getStartX(),postRouteReq.getStartY(),postRouteReq.getEndX(),postRouteReq.getEndY()};

        }//경유지만 있는 경우
        else if(postRouteReq.getPassPoint() !=null){
            createRouteQuery = "insert into route (userIdx, mark, good, startX, startY, endX, endY, passPoint) values (?,?,?,?,?,?,?,?)";
            createRouteParams = new Object[]{postRouteReq.getUserIdx(),postRouteReq.isMark(),postRouteReq.isGood(),
                    postRouteReq.getStartX(),postRouteReq.getStartY(),postRouteReq.getEndX(),postRouteReq.getEndY(),postRouteReq.getPassPoint()};

        }

        this.jdbcTemplate.update(createRouteQuery,createRouteParams);

        return BaseResponseStatus.SUCCESS;
    }
}
