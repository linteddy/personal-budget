package demo.budgetapp.web.rest;

import demo.budgetapp.domain.Budget;
import demo.budgetapp.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@RestController
@RequestMapping(value = "/api/budgets",
        produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(allowedHeaders = {"*"})
public class BudgetResource {

    private final Logger logger = LoggerFactory.getLogger(BudgetResource.class);

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public ResponseEntity<List<Budget>> findAll() {
        logger.debug("REST request to find all budgets....");
        List<Budget> result = budgetService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Budget>> findOne(@PathVariable(name = "id") Long id) {
        logger.debug("REST request to find budget.... {" + id + "}");
        Optional<Budget> result = budgetService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBudget(@RequestBody @Valid Budget budget) {
        budgetService.deleteBudget(budget);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
