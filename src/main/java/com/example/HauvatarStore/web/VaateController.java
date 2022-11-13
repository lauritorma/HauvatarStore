package com.example.HauvatarStore.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.HauvatarStore.domain.Garmet;
import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.ManufacturerRepository;

@Controller
public class VaateController {
    @Autowired
    private GarmetRepository garmetRepository;
    @Autowired
    private ManufacturerRepository mrepository;

    @RequestMapping(value = { "/main", "/home", "/index", "/" })
    public String homepage(Model model) {
        return "/homepage";
    }

    @RequestMapping(value = { "/clothes", "/clothelist" })
    public String garmetList(Model model) {
        model.addAttribute("clothes", garmetRepository.findAll());
        return "/clothelist";
    }

    // Hae kaikki jonkun valmistajan vaatteet
    @RequestMapping(value = { "/clothesByManufacturer/{manufacturer}" })
    public String garmetListByManufacturer(@PathVariable("manufacturer") String manufacturer, Model model) {
        model.addAttribute("clothes", garmetRepository.findByManufacturer(manufacturer));
        return "/clothelist";
    }

    @RequestMapping(value = "/garmets", method = RequestMethod.GET)
    public @ResponseBody List<Garmet> garmetListRest() {
        return (List<Garmet>) garmetRepository.findAll();
    }

    @RequestMapping(value = "/garmet/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Garmet> findGarmetRest(@PathVariable("id") Long garmetId) {
        return garmetRepository.findById(garmetId);
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
}
