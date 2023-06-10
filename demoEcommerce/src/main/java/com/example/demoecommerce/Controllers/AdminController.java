package com.example.demoecommerce.Controllers;

import com.example.demoecommerce.Entities.Category;
import com.example.demoecommerce.Entities.Product;

import com.example.demoecommerce.Service.CategoryService;
import com.example.demoecommerce.Service.ProductService;
import com.example.demoecommerce.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/ProductImages";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ProductService productService;

    //Category Section//
    @GetMapping("/admin")
    public String admin(){

        return "admin";
    }

    @GetMapping("/admin/categories")
    public String getCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());

        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String GetcategoriesAdd(Model model){
        model.addAttribute("category", new Category());

        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String PostcategoriesAdd(@ModelAttribute("category") Category category){
        categoryService.AddCategory(category);

        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
         categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category=categoryService.getCategoryById(id);

        if(category.isPresent()){
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }else{
            return "404";
        }
    }
    //Category Section END//
    // product Section Start//
    @GetMapping("/admin/products")
    public String product(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String productsAddGet(Model model){
        model.addAttribute("ProductDTO",new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());

        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAdd(@ModelAttribute("productDTO")ProductDTO productDTO, @RequestParam("ProductImages")MultipartFile file,@RequestParam("imgName")String imgname) throws IOException {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());

        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());

        }else{
            imageUUID = imgname;
        }
        product.setImageName(imageUUID);
        productService.productAdd(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable int id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO= new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO",productDTO);



        return "productsAdd";

    }



}
