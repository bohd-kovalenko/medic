package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.services.HTMLService;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HTMLServiceImpl implements HTMLService {
    @Value("${patient-card-html-path}")
    private String htmlFilePath;

    @SneakyThrows
    public void fillHTMLWithMedicalInfo() {
        Document htmlFile = Jsoup.parse(new File(htmlFilePath));
        setInputValue(htmlFile.getElementById("brigade"),);
        checkBoxFill(htmlFile.getElementById("urgently"),);
        checkBoxFill(htmlFile.getElementById("priority"),);
        checkBoxFill(htmlFile.getElementById("default"),);
        setInputValue(htmlFile.getElementById("name-surname"),);
        setInputValue(htmlFile.getElementById("last4"),);
        checkBoxFill(htmlFile.getElementById("male"),);
        checkBoxFill(htmlFile.getElementById("female"),);
        setInputValue(htmlFile.getElementById("date"),);
        setInputValue(htmlFile.getElementById("time"),);
        setInputValue(htmlFile.getElementById("forces"),);
        setInputValue(htmlFile.getElementById("blood-type"),);
        setInputValue(htmlFile.getElementById("allergies"),);
        checkBoxFill(htmlFile.getElementById("artillery"),);
        checkBoxFill(htmlFile.getElementById("blunt"),);
        checkBoxFill(htmlFile.getElementById("burn"),);
        checkBoxFill(htmlFile.getElementById("fall"),);
        checkBoxFill(htmlFile.getElementById("grenade"),);
        checkBoxFill(htmlFile.getElementById("ied"),);
        checkBoxFill(htmlFile.getElementById("landmine"),);
        checkBoxFill(htmlFile.getElementById("mvc"),);
        checkBoxFill(htmlFile.getElementById("rpg"),);
        checkBoxFill(htmlFile.getElementById("gsw"),);
        setInputValue(htmlFile.getElementById("other"),);
        setInputValue(htmlFile.getElementById("injuries-concrete"),);
        setInputValue(htmlFile.getElementById("time1"),);
        setInputValue(htmlFile.getElementById("time2"),);
        setInputValue(htmlFile.getElementById("time3"),);
        setInputValue(htmlFile.getElementById("time4"),);
        setInputValue(htmlFile.getElementById("time5"),);
        setInputValue(htmlFile.getElementById("pulse1"),);
        setInputValue(htmlFile.getElementById("pulse2"),);
        setInputValue(htmlFile.getElementById("pulse3"),);
        setInputValue(htmlFile.getElementById("pulse4"),);
        setInputValue(htmlFile.getElementById("pulse5"),);
        setInputValue(htmlFile.getElementById("blood-pressure1"),);
        setInputValue(htmlFile.getElementById("blood-pressure2"),);
        setInputValue(htmlFile.getElementById("blood-pressure3"),);
        setInputValue(htmlFile.getElementById("blood-pressure4"),);
        setInputValue(htmlFile.getElementById("blood-pressure5"),);
        setInputValue(htmlFile.getElementById("repository-rate1"),);
        setInputValue(htmlFile.getElementById("repository-rate2"),);
        setInputValue(htmlFile.getElementById("repository-rate3"),);
        setInputValue(htmlFile.getElementById("repository-rate4"),);
        setInputValue(htmlFile.getElementById("repository-rate5"),);
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat1"),);
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat2"),);
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat3"),);
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat4"),);
        setInputValue(htmlFile.getElementById("pulse-Ox%O2-sat5"),);
        setInputValue(htmlFile.getElementById("avpu1"),);
        setInputValue(htmlFile.getElementById("avpu2"),);
        setInputValue(htmlFile.getElementById("avpu3"),);
        setInputValue(htmlFile.getElementById("avpu4"),);
        setInputValue(htmlFile.getElementById("avpu5"),);
        setInputValue(htmlFile.getElementById("pain-scale1"),);
        setInputValue(htmlFile.getElementById("pain-scale2"),);
        setInputValue(htmlFile.getElementById("pain-scale3"),);
        setInputValue(htmlFile.getElementById("pain-scale4"),);
        setInputValue(htmlFile.getElementById("pain-scale5"),);

    }

    private void setInputValue(Element input, String value) {
        input.val(value);
    }
    private void checkBoxFill(Element checkbox, boolean value){
        if(value) checkbox.attributes().add("checked", "");
    }
}
