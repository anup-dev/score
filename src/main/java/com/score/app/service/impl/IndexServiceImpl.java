package com.score.app.service.impl;

import com.score.app.repository.IndexRepository;
import com.score.app.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexRepository indexRepository;

    @Override
    public Map<String, Object> getDashboard() {
        return indexRepository.getDashboard();
    }
}
