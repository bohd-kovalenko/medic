package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.*;
import com.demo.warmedicapp.entities.enums.FileType;
import com.demo.warmedicapp.exceptions.UnexistingBlankException;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.payload.requests.BlankRequest;
import com.demo.warmedicapp.payload.responses.BlankResponse;
import com.demo.warmedicapp.repositories.GeneralSoldierMedicalInfoRepository;
import com.demo.warmedicapp.repositories.SoldierInjuriesConcreteRepository;
import com.demo.warmedicapp.repositories.SoldierInjuriesTypesRepository;
import com.demo.warmedicapp.repositories.SpecificSituationInfoRepository;
import com.demo.warmedicapp.services.BlankService;
import com.demo.warmedicapp.services.FileService;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlankServiceImpl implements BlankService {
    private final GeneralSoldierMedicalInfoRepository generalSoldierMedicalInfoRepository;
    private final SoldierInjuriesConcreteRepository soldierInjuriesConcreteRepository;
    private final SoldierInjuriesTypesRepository soldierInjuriesTypesRepository;
    private final SpecificSituationInfoRepository specificSituationInfoRepository;

    private final FileService fileService;
    private final SoldierService soldierService;

    public BlankResponse getBlankResponsesBySoldierId(Integer id) {
        GeneralSoldierMedicalInfo generalSoldierMedicalInfo = generalSoldierMedicalInfoRepository
                .findBySoldierId(id)
                .orElseThrow(() -> new UnexistingBlankException(id));

        SoldierInjuriesConcrete soldierInjuriesConcrete = soldierInjuriesConcreteRepository
                .findBySoldierId(id)
                .orElseThrow(() -> new UnexistingBlankException(id));

        SoldierInjuriesTypes soldierInjuriesTypes = soldierInjuriesTypesRepository
                .findBySoldierId(id)
                .orElseThrow(() -> new UnexistingBlankException(id));

        SpecificSituationInfo specificSituationInfo = specificSituationInfoRepository
                .findBySoldierId(id)
                .orElseThrow(() -> new UnexistingBlankException(id));


        List<File> files = fileService.getAllFilesBySoldierIdAndType(id, FileType.IMAGE);

        List<byte[]> images = files
                .stream()
                .map(file -> fileService.extractImageByUrl(file.getUrl()))
                .toList();

        return new BlankResponse(
                generalSoldierMedicalInfo.getLast4(),
                generalSoldierMedicalInfo.isMale(),
                generalSoldierMedicalInfo.isFemale(),
                generalSoldierMedicalInfo.getDateTimeCreation(),
                generalSoldierMedicalInfo.getForcesType(),
                generalSoldierMedicalInfo.getBloodType(),
                generalSoldierMedicalInfo.getAllergies(),

                specificSituationInfo.getFillingTime(),
                specificSituationInfo.getPulse(),
                specificSituationInfo.getBloodPressure(),
                specificSituationInfo.getBloodPressure(),
                specificSituationInfo.getRespiratoryDate(),
                specificSituationInfo.getAvpu(),
                specificSituationInfo.getPainScale(),

                soldierInjuriesTypes.isArtillery(),
                soldierInjuriesTypes.isBlunt(),
                soldierInjuriesTypes.isBurn(),
                soldierInjuriesTypes.isFall(),
                soldierInjuriesTypes.isGrenade(),
                soldierInjuriesTypes.isGsw(),
                soldierInjuriesTypes.isIed(),
                soldierInjuriesTypes.isLandmine(),
                soldierInjuriesTypes.isMvc(),
                soldierInjuriesTypes.isRpg(),
                soldierInjuriesTypes.getOther(),

                soldierInjuriesConcrete.getText(),

                images
        );
    }

    public void addBlankResponseBySoldierId(Integer id, BlankRequest blankRequest) {
        Soldier soldier = soldierService.getSoldierById(id);

        GeneralSoldierMedicalInfo generalSoldierMedicalInfo = new GeneralSoldierMedicalInfo();
        generalSoldierMedicalInfo.setLast4(blankRequest.getLast4());
        generalSoldierMedicalInfo.setMale(blankRequest.isMale());
        generalSoldierMedicalInfo.setFemale(blankRequest.isFemale());
        generalSoldierMedicalInfo.setDateTimeCreation(blankRequest.getDateTimeCreation());
        generalSoldierMedicalInfo.setForcesType(blankRequest.getForcesType());
        generalSoldierMedicalInfo.setBloodType(blankRequest.getBloodType());
        generalSoldierMedicalInfo.setAllergies(blankRequest.getAllergies());
        generalSoldierMedicalInfo.setSoldier(soldier);

        SoldierInjuriesConcrete soldierInjuriesConcrete = new SoldierInjuriesConcrete();
        soldierInjuriesConcrete.setText(blankRequest.getText());
        soldierInjuriesConcrete.setSoldier(soldier);

        SoldierInjuriesTypes soldierInjuriesTypes = new SoldierInjuriesTypes();
        soldierInjuriesTypes.setArtillery(blankRequest.isArtillery());
        soldierInjuriesTypes.setBlunt(blankRequest.isBlunt());
        soldierInjuriesTypes.setBurn(blankRequest.isBurn());
        soldierInjuriesTypes.setFall(blankRequest.isFall());
        soldierInjuriesTypes.setGrenade(blankRequest.isGrenade());
        soldierInjuriesTypes.setGsw(blankRequest.isGsw());
        soldierInjuriesTypes.setIed(blankRequest.isIed());
        soldierInjuriesTypes.setLandmine(blankRequest.isLandmine());
        soldierInjuriesTypes.setMvc(blankRequest.isMvc());
        soldierInjuriesTypes.setRpg(blankRequest.isRpg());
        soldierInjuriesTypes.setOther(blankRequest.getOther());
        soldierInjuriesTypes.setSoldier(soldier);

        SpecificSituationInfo specificSituationInfo = new SpecificSituationInfo();
        specificSituationInfo.setFillingTime(blankRequest.getFillingTime());
        specificSituationInfo.setPulse(blankRequest.getPulse());
        specificSituationInfo.setBloodPressure(blankRequest.getBloodPressure());
        specificSituationInfo.setRespiratoryDate(blankRequest.getRespiratoryDate());
        specificSituationInfo.setPulseOxO2Sat(blankRequest.getPulseOxO2Sat());
        specificSituationInfo.setAvpu(blankRequest.getAvpu());
        specificSituationInfo.setPainScale(blankRequest.getPainScale());
        specificSituationInfo.setSoldier(soldier);

        try {
            generalSoldierMedicalInfoRepository.save(generalSoldierMedicalInfo);
            soldierInjuriesConcreteRepository.save(soldierInjuriesConcrete);
            specificSituationInfoRepository.save(specificSituationInfo);
            soldierInjuriesTypesRepository.save(soldierInjuriesTypes);
        } catch (Exception e) {
            throw new ValidationException();
        }

    }
}
