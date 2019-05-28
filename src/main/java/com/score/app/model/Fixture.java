package com.score.app.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Anup on 28/5/19.
 */

@Getter
@Setter
public class Fixture {

    int id;
    String teamA;
    String teamB;
    String venu;
    String matchStatus;
    String matchResult;
    String matchSummary;
    int bet;
    String gameTime;
    String gameDate;
}
