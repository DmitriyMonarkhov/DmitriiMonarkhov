package com.epam.tc.hw7.dataproviders;

import com.epam.tc.hw7.entities.UserEntity;

public class UserData {

    public static UserEntity DEFAULT_USER = new UserEntity().set(
        fill -> {
            fill.name = "Roman";
            fill.password = "Jdi1234";
            fill.fullName = "ROMAN IOVLEV";
        });
}
