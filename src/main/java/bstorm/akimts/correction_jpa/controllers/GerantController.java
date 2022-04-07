package bstorm.akimts.correction_jpa.controllers;

import bstorm.akimts.correction_jpa.exceptions.ElementNotFoundException;
import bstorm.akimts.correction_jpa.metier.service.spec.GerantService;
import bstorm.akimts.correction_jpa.models.dtos.ErrorDTO;
import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.forms.GerantForm;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gerant")
public class GerantController {

    private final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/gerant
    @GetMapping
    public List<GerantDTO> getAll(){
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id
    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GerantDTO> getOne(@PathVariable(name = "id") Long ident ){
//        return ResponseEntity.ok( service.getOne(ident) );
        return ResponseEntity.status(HttpStatus.OK)
                .header("from-controller", "GerantController")
                .body( service.getOne(ident) );
    }

    // POST - http://localhost:8080/gerant
    //      - http://localhost:8080/gerant/add
    @PostMapping( {"", "/add"} )
    public ResponseEntity<GerantDTO> insert(@Valid @RequestBody GerantForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GerantDTO> update(@Valid @RequestBody GerantForm form,@PathVariable Long id){
        return ResponseEntity.ok( service.update(id, form) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GerantDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok( service.delete(id) );
    }



}
