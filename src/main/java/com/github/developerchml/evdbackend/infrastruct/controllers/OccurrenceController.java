package com.github.developerchml.evdbackend.infrastruct.controllers;

import com.github.developerchml.evdbackend.core.services.OccurrenceService;
import com.github.developerchml.evdbackend.infrastruct.requests.RequestOccurrenceDTO;
import com.github.developerchml.evdbackend.infrastruct.responses.ResponseOccurrenceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/occurrences")
public class OccurrenceController implements CRUDController<RequestOccurrenceDTO, ResponseOccurrenceDTO, Long> {

    private final OccurrenceService occurrenceService;

    public OccurrenceController(OccurrenceService occurrenceService) {
        this.occurrenceService = occurrenceService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ResponseOccurrenceDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(occurrenceService.findById(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ResponseOccurrenceDTO>> listAll() {
        return ResponseEntity.ok(occurrenceService.listAll());
    }

    @PostMapping
    @Override
    public ResponseEntity<ResponseOccurrenceDTO> save(@RequestBody RequestOccurrenceDTO dto) {
        System.out.println(dto);
        return ResponseEntity.ok(occurrenceService.save(dto));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ResponseOccurrenceDTO> update(@PathVariable Long id, @RequestBody RequestOccurrenceDTO dto) {
        return ResponseEntity.ok(occurrenceService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        occurrenceService.softDelete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/force-delete")
    @Override
    public ResponseEntity<Void> forceDelete(@PathVariable Long id) {
        occurrenceService.forceDelete(id);
        return ResponseEntity.noContent().build();
    }
}
