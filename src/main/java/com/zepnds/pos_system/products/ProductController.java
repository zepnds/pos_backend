package com.zepnds.pos_system.products;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.zepnds.pos_system.products.exception.ProductErrorCreateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private  ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
       try {
           productDto = productService.saveProduct(productDto);
           CreateResponse<ProductDto> response = new CreateResponse<ProductDto>("Successfully created " + productDto.getName(), productDto, HttpStatus.OK);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }catch (ProductErrorCreateException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(@RequestParam Integer branchCode){
        try {
            List<ProductDto> productDtoList = productService.findAllProducts(branchCode);
            ResponseDto<ProductDto> response = new ResponseDto<ProductDto>("Successfully retrieve", productDtoList, HttpStatus.OK);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id){
            String message = productService.deleteProduct(id);
            CreateResponse<?> response = new CreateResponse<>(message, "Id " + id,HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @RequestParam Integer id ){
        ProductDto productUpdateDto = productService.updateProduct(productDto, id );
        CreateResponse<?> response = new CreateResponse<>("Successfully updated " + productUpdateDto.getName() , productUpdateDto,HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
