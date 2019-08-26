package com.geektrust.project.Member;

import com.geektrust.project.Constant.Constant;
import com.geektrust.project.Exception.ChildAdditionFailedException;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Member Class contains details about
 */
public class Member {

    private String name;

    private String gender;

    private Member mother;

    private Member father;

    private Member spouse;

    private Set<Member> daughter;

    private Set<Member> sons;

    private Set<Member> children;

    public Member(){
        this.name = Constant.UNDEFINED;
        this.gender = Constant.UNDEFINED;
        this.mother = null;
        this.father = null;
        this.spouse = null;
        daughter = new LinkedHashSet<Member>();
        sons = new LinkedHashSet<Member>();
        children = new LinkedHashSet<Member>();
    }

    public Member(String name, String gender){
        this.name = name;
        this.gender = gender;
        this.mother = null;
        this.father = null;
        this.spouse = null;
        daughter = new LinkedHashSet<Member>();
        sons = new LinkedHashSet<Member>();
        children = new LinkedHashSet<Member>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Member getMother() {
        return mother;
    }

    public void setMother(Member mother) {
        this.mother = mother;
    }

    public Member getFather() {
        return father;
    }

    public void setFather(Member father) {
        this.father = father;
    }

    public Set<Member> getDaughters() {
        if (gender == Constant.GENDER_MALE){
            if(spouse != null)
                return spouse.getDaughters();
        }
        return daughter;
    }

    public void setDaughters(Set<Member> daughter) {
        this.daughter = daughter;
    }

    public Set<Member> getSons() {
        if(gender == Constant.GENDER_MALE){
            if(spouse != null)
                return  spouse.getSons();
        }
        return sons;
    }

    public void setSons(Set<Member> sons) {
        this.sons = sons;
    }

    public Set<Member> getChildren() {
        if(gender == Constant.GENDER_MALE){
            if(spouse != null) {
                return spouse.getChildren();
            }else{
                return children;
            }
        }
        return children;
    }

    public Member getSpouse() {
        return spouse;
    }

    public void setSpouse(Member spouse) {
        if(this.spouse != null){
            return;
        }
        this.spouse = spouse;
        spouse.setSpouse(this);

    }

    public void addChildren(Member child) throws ChildAdditionFailedException {
        if(gender == Constant.GENDER_MALE){
            throw new ChildAdditionFailedException();
        }else {
            child.setMother(this);
            child.setFather(spouse);
            if(child.gender == Constant.GENDER_MALE){
                sons.add(child);
            }else{
                daughter.add(child);
            }
            children.add(child);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Member)) {
            return false;
        }

        Member that = (Member) obj;

        return !(name != null ? !name.equals(that.name) : that.name != null);
    }
}


