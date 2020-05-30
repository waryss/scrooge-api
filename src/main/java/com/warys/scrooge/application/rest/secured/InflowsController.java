package com.warys.scrooge.application.rest.secured;

import com.warys.scrooge.infrastructure.repository.mongo.entity.InflowDocument;
import com.warys.scrooge.domain.model.user.Session;
import com.warys.scrooge.domain.service.budget.InflowService;
import com.warys.scrooge.infrastructure.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/me/inflows")
public final class InflowsController {

    private final InflowService inflowService;

    @GetMapping("")
    public ResponseEntity<List<InflowDocument>> getAllInflows(@AuthenticationPrincipal final Session me) {
        return new ResponseEntity<>(inflowService.getAll(me), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InflowDocument> getInflow
            (@AuthenticationPrincipal final Session me, @PathVariable String id) throws ApiException {
        return new ResponseEntity<>(inflowService.retrieve(me, id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<InflowDocument> createInflow
            (@AuthenticationPrincipal final Session me, @Valid @RequestBody final InflowDocument newInflow) {
        return new ResponseEntity<>(inflowService.create(me, newInflow), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InflowDocument> updateInflow
            (@AuthenticationPrincipal final Session me, @PathVariable String id, @Valid @RequestBody final InflowDocument newInflow) {
        return new ResponseEntity<>(inflowService.update(me, id, newInflow), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InflowDocument> partialUpdateInflow
            (@AuthenticationPrincipal final Session me, @PathVariable String id, @Valid @RequestBody final InflowDocument partialNewInflow) throws ApiException {
        InflowDocument updatedInflow = inflowService.partialUpdate(me, id, partialNewInflow);
        return new ResponseEntity<>(updatedInflow, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InflowDocument> deleteInflow
            (@AuthenticationPrincipal final Session me, @NotNull @PathVariable String id) throws ApiException {
        inflowService.remove(me, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}