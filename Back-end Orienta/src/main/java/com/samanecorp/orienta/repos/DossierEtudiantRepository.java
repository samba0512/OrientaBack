package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.DossierEtudiant;
import com.samanecorp.orienta.entities.EtatDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierEtudiantRepository extends JpaRepository<DossierEtudiant, Integer> {

    @Query("SELECT d FROM DossierEtudiant d , EtatDossier e WHERE d.etatDossier.id = :id and e.id = d.etatDossier.id")
    List<DossierEtudiant> getDossierByEtat(@Param("id") int id);

    @Query("SELECT max(id) FROM DossierEtudiant")
    public int getMaxIdDossier();

    @Query("SELECT d FROM DossierEtudiant d , Etudiant e WHERE d.etudiant.id = :id and e.id = d.etudiant.id")
    public DossierEtudiant getDossierByEtudiant(@Param("id") int id);

    //recupere le nombre de dossiers etudiants
    @Query("select count(id) from DossierEtudiant")
    public int CountDossierEtudiant();

    @Query("select d from EtatDossier d, DossierEtudiant de,Etudiant e where e.id = de.etudiant.id and de.etudiant.id=:idEtudiant and d.id=de.etatDossier.id")
    public EtatDossier getEtatDossierByIDEtudiant(@Param("idEtudiant") int idEtudiant);



}
