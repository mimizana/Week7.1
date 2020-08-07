package com.example.demo;


import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CloudinaryConfig cloudc;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "home";
    }

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {

        return "admin";
    }

    @RequestMapping("/showCategory/{id}")
    public String showcat(@PathVariable("id") Long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "showcat";
    }
    @PostMapping("/processBook")
    public String processBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());
        return "newBook";
    }
    @GetMapping("/add")
    public String newBook(Model model){
        model.addAttribute("book",new Book());
        return "newbook";
    }
    @PostMapping("/add")
    public  String processBook(@ModelAttribute Book book,
                                @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "redirect:/add";
        }
        try{
            Map uploadResult = cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            book.setImage(uploadResult.get("url").toString());
            bookRepository.save(book);
        }catch (IOException e){
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }
}




