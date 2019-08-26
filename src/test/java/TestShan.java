import com.geektrust.project.Constant.Constant;
import com.geektrust.project.Exception.ChildAdditionFailedException;
import com.geektrust.project.Exception.InvalidInputException;
import com.geektrust.project.Exception.MemberNotFoundException;
import com.geektrust.project.Family.Family;
import com.geektrust.project.Relation.Relation;
import com.geektrust.project.ShanFamily.ShanFamily;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class TestShan {

    @Test
    public void testFile1(){
        String filePath = "src//test//resources//test-input1.txt";
        Assert.assertEquals(generateOutput(filePath),"CHILD_ADDITION_SUCCEEDED\n" +
                "Asva Ketu \n" +
                "Vyas Ketu \n" +
                "Ish Vich Aras Satya \n");

    }
    @Test
    public void testFile2(){
        String filePath = "src//test//resources//test-input2.txt";
        Assert.assertEquals(generateOutput(filePath),"Atya \n" +
                "NONE\n" +
                "PERSON_NOT_FOUND\n");
    }

    public String generateOutput(String filePath){

        ShanFamily shanFamily = new ShanFamily();
        Relation relation = shanFamily.getRelation();
        Family family = relation.getFamily();
        File file = new File(filePath);
        String output = "";
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
                        output = output + Constant.CHILD_ADDITION_SUCCEDED + "\n";
                    } catch (MemberNotFoundException e) {
                        output = output + Constant.PERSON_NOT_FOUND + "\n";
                    } catch (ChildAdditionFailedException e) {
                        output = output + Constant.CHILD_ADDITION_FAILED + "\n";
                    } catch (InvalidInputException e) {
                        output = output + "INVALID INPUT" + "\n";
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
                                output = output + string+" ";
                            }
                            output = output + "\n";
                        }else{
                            output = output + "NONE"+"\n";
                        }
                    } catch (MemberNotFoundException e) {
                        output = output + Constant.PERSON_NOT_FOUND + "\n";
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
}
