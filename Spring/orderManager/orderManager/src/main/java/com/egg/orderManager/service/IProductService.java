package com.egg.orderManager.service;

import com.egg.orderManager.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO createProduct(ProductDTO productDTO) throws Exception;
    public List<ProductDTO> getAllProducts() throws Exception;
    public ProductDTO getProductById(Long id) throws Exception;
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) throws Exception;

}
