package com.fullstack.ipldashboard.processor;

import java.time.LocalDate;

import com.fullstack.ipldashboard.bo.MatchInput;
import com.fullstack.ipldashboard.entity.Match;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MatchDataProcessor implements ItemProcessor<MatchInput,Match>{
    
    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match  = new Match();
        BeanUtils.copyProperties( matchInput, match);
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        String firstInningTeam,secondInningTeam;
        if("bat".equals(matchInput.getTossDecision())){
         firstInningTeam = matchInput.getTossWinner();
         secondInningTeam = matchInput.getTossWinner().equals(matchInput.getTeam1())
         ?matchInput.getTeam2():matchInput.getTeam1();
        }
        else{
            secondInningTeam = matchInput.getTeam2();
            firstInningTeam  = matchInput.getTossWinner().equals(matchInput.getTeam2())
            ?matchInput.getTeam1():matchInput.getTeam2();
        }
        match.setTeam1(firstInningTeam);
        match.setTeam2(secondInningTeam);

        return match;
    }
    

}
