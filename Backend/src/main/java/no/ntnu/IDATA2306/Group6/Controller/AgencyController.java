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

    private final Map<String, Agency> agencies = new HashMap<>();

    @GetMapping
    public Collection<Agency> getAllAgencies() {
        return agencies.values();
    }

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency newAgency) {
        if (agencies.containsKey(newAgency.getAgencyID())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        agencies.put(newAgency.getAgencyID(), newAgency);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgency);
    }

    @GetMapping("/{agencyId}")
    public ResponseEntity<Agency> getAgency(@PathVariable String agencyId) {
        Agency agency = agencies.get(agencyId);
        if (agency != null) {
            return ResponseEntity.ok(agency);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{agencyId}")
    public ResponseEntity<Agency> updateAgency(@PathVariable String agencyId, @RequestBody Agency updatedAgency) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.put(agencyId, updatedAgency);
        return ResponseEntity.ok(updatedAgency);
    }

    @DeleteMapping("/{agencyId}")
    public ResponseEntity<Void> deleteAgency(@PathVariable String agencyId) {
        if (!agencies.containsKey(agencyId)) {
            return ResponseEntity.notFound().build();
        }
        agencies.remove(agencyId);
        return ResponseEntity.noContent().build();
    }
}
