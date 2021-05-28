package com.fullstack.ipldashboard.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchInput implements Serializable{
    private String id;
    private String city;
    private String date;
    private String playerOfMatch;
    private String venue;
    private String neutral_venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String winner;
    private String result;
    private String resultMargin;
    private String eliminator;
    private String method;
    private String umpire1;
    private String umpire2;
}
