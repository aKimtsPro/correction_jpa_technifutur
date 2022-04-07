package bstorm.akimts.correction_jpa.controllers;


import bstorm.akimts.correction_jpa.exceptions.ElementNotFoundException;
import bstorm.akimts.correction_jpa.metier.service.spec.HotelService;
import bstorm.akimts.correction_jpa.models.dtos.ErrorDTO;
import bstorm.akimts.correction_jpa.models.dtos.HotelDTO;
import bstorm.akimts.correction_jpa.models.forms.HotelInsertForm;
import bstorm.akimts.correction_jpa.models.forms.HotelUpdateForm;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public HotelDTO getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @GetMapping
    public List<HotelDTO> getAll(){
        return service.getAll();
    }

    @GetMapping(params = "minEtoiles")
    public List<HotelDTO> getAllMinEtoiles(@RequestParam Byte minEtoiles){
        return service.getAvecMinEtoile(minEtoiles);
    }

    @PostMapping
    public HotelDTO insert(@RequestBody HotelInsertForm form){
        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public HotelDTO delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public HotelDTO update(@PathVariable Long id, @RequestBody HotelUpdateForm form){
        return service.update(id, form);
    }

    @PatchMapping("/{id}")
    public HotelDTO updateGerant(@PathVariable Long id, @RequestParam("gerant_id") Long gerantId ){
        return service.updateGerant(id, gerantId);
    }



}
