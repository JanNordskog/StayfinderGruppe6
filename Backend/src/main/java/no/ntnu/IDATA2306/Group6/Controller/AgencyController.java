/**
 * The AgencyController class handles HTTP requests related to agencies.
 * It provides endpoints for retrieving, creating, updating, and deleting agencies.
 */
package no.ntnu.IDATA2306.Group6.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping
    @Operation(summary = "Get all agencies", description = "Retrieves all agencies stored in the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "All agencies returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agency.class)))
    })
    public Collection<Agency> getAllAgencies() {
        return agencies.values();
    }

    @PostMapping
    @Operation(summary = "Create a new agency", description = "Creates a new agency. Conflicts if agency with same ID already exists.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agency created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agency.class))),
            @ApiResponse(responseCode = "409", description = "Conflict, agency already exists")
    })
    public ResponseEntity<Agency> createAgency(@RequestBody Agency newAgency) {
        if (agencies.containsKey(newAgency.getAgencyID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        agencies.put(newAgency.getAgencyID(), newAgency);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgency);
    }

    @GetMapping("/{agencyId}")
    @Operation(summary = "Retrieve an agency by ID", description = "Retrieves an agency based on the provided ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agency found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agency.class))),
            @ApiResponse(responseCode = "404", description = "Agency not found")
    })
    public ResponseEntity<Agency> getAgency(@PathVariable String agencyId) {
        Agency agency = agencies.get(agencyId);
        if (agency != null) {
            return ResponseEntity.ok(agency);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{agencyId}")
    @Operation(summary = "Update an agency", description = "Updates an existing agency by ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agency updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agency.class))),
            @ApiResponse(responseCode = "404", description = "Agency not found")
    })
    public ResponseEntity<Agency> updateAgency(@PathVariable String agencyId, @RequestBody Agency updatedAgency) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.put(agencyId, updatedAgency);
        return ResponseEntity.ok(updatedAgency);
    }

    @DeleteMapping("/{agencyId}")
    @Operation(summary = "Delete an agency", description = "Deletes an agency by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Agency deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Agency not found")
    })
    public ResponseEntity<Void> deleteAgency(@PathVariable String agencyId) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.remove(agencyId);
        return ResponseEntity.noContent().build();
    }
}
