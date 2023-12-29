package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Room;
import peaksoft.service.impl.RoomServiceImpl;

    @Controller
    @RequestMapping("/room")
    public class RoomController {
        private final RoomServiceImpl roomService;
        @Autowired
        public RoomController(RoomServiceImpl roomService) {
            this.roomService = roomService;
        }



        @GetMapping("/save")
        public String save(Model model) {
            Room room=new Room();
            model.addAttribute("room", room);
            return "RoomHtml/room";
        }

        @PostMapping("/save_place")
        public String saveUser(@ModelAttribute Room room) {
            roomService.save(room);
            return "redirect:room/room";
        }

        @GetMapping("/find_all")
        public String findAll(Model model) {
            model.addAttribute("all_rooms", roomService.findAll());
            return "RoomHtml/all_rooms";
        }

        @GetMapping("/find_by_id/{id}")
        public String findById(@PathVariable int id, Model model) {
            model.addAttribute("find_by_id", roomService.findById(id));
            return "RoomHtml/find_by_id";
        }

        @GetMapping("/update/{id}")
        public String update(Model model, @PathVariable int id) {
            Room room= roomService.findById(id);
            model.addAttribute("room", room);
            return "RoomHtml/update_room";
        }

        @PostMapping("/merge_update/{id}")
        public String mergeUpdate(@ModelAttribute Room room, @PathVariable int id) {
            roomService.update(id, room);
            return "redirect:/room/find_all";
        }


        @GetMapping("/delete_by_id/{id}")
        public String deleteById(@PathVariable int id) {
            roomService.deleteById(id);
            return "redirect:/room/find_all";
        }
    }

