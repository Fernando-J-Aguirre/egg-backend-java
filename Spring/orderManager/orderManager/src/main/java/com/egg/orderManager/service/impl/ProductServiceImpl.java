package com.egg.orderManager.service.impl;

import com.egg.orderManager.model.dto.ProductDTO;
import com.egg.orderManager.model.entity.Product;
import com.egg.orderManager.repository.IProductRepository;
import com.egg.orderManager.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        if (Objects.nonNull(productDTO)) {
            if (productDTO.getName() == null || productDTO.getName().trim().isEmpty())
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            if (productDTO.getPrice() == null) throw new IllegalArgumentException("El precio no puede estar vacío");
            if (productDTO.getStock() == null) throw new IllegalArgumentException("El stock no puede estar vacío");
            Product product = modelMapper.map(productDTO, Product.class);
            productRepository.save(product);
            return productDTO;
        } else {
            throw new Exception("No se pudo crear el producto");
        }
    }

    @Override
    public List<ProductDTO> getAllProducts() throws Exception {
        List<Product> products = productRepository.findAll();
        if(!products.isEmpty()) {
            return products.stream().map((product) -> modelMapper.map(product, ProductDTO.class)).toList();
        } else {
            throw new Exception("No se pudo obtener la lista de clientes");
        }
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()) {
            return modelMapper.map(productOpt.get(), ProductDTO.class);
        } else {
            throw new Exception("No se encuentra el producto con ese id");
        }
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) throws Exception {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()) {
            Product product = modelMapper.map(productDTO, Product.class);
            product.setId(id);
            productRepository.save(product);
            return productDTO;
        } else {
            throw new Exception("No se encuentra el producto con ese id");
        }
    }
}
