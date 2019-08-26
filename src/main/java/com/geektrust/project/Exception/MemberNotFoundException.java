package com.geektrust.project.Exception;

import com.geektrust.project.Constant.Constant;

public class MemberNotFoundException extends Throwable {

    public MemberNotFoundException(){
        System.out.println(Constant.PERSON_NOT_FOUND);
    }
}
