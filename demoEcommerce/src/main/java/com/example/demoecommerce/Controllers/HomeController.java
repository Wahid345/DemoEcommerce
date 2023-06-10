package com.example.demoecommerce.Controllers;

import com.example.demoecommerce.Service.CategoryService;
import com.example.demoecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String goHome(Model model){


        return "home";
    }

    @GetMapping("/shop")
    public String shop(Model model){
    model.addAttribute("categories", categoryService.getAllCategory());
    model.addAttribute("products",productService.getAllProduct());

        return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllproductByCategoryId(id));

        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product",productService.getProductById(id).get());

        return "viewProduct";
    }


}
