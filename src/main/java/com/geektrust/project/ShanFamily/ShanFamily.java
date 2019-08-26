package com.geektrust.project.ShanFamily;

import com.geektrust.project.Constant.Constant;
import com.geektrust.project.Exception.ChildAdditionFailedException;
import com.geektrust.project.Family.Family;
import com.geektrust.project.Family.Member.Member;
import com.geektrust.project.Relation.Relation;

public class ShanFamily {
    private final Relation relation ;

    public ShanFamily(){
        relation = new Relation();
        initializeShanFamily();
    }

    public Relation getRelation() {
        return relation;
    }

    public void initializeShanFamily(){
        Family family = relation.getFamily();
        Member kingShan = family.addMember("King Shan", Constant.GENDER_MALE);
        Member queenAnga = family.addMember("Queen Anga", Constant.GENDER_FEMALE);
        Member chit = family.addMember("Chit", Constant.GENDER_MALE);
        Member amba = family.addMember("Amba",Constant.GENDER_FEMALE);
        Member dritha = family.addMember("Dritha", Constant.GENDER_FEMALE);
        Member jaya = family.addMember("Jaya", Constant.GENDER_MALE);
        Member yodhan = family.addMember("Yodhan", Constant.GENDER_MALE);
        Member tritha = family.addMember("Tritha", Constant.GENDER_FEMALE);
        Member vritha = family.addMember("Vritha", Constant.GENDER_MALE);
        Member ish = family.addMember("Ish", Constant.GENDER_MALE);
        Member vich = family.addMember("Vich", Constant.GENDER_MALE);
        Member lika = family.addMember("Lika",Constant.GENDER_FEMALE);
        Member vila = family.addMember("Vila",Constant.GENDER_FEMALE);
        Member chika = family.addMember("Chika",Constant.GENDER_FEMALE);
        Member aras = family.addMember("Aras", Constant.GENDER_MALE);
        Member chitra = family.addMember("Chitra",Constant.GENDER_FEMALE);
        Member jnki = family.addMember("Jnki", Constant.GENDER_FEMALE);
        Member arit = family.addMember("Arit", Constant.GENDER_MALE);
        Member laki = family.addMember("Laki", Constant.GENDER_MALE);
        Member lavnya = family.addMember("Lavnya", Constant.GENDER_FEMALE);
        Member ahit = family.addMember("Ahit", Constant.GENDER_MALE);
        Member satya = family.addMember("Satya", Constant.GENDER_FEMALE);
        Member Vyan = family.addMember("Vyan", Constant.GENDER_MALE);
        Member asva = family.addMember("Asva", Constant.GENDER_MALE);
        Member satvy = family.addMember("Satvy", Constant.GENDER_FEMALE);
        Member vasa = family.addMember("Vasa", Constant.GENDER_MALE);
        Member vyas = family.addMember("Vyas",Constant.GENDER_MALE);
        Member krpi = family.addMember("Krpi", Constant.GENDER_FEMALE);
        Member kriya = family.addMember("Kriya", Constant.GENDER_MALE);
        Member krithi = family.addMember("Krithi", Constant.GENDER_FEMALE);
        Member atya = family.addMember("Atya", Constant.GENDER_FEMALE);

        kingShan.setSpouse(queenAnga);
        chit.setSpouse(amba);
        dritha.setSpouse(jaya);
        vich.setSpouse(lika);
        aras.setSpouse(chitra);
        jnki.setSpouse(arit);
        satya.setSpouse(Vyan);
        asva.setSpouse(satvy);
        vyas.setSpouse(krpi);

        try {

            queenAnga.addChildren(chit);
            queenAnga.addChildren(ish);
            queenAnga.addChildren(vich);
            queenAnga.addChildren(aras);
            queenAnga.addChildren(satya);

            amba.addChildren(dritha);
            amba.addChildren(tritha);
            amba.addChildren(vritha);

            dritha.addChildren(yodhan);

            lika.addChildren(vila);
            lika.addChildren(chika);

            chitra.addChildren(jnki);
            chitra.addChildren(ahit);

            jnki.addChildren(laki);
            jnki.addChildren(lavnya);

            satya.addChildren(asva);
            satya.addChildren(vyas);
            satya.addChildren(atya);

            satvy.addChildren(vasa);

            krpi.addChildren(kriya);
            krpi.addChildren(krithi);

        } catch (ChildAdditionFailedException e) {
            e.printStackTrace();
        }
    }
}
