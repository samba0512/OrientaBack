package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.DossierEtudiant;
import com.samanecorp.orienta.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
    /**
    Get formation by university email
    @Param email
    */
    @Query("SELECT f FROM Formation f WHERE f.universite.user.email = :email ")
    List<Formation> getFormationsUniversite(@Param("email") String email);
    /**
    Get formation in university
     */
    @Query("SELECT f FROM Formation f , Universite u where f.universite.id = u.id")
    public List<Formation> getAllUniversiteFormation();

    /**
     * find formations by all params
     * @param formationNiveauId
     * @param formationTypeFormationId
     * @param formationUniversiteId
     * @return List Of Formation
     */

    @Query("SELECT f FROM Formation f where f.niveau.id=?1 and f.typeFormations.id=?2 and f.universite.id=?3")
    public List<Formation> getFormationsByParams(int formationNiveauId,int formationTypeFormationId,int formationUniversiteId);


    /**
     * get all formations by two params
     * @param formationNiveauId
     * @param formationTypeFormationId
     * @return List of Formation
     */
    @Query("SELECT f FROM Formation f where f.niveau.id=?1 and f.typeFormations.id=?2 ")
    public List<Formation> getFormationsByParamsNiveauAndTypeFormation(int formationNiveauId,int formationTypeFormationId);

    /**
     * get all formations by two params
     * @param formationNiveauId
     * @param formationUniversiteId
     * @return List of Formation
     */
    @Query("SELECT f FROM Formation f where f.niveau.id=?1 and f.universite.id=?2 ")
    public List<Formation> getFormationsByParamsNiveauIdAndUniversiteId(int formationNiveauId,int formationUniversiteId);


    /**
     * get all formations by two params
     * @param typeFormationNiveauId
     * @param formationUniversiteId
     * @return List of Formation
     */
    @Query("SELECT f FROM Formation f where f.typeFormations.id=?1 and f.universite.id=?2 ")
    public List<Formation> getFormationsByParamsTypeFormationIdAndUniversiteId(int typeFormationNiveauId,int formationUniversiteId);


    /**
     * find all formations by the niveauId
     * @param formationNiveauId
     * @return list of Formations
     */
    @Query("SELECT f FROM Formation f where f.niveau.id=?1 ")
    public List<Formation> getFormationsByNiveauId(int formationNiveauId);

    /**
     * find all formations by TypeFormationId
     * @param formationTypeFormationId
     * @return List of formations
     */

    @Query("SELECT f FROM Formation f where  f.typeFormations.id=?1 ")
    public List<Formation> getFormationsByTypeFormationId(int formationTypeFormationId);


    /**
     * find all formations by Universite Id
     * @param formationUniversiteId
     * @return List of Formations
     */
    @Query("SELECT f FROM Formation f where  f.universite.id=?1 ")
    public List<Formation> getFormationsByUniversiteId(int formationUniversiteId);

    //recupere le nombre de formations
    @Query("select count(id) from Formation")
    public int CountFormation();
}
