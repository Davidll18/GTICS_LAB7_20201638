package com.example.gtics_lab7_20201638.controller;

import com.example.gtics_lab7_20201638.entity.Technician;
import com.example.gtics_lab7_20201638.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final TechnicianRepository technicianRepository;

    public HomeController(TechnicianRepository technicianRepository){

        this.technicianRepository = technicianRepository;
    }
    @RequestMapping(value = "/")
    public String paginaPrincipal(){

        return "pagina/gticsf";
    }
    @RequestMapping("/listaTec")
    public String listaTec(Model model){
        List<Technician> tecList = technicianRepository.findAll();
        model.addAttribute("tecList", tecList);

        return "pagina/tecnico";


    }
    @RequestMapping("/editarTecnico")
    public String editarTecnico(Model model, @RequestParam("id") String idStr){
        try{
            int id = Integer.parseInt(idStr);
            if (id <= 0 || !technicianRepository.existsById(id)) {
                return "redirect:/listaTec";
            }
            Optional<Technician> optTec = technicianRepository.findById(id);
            if(optTec.isPresent()){
                Technician technician = optTec.get();
                model.addAttribute("technician", technician);
                return "pagina/editarTec";
            }else {
                return "redirect:/listaTec";
            }
        } catch (NumberFormatException e) {
            return "redirect:/listaTec";
        }

    }

    @GetMapping("/new")
    public String nuevoTec() {
        return "pagina/newFrm";
    }

    @PostMapping("/save")
    public String guardarTec(@Valid Technician technician, BindingResult bindingResult, RedirectAttributes attr) {
        if(technician.getId() == 0){
            attr.addAttribute("msg","Tecnico creado extitosamente ");
        }
        else{
            attr.addAttribute("msg","Tecnico modificado extitosamente ");
        }
        technicianRepository.save(technician);
        return "redirect:/listaTec";

    }
//    @GetMapping("/delete")
//    public String borrarEquipo(Model model,
//                                      @RequestParam("id") int id,
//                                      RedirectAttributes attr) {
//
//        Optional<Device> optD = deviceRepository.findById(id);
//
//        if (optD.isPresent()) {
//            deviceRepository.deleteById(id);
//            attr.addFlashAttribute("msg", "Transportista borrado exitosamente");
//        }
//        return "redirect:/equipos";
//
//    }
}
