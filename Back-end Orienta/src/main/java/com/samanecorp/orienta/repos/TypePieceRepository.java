package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.TypePiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePieceRepository extends JpaRepository<TypePiece, Integer> {
}
