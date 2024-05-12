/**
 * The AgencyController class handles HTTP requests related to agencies.
 * It provides endpoints for retrieving, creating, updating, and deleting agencies.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.ntnu.IDATA2306.Group6.Entity.Agency;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/agencies")
public class AgencyController {

    // Stores agencies with their IDs as keys
    private final Map<String, Agency> agencies = new HashMap<>();

    /**
     * Retrieves all agencies.
     *
     * @return A collection of all agencies
     */
    @GetMapping
    public Collection<Agency> getAllAgencies() {
        return agencies.values();
    }

    /**
     * Creates a new agency.
     *
     * @param newAgency The agency to create
     * @return ResponseEntity containing the created agency or status conflict if the agency already exists
     */
    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency newAgency) {
        if (agencies.containsKey(newAgency.getAgencyID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        agencies.put(newAgency.getAgencyID(), newAgency);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgency);
    }

    /**
     * Retrieves an agency by its ID.
     *
     * @param agencyId The ID of the agency to retrieve
     * @return ResponseEntity containing the agency if found, otherwise not found status
     */
    @GetMapping("/{agencyId}")
    public ResponseEntity<Agency> getAgency(@PathVariable String agencyId) {
        Agency agency = agencies.get(agencyId);
        if (agency != null) {
            return ResponseEntity.ok(agency);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates an existing agency.
     *
     * @param agencyId      The ID of the agency to update
     * @param updatedAgency The updated agency object
     * @return ResponseEntity containing the updated agency if found, otherwise not found status
     */
    @PutMapping("/{agencyId}")
    public ResponseEntity<Agency> updateAgency(@PathVariable String agencyId, @RequestBody Agency updatedAgency) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.put(agencyId, updatedAgency);
        return ResponseEntity.ok(updatedAgency);
    }

    /**
     * Deletes an agency by its ID.
     *
     * @param agencyId The ID of the agency to delete
     * @return ResponseEntity indicating success or failure of the deletion
     */
    @DeleteMapping("/{agencyId}")
    public ResponseEntity<Void> deleteAgency(@PathVariable String agencyId) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.remove(agencyId);
        return ResponseEntity.noContent().build();
    }
}
