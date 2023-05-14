package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.services.HTMLService;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.format.DateTimeFormatter;

@Service
public class HTMLServiceImpl implements HTMLService {
    @Value("${patient-card-html-path}")
    private String htmlFilePath;

    @SneakyThrows
    @Override
    public void fillHTMLWithMedicalInfo(Soldier soldier) {
        Document htmlFile = Jsoup.parse(new File(htmlFilePath));
        setInputValue(htmlFile.getElementById("brigade"), soldier.getBrigade());
        checkBoxFill(htmlFile.getElementById("urgently"), soldier.getGeneralSoldierMedicalInfo().isUrgently());
        checkBoxFill(htmlFile.getElementById("priority"), soldier.getGeneralSoldierMedicalInfo().isPriority());
        checkBoxFill(htmlFile.getElementById("default"), soldier.getGeneralSoldierMedicalInfo().isRoutine());
        setInputValue(htmlFile.getElementById("name-surname"), soldier.getName() + " " + soldier.getSurname());
        setInputValue(htmlFile.getElementById("last4"), soldier.getGeneralSoldierMedicalInfo().getLast4());
        checkBoxFill(htmlFile.getElementById("male"), soldier.getGeneralSoldierMedicalInfo().isMale());
        checkBoxFill(htmlFile.getElementById("female"), soldier.getGeneralSoldierMedicalInfo().isFemale());
        setInputValue(htmlFile.getElementById("date"), soldier.getGeneralSoldierMedicalInfo().getDateTimeCreation().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        setInputValue(htmlFile.getElementById("time"), soldier.getGeneralSoldierMedicalInfo().getDateTimeCreation().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        setInputValue(htmlFile.getElementById("forces"), soldier.getGeneralSoldierMedicalInfo().getForcesType());
        setInputValue(htmlFile.getElementById("blood-type"), soldier.getGeneralSoldierMedicalInfo().getBloodType());
        setInputValue(htmlFile.getElementById("allergies"), soldier.getGeneralSoldierMedicalInfo().getAllergies());
        checkBoxFill(htmlFile.getElementById("artillery"), soldier.getSoldierInjuriesTypesList().isArtillery());
        checkBoxFill(htmlFile.getElementById("blunt"), soldier.getSoldierInjuriesTypesList().isBlunt());
        checkBoxFill(htmlFile.getElementById("burn"), soldier.getSoldierInjuriesTypesList().isBurn());
        checkBoxFill(htmlFile.getElementById("fall"), soldier.getSoldierInjuriesTypesList().isFall());
        checkBoxFill(htmlFile.getElementById("grenade"), soldier.getSoldierInjuriesTypesList().isGrenade());
        checkBoxFill(htmlFile.getElementById("ied"), soldier.getSoldierInjuriesTypesList().isIed());
        checkBoxFill(htmlFile.getElementById("landmine"), soldier.getSoldierInjuriesTypesList().isLandmine());
        checkBoxFill(htmlFile.getElementById("mvc"), soldier.getSoldierInjuriesTypesList().isMvc());
        checkBoxFill(htmlFile.getElementById("rpg"), soldier.getSoldierInjuriesTypesList().isRpg());
        checkBoxFill(htmlFile.getElementById("gsw"), soldier.getSoldierInjuriesTypesList().isGsw());
        setInputValue(htmlFile.getElementById("other"), soldier.getSoldierInjuriesTypesList().getOther());
        setInputValue(htmlFile.getElementById("injuries-concrete"), soldier.getSoldierInjuriesConcreteList().getText());
        setInputValue(htmlFile.getElementById("time1"), soldier.getSpecificSituationInfoList().get(0).getFillingTime().toString());
        setInputValue(htmlFile.getElementById("time2"), soldier.getSpecificSituationInfoList().get(1).getFillingTime().toString());
        setInputValue(htmlFile.getElementById("time3"), soldier.getSpecificSituationInfoList().get(2).getFillingTime().toString());
        setInputValue(htmlFile.getElementById("time4"), soldier.getSpecificSituationInfoList().get(3).getFillingTime().toString());
        setInputValue(htmlFile.getElementById("time5"), soldier.getSpecificSituationInfoList().get(4).getFillingTime().toString());
        setInputValue(htmlFile.getElementById("pulse1"), soldier.getSpecificSituationInfoList().get(0).getPulse());
        setInputValue(htmlFile.getElementById("pulse2"), soldier.getSpecificSituationInfoList().get(1).getPulse());
        setInputValue(htmlFile.getElementById("pulse3"), soldier.getSpecificSituationInfoList().get(2).getPulse());
        setInputValue(htmlFile.getElementById("pulse4"), soldier.getSpecificSituationInfoList().get(3).getPulse());
        setInputValue(htmlFile.getElementById("pulse5"), soldier.getSpecificSituationInfoList().get(4).getPulse());
        setInputValue(htmlFile.getElementById("blood-pressure1"), soldier.getSpecificSituationInfoList().get(0).getBloodPressure());
        setInputValue(htmlFile.getElementById("blood-pressure2"), soldier.getSpecificSituationInfoList().get(1).getBloodPressure());
        setInputValue(htmlFile.getElementById("blood-pressure3"), soldier.getSpecificSituationInfoList().get(2).getBloodPressure());
        setInputValue(htmlFile.getElementById("blood-pressure4"), soldier.getSpecificSituationInfoList().get(3).getBloodPressure());
        setInputValue(htmlFile.getElementById("blood-pressure5"), soldier.getSpecificSituationInfoList().get(4).getBloodPressure());
        setInputValue(htmlFile.getElementById("repository-rate1"), soldier.getSpecificSituationInfoList().get(0).getRespiratoryDate());
        setInputValue(htmlFile.getElementById("repository-rate2"), soldier.getSpecificSituationInfoList().get(1).getRespiratoryDate());
        setInputValue(htmlFile.getElementById("repository-rate3"), soldier.getSpecificSituationInfoList().get(2).getRespiratoryDate());
        setInputValue(htmlFile.getElementById("repository-rate4"), soldier.getSpecificSituationInfoList().get(3).getRespiratoryDate());
        setInputValue(htmlFile.getElementById("repository-rate5"), soldier.getSpecificSituationInfoList().get(4).getRespiratoryDate());
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat1"), soldier.getSpecificSituationInfoList().get(0).getPulseOxO2Sat());
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat2"), soldier.getSpecificSituationInfoList().get(1).getPulseOxO2Sat());
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat3"), soldier.getSpecificSituationInfoList().get(2).getPulseOxO2Sat());
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat4"), soldier.getSpecificSituationInfoList().get(3).getPulseOxO2Sat());
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat5"), soldier.getSpecificSituationInfoList().get(4).getPulseOxO2Sat());
        setInputValue(htmlFile.getElementById("avpu1"), soldier.getSpecificSituationInfoList().get(0).getAvpu());
        setInputValue(htmlFile.getElementById("avpu2"), soldier.getSpecificSituationInfoList().get(1).getAvpu());
        setInputValue(htmlFile.getElementById("avpu3"), soldier.getSpecificSituationInfoList().get(2).getAvpu());
        setInputValue(htmlFile.getElementById("avpu4"), soldier.getSpecificSituationInfoList().get(3).getAvpu());
        setInputValue(htmlFile.getElementById("avpu5"), soldier.getSpecificSituationInfoList().get(4).getAvpu());
        setInputValue(htmlFile.getElementById("pain-scale1"), soldier.getSpecificSituationInfoList().get(0).getPainScale());
        setInputValue(htmlFile.getElementById("pain-scale2"), soldier.getSpecificSituationInfoList().get(1).getPainScale());
        setInputValue(htmlFile.getElementById("pain-scale3"), soldier.getSpecificSituationInfoList().get(2).getPainScale());
        setInputValue(htmlFile.getElementById("pain-scale4"), soldier.getSpecificSituationInfoList().get(3).getPainScale());
        setInputValue(htmlFile.getElementById("pain-scale5"), soldier.getSpecificSituationInfoList().get(4).getPainScale());

    }

    private void setInputValue(Element input, String value) {
        if (value == null) input.val("");
        else input.val(value);
    }

    private void checkBoxFill(Element checkbox, boolean value) {
        if (value) checkbox.attributes().add("checked", "");
    }
}
