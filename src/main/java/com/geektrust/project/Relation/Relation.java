package com.geektrust.project.Relation;

import com.geektrust.project.Exception.MemberNotFoundException;
import com.geektrust.project.Family.Family;
import com.geektrust.project.Family.Member.Member;

import java.util.LinkedHashSet;
import java.util.Set;


public class Relation {

    private final Family family ;

    public Relation(){
        family = new Family();
    }

    public Relation(Family family){
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public Set<String> getPaternalUncle(String name) throws MemberNotFoundException {
        Set<String> paternalUncles = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null ){
            throw new MemberNotFoundException();
        }
        if(member.getFather() == null || member.getFather().getMother() == null){
            return paternalUncles;
        }

        Member grandMother = member.getFather().getMother();
        Set<Member> patUncles = grandMother.getSons();

        for(Member m : patUncles){
            if(!m.equals(member.getFather())){
                paternalUncles.add(m.getName());
            }
        }
        return paternalUncles;
    }

    public Set<String> getMaternalUncle(String name) throws MemberNotFoundException {
        Set<String> maternalUncles = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null ){
            throw new MemberNotFoundException();
        }

        if(member.getMother() == null || member.getMother().getMother() == null){
            return maternalUncles;
        }

        Member grandfather = member.getMother().getMother();
        Set<Member> matUncles = grandfather.getSons();

        for(Member m : matUncles){
            maternalUncles.add(m.getName());
        }
        return maternalUncles;
    }

    public Set<String> getPaternalAunt(String name) throws MemberNotFoundException {
        Set<String> paternalAunt = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null ){
            throw new MemberNotFoundException();
        }
        if(member.getFather() == null || member.getFather().getMother() == null){
            return paternalAunt;
        }
        Member grandmother = member.getFather().getMother();
        Set<Member> matAunt = grandmother.getDaughters();

        for(Member m : matAunt){
            paternalAunt.add(m.getName());
        }
        return paternalAunt;
    }

    public Set<String> getMaternalAunt(String name) throws MemberNotFoundException {
        Set<String> paternalAunt = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null ){
            throw new MemberNotFoundException();
        }
        if(member.getMother() == null || member.getMother().getMother() == null){
            return paternalAunt;
        }

        Member grandmother = member.getMother().getMother();
        Set<Member> matAunt = grandmother.getDaughters();

        for(Member m : matAunt){
            if(!m.equals(member.getMother()))
               paternalAunt.add(m.getName());
        }
        return paternalAunt;
    }

    public Set<String> getSisterInLaw(String name) throws MemberNotFoundException {
        Set<String> sisterInLaw = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null){
           throw new MemberNotFoundException();
        }
        Member spouse = member.getSpouse();

        if(spouse != null && spouse.getMother() != null) {
            Set<Member> spouseSister = spouse.getMother().getDaughters();
            for(Member m : spouseSister){
                if(!(m.equals(spouse))){
                    sisterInLaw.add(m.getName());
                }
            }
        }
        if(member.getMother() != null){
            Set<Member> memberBrother= member.getMother().getSons();
            for(Member m : memberBrother){
                if(!(m.equals(member)) && m.getSpouse() != null){
                    sisterInLaw.add(m.getSpouse().getName());
                }
            }
        }
        return sisterInLaw;
    }

    public Set<String> getBrotherInLaw(String name) throws MemberNotFoundException {
        Set<String> brotherInLaw = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null){
            throw new MemberNotFoundException();
        }
        Member spouse = member.getSpouse();
        if(spouse != null && spouse.getMother() != null) {
            Set<Member> spouseBrothers = spouse.getMother().getSons();
            for(Member m : spouseBrothers){
                if(!(m.equals(spouse))){
                    brotherInLaw.add(m.getName());
                }
            }
        }
        if(member.getMother() != null){
            Set<Member> memberSisters = member.getMother().getDaughters();
            for(Member m : memberSisters){
                if(!(m.equals(member)) && m.getSpouse() != null){
                    brotherInLaw.add(m.getSpouse().getName());
                }
            }
        }
        return brotherInLaw;
    }

    public Set<String> getSons(String name) throws MemberNotFoundException {
        Set<String> sons = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null){
            throw new MemberNotFoundException();
        }
        Set<Member> memberSons = member.getSons();
        for(Member m : memberSons){
            sons.add(m.getName());
        }
        return sons;
    }

    public Set<String> getDaughters(String name) throws MemberNotFoundException {
        Set<String> daughters = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if(member == null){
            throw new MemberNotFoundException();
        }
        Set<Member> memberDaughters = member.getDaughters();
        for(Member m : memberDaughters){
            daughters.add(m.getName());
        }
        return daughters;
    }

    public Set<String> getSiblings(String name) throws MemberNotFoundException {
        Set<String> siblings = new LinkedHashSet<String>();
        Member member = family.getMember(name);
        if (member == null){
            throw new MemberNotFoundException();
        }
        if(member.getMother() != null){
            Set<Member> memberSibling = member.getMother().getChildren();
            for(Member m : memberSibling){
                if(!(m.equals(member))){
                    siblings.add(m.getName());
                }
            }
        }
        return siblings;
    }

}
