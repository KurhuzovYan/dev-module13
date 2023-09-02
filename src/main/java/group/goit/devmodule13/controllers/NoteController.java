package group.goit.devmodule13.controllers;

import group.goit.devmodule13.entities.Note;
import group.goit.devmodule13.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/list")
    public ModelAndView getListOfNotes() {
        ModelAndView model = new ModelAndView("notes/main-page");
        model.addObject("notes", noteService.listAll());
        return model;
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam("id") Long id) {
        ModelAndView edit = new ModelAndView("notes/editing-page");
        Note byId = noteService.getById(id);
        edit.addObject("note", byId);
        return edit;
    }

    @PostMapping(path = "/edit")
    public String updateNote(@ModelAttribute("note") Note updateNote) {
        noteService.update(updateNote);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/create")
    public String createNote() {
        return "notes/creating-new-node-page";
    }

    @PostMapping(path = "/create")
    public String updateListOfNodes(@ModelAttribute("note") Note newNote) {
        noteService.add(newNote);
        return "redirect:/note/list";
    }
}
