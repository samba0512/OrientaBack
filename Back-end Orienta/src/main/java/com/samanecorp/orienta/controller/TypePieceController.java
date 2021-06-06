package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.TypePiece;
import com.samanecorp.orienta.repos.TypePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class TypePieceController {

    @Autowired
    private TypePieceRepository typePieceRepository;

    /**
     * Get all type piece
     * @return
     */
    @GetMapping("/typePieces")
    public List<TypePiece> getAllTypePiece() {
        return typePieceRepository.findAll();
    }

    /**
     * Get type piece by Id
     * @param TypePieceId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/typePieces/{id}")
    public ResponseEntity<TypePiece> getTypePieceById(@PathVariable(value = "id") int TypePieceId)
            throws ResourceNotFoundException {
        TypePiece typePiece = typePieceRepository.findById(TypePieceId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Piece not found for this id :: " + TypePieceId));
        return ResponseEntity.ok().body(typePiece);
    }

    /**
     * Ajouter un type piece
     * @param typePiece
     * @return
     */
    @PostMapping("/typePieces")
    public TypePiece createTypePiece(@Valid @RequestBody TypePiece typePiece) {
        return typePieceRepository.save(typePiece);
    }

    /**
     * Update un type piece
     * @param TypePieceId
     * @param TypePieceDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/typePieces/{id}")
    public ResponseEntity<TypePiece> updateTypePiece(@PathVariable(value = "id") int TypePieceId,
                                             @Valid @RequestBody TypePiece TypePieceDetails) throws ResourceNotFoundException {
        TypePiece typePiece = typePieceRepository.findById(TypePieceId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Piece not found for this id :: " + TypePieceId));

        //typePiece.setLibelle(TypePieceDetails.getLibelle());

        final TypePiece updatedTypePiece = typePieceRepository.saveAndFlush(TypePieceDetails);
        return ResponseEntity.ok(updatedTypePiece);
    }

    /**
     * Delete un type piece
     * @param TypePieceId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/typePieces/{id}")
    public Map<String, Boolean> deleteTypePiece(@PathVariable(value = "id") int TypePieceId)
            throws ResourceNotFoundException {
        TypePiece typePiece = typePieceRepository.findById(TypePieceId)
                .orElseThrow(() -> new ResourceNotFoundException("Type Piece not found for this id :: " + TypePieceId));

        typePieceRepository.delete(typePiece);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
