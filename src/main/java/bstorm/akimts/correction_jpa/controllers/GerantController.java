package bstorm.akimts.correction_jpa.controllers;

import bstorm.akimts.correction_jpa.exceptions.ElementNotFoundException;
import bstorm.akimts.correction_jpa.metier.service.GerantService;
import bstorm.akimts.correction_jpa.models.dtos.ErrorDTO;
import bstorm.akimts.correction_jpa.models.dtos.GerantDTO;
import bstorm.akimts.correction_jpa.models.forms.GerantForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GerantController {

    private final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/gerant
    @GetMapping("/gerant")
    public List<GerantDTO> getAll(){
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id
    @GetMapping("/gerant/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident ){
        try{
//            return ResponseEntity.ok( service.getOne(ident) );
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from-controller", "GerantController")
                    .body( service.getOne(ident) );
        }
        catch (ElementNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("header-key", "value1", "value2")
                    .body( new ErrorDTO(ex.getMessage(),404,"/gerant/"+ident) );
        }
    }

    // POST - http://localhost:8080/gerant
    //      - http://localhost:8080/gerant/add
    @PostMapping( {"/gerant", "/gerant/add"} )
    public ResponseEntity<?> insert(@RequestBody  GerantForm form){
        try {
            return ResponseEntity.ok(service.insert(form));
        }
        catch (IllegalArgumentException ex){
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDTO(ex.getMessage(),"/gerant/add"));
        }
    }

}
