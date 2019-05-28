package com.score.app.service.impl;

import com.score.app.model.Fixture;
import com.score.app.repository.FixtureRepository;
import com.score.app.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Anup on 28/5/19.
 */

@Service
public class FixtureServiceImpl implements FixtureService {

    @Autowired
    private FixtureRepository fixtureRepository;

    @Override
    public Map<String, Object> getFixture() {
        return fixtureRepository.getFixture();
    }

    @Override
    public Map<String, Object> postFixture(Fixture fixture) {
        return fixtureRepository.postFixture(fixture);
    }

    @Override
    public Map<String, Object> putFixture(Fixture fixture) {
        return fixtureRepository.putFixture(fixture);
    }
}
