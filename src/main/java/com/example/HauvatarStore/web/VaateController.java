package com.example.HauvatarStore.web;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HauvatarStore.domain.Garmet;
import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.ManufacturerRepository;

@Controller
public class VaateController {
    @Autowired
    private GarmetRepository garmetRepository;
    @Autowired
    private ManufacturerRepository mrepository;

    @RequestMapping(value = { "/home", "/index" })
    public String homepage(Model model) {
        return "/homepage";
    }

    @RequestMapping(value = { "/clothes", "/clothelist" })
    public String garmetList(Model model) {
        model.addAttribute("clothes", garmetRepository.findAll());
        return "/clothelist";
    }

    @RequestMapping(value = { "/clothesByManufacturer/{manufacturer}" })
    public String garmetListByManufacturer(@PathVariable("manufacturer") String manufacturer, Model model) {
        model.addAttribute("clothes", garmetRepository.findByManufacturer(manufacturer));
        return "/clothelist";
    }

    @RequestMapping(value = "/add")
    public String addGarmet(Model model) {
        model.addAttribute("garmet", new Garmet());
        model.addAttribute("manufacturers", mrepository.findAll());
        return "/addClothe";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("garmet") @Valid Garmet garmet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", mrepository.findAll());
            return "/addClothe";
        }
        garmetRepository.save(garmet);
        return "redirect:/clothes";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGarmet(@PathVariable("id") Long garmetId, Model model) {
        garmetRepository.deleteById(garmetId);
        return "redirect:/clothes";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGarmet(@PathVariable("id") Long garmetId, Model model) {
        model.addAttribute("garmet", garmetRepository.findById(garmetId));
        model.addAttribute("manufacturers", mrepository.findAll());
        return "/editClothe";
    }
    
    //REST FUNCTIONALITY---------------------------------------------------------------------------------------------------------------------------------------------
    
    @GetMapping(value = { "/getAllClothes" })
    public @ResponseBody List<Garmet> getAllClothes() {
        return (List<Garmet>) garmetRepository.findAll();
    }
    
    @GetMapping(value = { "/getClothe/{id}" })
    public @ResponseBody Optional<Garmet> getClotheById(@PathVariable("id") Long garmetId) {
    	return garmetRepository.findById(garmetId);
    }
    
    @PostMapping(value = { "/postNewClothe" })
    public ResponseEntity<Garmet> postNewClothe(@RequestBody Garmet newGarmet) {
    	Garmet savedGarmet = garmetRepository.save(newGarmet);
    	return ResponseEntity.created(URI.create(String.format("/garmet/%s", newGarmet.getId()))).body(savedGarmet);
    }
    
    @DeleteMapping(value = { "/deleteClothe/{id}" })
    public @ResponseBody void deleteClotheById(@PathVariable("id") Long garmetId) {
        garmetRepository.deleteById(garmetId);
    }
    
    @PutMapping(value = { "/putClothe/{id}" })
    public ResponseEntity<?> editClotheById(@RequestBody Garmet newGarmet, @PathVariable Long id) {
    	try {
    		newGarmet.setId(id);            
            garmetRepository.save(newGarmet);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
