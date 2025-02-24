package com.neuroscan.service;

import com.neuroscan.model.HealthData;
import com.neuroscan.repository.HealthDataRepository;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class CSVImportService {

    private static final Logger logger = LoggerFactory.getLogger(CSVImportService.class);
    
    private final HealthDataRepository healthDataRepository;

    public CSVImportService(HealthDataRepository healthDataRepository) {
        this.healthDataRepository = healthDataRepository;
    }

    @Transactional
    public void importCSVData(String filePath) {
        try {
            // Vérifier l'existence du fichier CSV
            if (!Files.exists(Paths.get(filePath))) {
                logger.error("Fichier CSV non trouvé : " + filePath);
                return;
            }
            logger.info("Fichier CSV détecté : " + filePath);

            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            // Si votre CSV utilise un séparateur différent, par exemple ';', vous pouvez le préciser ici.
            CSVReader csvReader = new CSVReader(reader);

            // Lire l'en-tête du CSV
            String[] header = csvReader.readNext();
            if (header == null) {
                logger.error("Le fichier CSV est vide ou ne contient pas d'en-tête.");
                csvReader.close();
                return;
            }
            logger.info("En-tête CSV : " + Arrays.toString(header));

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                logger.info("Nombre de colonnes lues: " + line.length + " | Contenu: " + Arrays.toString(line));
                try {
                    // Vérifier que le nombre de colonnes correspond à l'attendu (ici 13 colonnes)
                    if (line.length < 13) {
                        logger.error("Ligne incomplète, colonne(s) manquante(s) : " + Arrays.toString(line));
                        continue;
                    }
                    
                    HealthData healthData = new HealthData();
                    // On ignore la première colonne (ID) pour laisser SQL Server générer l'ID automatiquement.
                    healthData.setGender(line[1].trim());
                    healthData.setAge(Integer.parseInt(line[2].trim()));
                    healthData.setOccupation(line[3].trim());
                    healthData.setSleepDuration(Double.parseDouble(line[4].trim()));
                    
                    // Traitement de la colonne "Quality of Sleep" (index 5)
                    String qualityStr = line[5].trim();
                    int qualityOfSleep = qualityStr.isEmpty() ? 0 : Integer.parseInt(qualityStr);
                    healthData.setQualityOfSleep(qualityOfSleep);
                    
                    healthData.setPhysicalActivityLevel(Integer.parseInt(line[6].trim()));
                    healthData.setStressLevel(Integer.parseInt(line[7].trim()));
                    healthData.setBmiCategory(line[8].trim());
                    healthData.setBloodPressure(line[9].trim());
                    healthData.setHeartRate(Integer.parseInt(line[10].trim()));
                    healthData.setDailySteps(Integer.parseInt(line[11].trim()));
                    healthData.setSleepDisorder(line[12].trim());

                    healthDataRepository.save(healthData);
                    logger.info("Enregistrement inséré pour la ligne (ID généré automatiquement)");
                } catch (Exception ex) {
                    logger.error("Erreur lors de l'insertion de la ligne : " + Arrays.toString(line), ex);
                }
            }
            csvReader.close();
            reader.close();
            logger.info("Importation du CSV terminée avec succès.");
        } catch (Exception e) {
            logger.error("Erreur lors de l'import du CSV", e);
        }
    }
}
