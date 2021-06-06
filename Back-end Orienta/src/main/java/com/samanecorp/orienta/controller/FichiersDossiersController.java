package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.FichiersDossiers;
import com.samanecorp.orienta.repos.FichiersDossiersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class FichiersDossiersController {

    // Windows: C:/Users/{user}/test
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/test";

    @Autowired
    private FichiersDossiersRepository fichiersDossiersRepository;

    @GetMapping("/fichiersDossiers")
    public List<FichiersDossiers> getAllFichiersDossiers() {
        return fichiersDossiersRepository.findAll();
    }

    @GetMapping("/fichiersDossiers/{id}")
    public ResponseEntity<FichiersDossiers> getFichiersDossiersById(@PathVariable(value = "id") int fichierDossierId)
            throws ResourceNotFoundException {
        FichiersDossiers fichiersDossiers = fichiersDossiersRepository.findById(fichierDossierId)
                .orElseThrow(() -> new ResourceNotFoundException("Fichier Dossier not found for this id :: " + fichierDossierId));
        return ResponseEntity.ok().body(fichiersDossiers);
    }

    @PostMapping("/fichiersDossiers")
    public FichiersDossiers createFichierDossier(@Valid @RequestBody FichiersDossiers fichiersDossiers) {
        return fichiersDossiersRepository.save(fichiersDossiers);
    }

    @PutMapping("/fichiersDossiers/{id}")
    public ResponseEntity<FichiersDossiers> updateFichierEtudiant(@PathVariable(value = "id") int fichierDossierId,
                                                   @Valid @RequestBody FichiersDossiers FichiersDossiersDetails) throws ResourceNotFoundException {
        FichiersDossiers fichiersDossiers = fichiersDossiersRepository.findById(fichierDossierId)
                .orElseThrow(() -> new ResourceNotFoundException("Fichier Dossier not found for this id :: " + fichierDossierId));

        fichiersDossiers.setLibelle(FichiersDossiersDetails.getLibelle());
        fichiersDossiers.setFiles(FichiersDossiersDetails.getFiles());
        fichiersDossiers.setEtat(FichiersDossiersDetails.getEtat());

        final FichiersDossiers updatedFichierDossier = fichiersDossiersRepository.save(fichiersDossiers);
        return ResponseEntity.ok(updatedFichierDossier);
    }

    @DeleteMapping("/fichiersDossiers/{id}")
    public Map<String, Boolean> deleteFichierEtudiant(@PathVariable(value = "id") int fichierDossierId)
            throws ResourceNotFoundException {
        FichiersDossiers fichiersDossiers = fichiersDossiersRepository.findById(fichierDossierId)
                .orElseThrow(() -> new ResourceNotFoundException("Fichier Dossier not found for this id :: " + fichierDossierId));

        fichiersDossiersRepository.delete(fichiersDossiers);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/upload")
    public String uploadFiles()
    {
        return "upload";
    }

    @PostMapping("/fichiersDossiers/uploadMultiFiles")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute FichiersDossiers form) {

        System.out.println("Description:" + form.getLibelle());
        String result = null;
        try {
            result = this.saveUploadedFiles(form.getFiles());
        }
        // Here Catch IOException only.
        // Other Exceptions catch by RestGlobalExceptionHandler class.
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Uploaded to: <br/>" + result, HttpStatus.OK);
    }

    // Save Files
    private String saveUploadedFiles(MultipartFile[] files) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();
        StringBuilder sb = new StringBuilder();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            String uploadFilePath = UPLOAD_DIR + "/upload" + file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
            sb.append(uploadFilePath).append("<br/>");
        }
        return sb.toString();
    }

    /**
     * Get fichiers dossiers by DossierId
     * @param id
     * @return
     */
    @GetMapping("/fichiersDossiers/dossiers/{id}")
    public List<FichiersDossiers> getFichiersDossiers(@PathVariable(value = "id") int id)  {
        List<FichiersDossiers> fichiersDossiers = fichiersDossiersRepository.getfichiersDossiers(id);
        return fichiersDossiers;
    }

}
