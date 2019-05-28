package com.score.app.service;

import com.score.app.model.Fixture;

import java.util.Map;

/**
 * Created by Anup on 28/5/19.
 */
public interface FixtureService {

    Map<String, Object> getFixture();
    Map<String, Object> postFixture(Fixture fixture);
    Map<String, Object> putFixture(Fixture fixture);
}
