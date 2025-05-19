package com.greenacademy.controller;

import com.greenacademy.model.ProductRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping(value = {"", "/index"})
    public String index() {
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        ProductRequest request = new ProductRequest();
        model.addAttribute("product", request);
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") ProductRequest product, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (product.getProductId().equals("SP001")) {
            bindingResult.addError(new FieldError("product", "productId", "Id already exist!"));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "product/create";
        } else {
            if (product.getImage() != null) {
                try {
                    byte[] bytes = product.getImage().getBytes();
                    String UPLOAD_DIR = "/WEB-INF/classes/static/uploads/";
                    String uploadFolder = request.getServletContext().getRealPath(UPLOAD_DIR);
                    Path path = Paths.get(uploadFolder + product.getImage().getOriginalFilename());
                    Files.write(path, bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return "redirect:/product";
        }
    }
}
