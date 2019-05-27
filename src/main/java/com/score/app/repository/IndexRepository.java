package com.score.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */

@Repository
public class IndexRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(IndexRepository.class);

    public Map<String, Object> getDashboard(){

        Map<String,Object> dashboard = new HashMap<>();
        List<Map<String,Object>> result = new LinkedList<>();
        try
        {
            result = jdbcTemplate.queryForList("select id,team_a as teamA,team_b as teamB,venu,game_time as gameTime,match_result as matchResult,match_status as matchStatus,\n" +
                    "match_summary as matchSummary,bet from fixture");
            dashboard.put("status","success");
            dashboard.put("value",result);
        }catch (Exception e){
            LOGGER.error("error fetching match fixtures "+e.getMessage());
        }
        return dashboard;
    }


}
