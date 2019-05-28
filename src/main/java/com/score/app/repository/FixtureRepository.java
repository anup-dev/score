package com.score.app.repository;

import com.score.app.model.Fixture;
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
 * Created by Anup on 28/5/19.
 */
@Repository
public class FixtureRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(FixtureRepository.class);

    public Map<String, Object> getFixture(){
        Map<String,Object> fixture = new HashMap<>();
        List<Map<String,Object>> result = new LinkedList<>();
        try
        {
            result = jdbcTemplate.queryForList("select id,team_a as teamA,team_b as teamB,venu,game_time as gameTime,match_result as matchResult,match_status as matchStatus,\n" +
                    "match_summary as matchSummary,bet from fixture");
            fixture.put("status","success");
            fixture.put("value",result);
        }catch (Exception e){
            LOGGER.error("error fetching match fixtures "+e.getMessage());
        }
        return fixture;
    }

    public Map<String, Object> postFixture(Fixture fixture){
        Map<String,Object> result = new HashMap<>();
        try
        {
            String query = "INSERT INTO fixture(\n" +
                    "id, team_a, team_b, venu, match_status,match_result,match_summary, bet,game_time, game_date)\n"+
                    "VALUES ((select max(id)+1 from fixture), '"+fixture.getTeamA()+"', '"+fixture.getTeamB()+"', '"+fixture.getVenu()+"', '"+fixture.getMatchStatus()+"','"+fixture.getMatchResult()+"', '"+fixture.getMatchSummary()+"',"+fixture.getBet()+", '"+fixture.getGameTime()+"','"+fixture.getGameDate()+"')";
            int row = jdbcTemplate.update(query);
            if(row > 0){
                result.put("status","success");
            }else {
                result.put("status","fail");
            }

        }catch (Exception e){
            LOGGER.error("error creating match fixtures "+e.getMessage());
            result.put("status","fail");
        }
        return result;
    }

    public Map<String, Object> putFixture(Fixture fixture){
        Map<String,Object> result = new HashMap<>();
        try
        {
            String query = "UPDATE fixture\n" +
                    "SET " +
                    "team_a = '"+fixture.getTeamA()+"'," +
                    "team_b = '"+fixture.getTeamB()+"'," +
                    "venu = '"+fixture.getVenu()+"'," +
                    "match_status = '"+fixture.getMatchStatus()+"'," +
                    "match_result = '"+fixture.getMatchResult()+"'," +
                    "match_summary = '"+fixture.getMatchSummary()+"'," +
                    "game_time = '"+fixture.getGameTime()+"'," +
                    "game_date = '"+fixture.getGameDate()+"'," +
                    "bet = "+fixture.getBet()+
                    " WHERE id = "+fixture.getId();
            int row = jdbcTemplate.update(query);
            if(row > 0){
                result.put("status","success");
            }else {
                result.put("status","fail");
            }

        }catch (Exception e){
            LOGGER.error("error updating  match fixtures "+e.getMessage());
            result.put("status","fail");
        }
        return result;
    }

}
