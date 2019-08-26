
package com.geektrust.project.Family;

import com.geektrust.project.Constant.Constant;
import com.geektrust.project.Exception.ChildAdditionFailedException;
import com.geektrust.project.Exception.InvalidInputException;
import com.geektrust.project.Exception.MemberNotFoundException;
import com.geektrust.project.Member.Member;

import java.util.HashMap;
import java.util.Map;

public class Family {


    private Map<String, Member> members = new HashMap<String, Member>();

    public Family(){

    }

    public Member addMember(String name,String gender){
        final Member newMember = new Member(name,gender);
        members.put(name,newMember);
        return newMember;
    }

    public Member getMember(String name) {
        return members.get(name);
    }

    public Member addChild(String motherName, String childName, String childGender) throws MemberNotFoundException, ChildAdditionFailedException, InvalidInputException {
        if(members.get(motherName) != null){
            if(childGender.equalsIgnoreCase(Constant.GENDER_MALE)){
                childGender = Constant.GENDER_MALE;
            }else if(childGender.equalsIgnoreCase(Constant.GENDER_FEMALE)){
                childGender = Constant.GENDER_FEMALE;
            }else {
                throw new InvalidInputException();
            }
            if(members.get(motherName).getGender() == Constant.GENDER_MALE ) {
                throw new ChildAdditionFailedException();
            }
            if(members.get(childName) == null){
                Member member = addMember(childName, childGender);
                members.get(motherName).addChildren(member);
                Member mother = members.get(motherName);
                member.setMother(mother);
                member.setFather(mother.getSpouse());
                return member;
            }else{
                throw new ChildAdditionFailedException();
            }
        }else{
            throw new MemberNotFoundException();
        }
    }




}
