package com.samanecorp.orienta.repos;

import java.util.List;

import com.samanecorp.orienta.entities.Demande;
import com.samanecorp.orienta.entities.EtatDossier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {

   /**
    * get demandes by university email
    * @param idEtatDossier
    * @param email
    * @return
    */
   @Query("SELECT d FROM Demande d where d.universite.user.email=:email and d.dossierEtudiant.etatDossier.id=:idEtatDossier and d.etat=1")
   public List<Demande> getDemandeByEMailUniversite(@Param("idEtatDossier") int idEtatDossier,
         @Param("email") String email);

   /**
    * get les demandes soumises
    * @param email
    * @return
    */
   @Query("select d from Demande d where d.universite.user.email=:email and d.dossierEtudiant.etatDossier.id=4 and d.etat=1")
   public List<Demande> getDemandeSoumis(@Param("email") String email);

   /**
    * get demandes soumises by id university
    * @param id
    * @return
    */
   @Query("select d from Demande d where d.universite.id=:idUniversity and d.dossierEtudiant.etatDossier.id=4")
   public List<Demande>  getDemandeSoumisByIdUniversite(@Param("idUniversity") int id);

   /**
    * get demande by id etudiant
    * @param id
    * @return
    */
   @Query("select d from Demande d where d.etudiant.id=:idEtudiant")
   public List<Demande> getDemandeByEtudiantId(@Param("idEtudiant") int id);

   /**
    * get all demandes soumises
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=4")
   public List<Demande> getDemandeSoumisAdmin();

   /**
    * get demandes acceptées
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=1")
   public List<Demande> getDemandeAcceptesAdmin();

   /**
    * get demandes en attente de validation
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=2")
   public List<Demande> getDemandeEnAttenteValidation();

   /**
    * get demandes en attente de complément
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=5")
   public List<Demande> getDemandeEnAttenteComplement();

   /**
    * get demandes en cours de création
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=6")
   public List<Demande> getDemandeEnCoursDeCreation();

   /**
    * get demandes en attente de paiement
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=3")
   public List<Demande> getDemandeComplets();

   /**
    * get demandes rejetés
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=7")
   public List<Demande> getDemandeRejetes();

   /**
    * get demande by id
    * @param id
    * @return
    */
   @Query("select d from Demande d where d.id=:id")
   public Demande getDemande(@Param("id") int id);

   /**
    * get etat dossier by Id
    * @param id
    * @return
    */
   @Query("select d from EtatDossier d where d.id=:id")
   public EtatDossier getEtatDossier(@Param("id") int id);

   /**
    * get max id demande
    * @return
    */
   @Query("SELECT max(id) FROM Demande")
   public int getMaxIdDemande();

   /**
    * get demande by id etudiant
    * @param id
    * @return
    */
   @Query("SELECT d FROM Demande d , Etudiant e WHERE d.etudiant.id = :id and e.id = d.etudiant.id")
   public Demande getDemandeByEtudiant(@Param("id") int id);

   /**
    * recupere le nombre de demandes
    * @return
    */
   @Query("select count(id) from Demande")
   public int CountDemande();

   /**
    * nombres de demandes soumises aux universités
    * @return
    */
   @Query("select count(id) from Demande d where d.dossierEtudiant.etatDossier.id=4")
   public int CountDemandeSoumisesUniversite();

   /**
    * nombres de demandes en attente de validation
    * @return
    */
   @Query("select count(id) from Demande d  where d.dossierEtudiant.etatDossier.id=2")
   public int CountDemandeEnAttenteV();

   /**
    * nombres de demandes en attente de compément
    * @return
    */
   @Query("select count(id) from Demande d  where d.dossierEtudiant.etatDossier.id=5")
   public int CountDemandeEnAttenteC();

   /**
    * requete pour recuperer les 5 dernieres demandes en attente de validation
    * @param pageable
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=2 ORDER BY id DESC")
   public List<Demande> getDernieresDemandeEnAttenteValidation(Pageable pageable);

   /**
    * requete pour recuperer les 5 dernieres demandes en attente de complément
    * @param pageable
    * @return
    */
   @Query("select d from Demande d where d.dossierEtudiant.etatDossier.id=5 ORDER BY id DESC")
   public List<Demande> getDernieresDemandeEnAttenteComplement(Pageable pageable);

   /**
    * get all demande soumis à une université en particulier
    * @param id
    * @return
    */
   @Query("select count(id) from Demande d where d.universite.id=:idUniversity and d.dossierEtudiant.etatDossier.id=4")
   public int CountDemandeSoumisByIdUniversite(@Param("idUniversity") int id);
}
