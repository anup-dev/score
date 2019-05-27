package com.score.app.service;

import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */
public interface UserService {

    Map<String, Object> getUser(String email,String password);
}
