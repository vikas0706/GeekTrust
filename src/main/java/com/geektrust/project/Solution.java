package com.geektrust.project;

import com.geektrust.project.Constant.Constant;
import com.geektrust.project.Exception.ChildAdditionFailedException;
import com.geektrust.project.Exception.InvalidInputException;
import com.geektrust.project.Exception.MemberNotFoundException;
import com.geektrust.project.Family.Family;
import com.geektrust.project.Relation.Relation;
import com.geektrust.project.ShanFamily.ShanFamily;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    //Main class
    public static void main(String[] args) {
        ShanFamily shanFamily = new ShanFamily();
        Relation relation = shanFamily.getRelation();
        Family family = relation.getFamily();
        String filePath = args[0];
        File file = new File(filePath);

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String s = sc.next();
                if(s.equalsIgnoreCase("ADD_CHILD")){
                    String mother = sc.next();
                    String child = sc.next();
                    String gender = sc.next();
                    try {
                        family.addChild(mother,child,gender);
                        System.out.println(Constant.CHILD_ADDITION_SUCCEDED);
                    } catch (MemberNotFoundException e) {

                    } catch (ChildAdditionFailedException e) {

                    } catch (InvalidInputException e) {

                    }
                }else{
                    try{
                        String member = sc.next();
                        String relationShip = sc.next();
                        Set<String> ans = null;
                        if(relationShip.equalsIgnoreCase(Constant.RELATION_MATERNAL_UNCLE)){
                            ans  = relation.getMaternalUncle(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_PATERNAL_UNCLE)){
                            ans = relation.getPaternalUncle(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_MATERNAL_AUNT)){
                            ans = relation.getMaternalAunt(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_PATERNAL_AUNT)){
                            ans = relation.getPaternalAunt(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_SISTER_IN_LAW)){
                            ans = relation.getSisterInLaw(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_BROTHER_IN_LAW)){
                            ans = relation.getBrotherInLaw(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_SON)){
                            ans = relation.getSons(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_DAUGHTER)){
                            ans = relation.getDaughters(member);
                        }else if(relationShip.equalsIgnoreCase(Constant.RELATION_SIBLINGS)){
                            ans = relation.getSiblings(member);
                        }
                        if(ans != null && ans.size() != 0){
                            for(String string:ans){
                                System.out.print(string+" ");
                            }
                            System.out.println("");
                        }else{
                            System.out.println("NONE");
                        }
                    } catch (MemberNotFoundException e) {

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
