package com.otto.spring.service;

import com.otto.spring.annotation.An;

public interface UserService {
    void saveUser();
    void getUser(int i, int j);
    void updateUser(An an);
}
