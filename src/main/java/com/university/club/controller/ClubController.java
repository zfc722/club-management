package com.university.club.controller;

import com.github.pagehelper.PageInfo;
import com.university.club.model.Club;
import com.university.club.service.ClubService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String category,
                       Model model, HttpSession session) {
        // simple session check
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        PageInfo<Club> pageInfo = clubService.search(name, category, page, size);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("name", name);
        model.addAttribute("category", category);
        return "club/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        if (id != null) {
            Club club = clubService.findById(id);
            model.addAttribute("club", club);
        }
        return "club/edit";
    }

    @PostMapping("/save")
    public String save(Club club, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        clubService.save(club);
        return "redirect:/clubs";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        clubService.delete(id);
        return "redirect:/clubs";
    }
}
