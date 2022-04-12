package com.example.feedback.controller;

import com.example.feedback.model.Product;
import com.example.feedback.model.Review;
import com.example.feedback.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("product")
public class ProductController {

        @Autowired
        private ProductService productService;

        @RequestMapping(method = RequestMethod.GET)
        public  String index(ModelMap modelMap){
            modelMap.put("products",productService.findAll());
            return "product/index";
    }

    @RequestMapping(value = "detail/{id}",method = RequestMethod.GET)
    public  String detail(@PathVariable("id") int id, ModelMap modelMap) {
        Product product = productService.find(id);
        modelMap.put("product", product);
        Review review = new Review();

        review.setProduct(product);
        modelMap.put("review",review);
        return "product/detail";
    }

    @RequestMapping(value = "detsadail/{id}",method = RequestMethod.GET)
    public  String detail1(@PathVariable("id") int id, ModelMap modelMap) {
        Product product = productService.find(id);
        modelMap.put("product", product);
        Review review = new Review();

        review.setProduct(product);
        modelMap.put("review",review);
        return "product/detail";
    }

}

