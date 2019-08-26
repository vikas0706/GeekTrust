package com.geektrust.project.Exception;

import com.geektrust.project.Constant.Constant;

public class ChildAdditionFailedException extends Throwable {

    public ChildAdditionFailedException(){
        System.out.println(Constant.CHILD_ADDITION_FAILED);
    }
}
