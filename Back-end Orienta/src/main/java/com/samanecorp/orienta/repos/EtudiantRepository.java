package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.EtatDossier;
import com.samanecorp.orienta.entities.Etudiant;
import com.samanecorp.orienta.entities.Formation;
import com.samanecorp.orienta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    //recherche un etudiant en fonction de son email
    @Query("SELECT e FROM Etudiant e , User u WHERE e.user.email = :email and u.id = e.user.id")
    public Etudiant findByEmail(String email);

    //recupere un etudiant en fonction de son ID
    @Query("SELECT e FROM EtatDossier e  WHERE e.id = :id")
    public EtatDossier getEtatDossier(@Param("id") int id);

    //recupere le nombre d'etudiants
    @Query("select count(id) from Etudiant")
    public int CountEtudiant();

    @Query("SELECT e FROM Etudiant e, DossierEtudiant de  where de.etudiant.id=e.id and de.numero=:numero")
    public Etudiant getEtudiantByNumeroDossier(String numero);

    @Query("SELECT e FROM Etudiant e, Demande d where d.etudiant.id=e.id and d.matricule=:matricule")
    public Etudiant getEtudiantByMatriculeDemande(String matricule);

    @Query("SELECT e FROM Etudiant e where e.numero=:numero")
    public Etudiant getEtudiantByNumero(String numero);
}
