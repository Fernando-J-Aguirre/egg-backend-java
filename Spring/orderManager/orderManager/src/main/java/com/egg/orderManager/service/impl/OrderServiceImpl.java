package com.egg.orderManager.service.impl;

import com.egg.orderManager.model.dto.NewOrderDTO;
//import com.egg.orderManager.model.dto.OrderDTO;
import com.egg.orderManager.model.dto.NewOrderDetailDTO;
import com.egg.orderManager.model.dto.ShowOrderDTO;
import com.egg.orderManager.model.entity.Client;
import com.egg.orderManager.model.entity.Order;
import com.egg.orderManager.model.entity.OrderDetail;
import com.egg.orderManager.model.entity.Product;
import com.egg.orderManager.repository.IClientRepository;
import com.egg.orderManager.repository.IOrderRepository;
import com.egg.orderManager.repository.IProductRepository;
import com.egg.orderManager.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IProductRepository productRepository;
    private final IClientRepository clientRepository;
    private final ModelMapper modelMapper;


    // DE ESTA MANERA DEBERÍA ENVIAR EN EL JSON EL OBJETO COMPLETO PORQUE EN EL DTO ESTOY MANDANDO UN CLIENT Y
    // UNA LISTA DE PRODUCTOS

//    @Transactional
//    @Override
//    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
//        System.out.println(orderDTO + " before creation");
//        if (Objects.nonNull(orderDTO)) {
//            if (orderDTO.getClient() == null) throw new IllegalArgumentException("El cliente no puede ser nulo");
//            if (orderDTO.getProducts() == null || orderDTO.getProducts().isEmpty())
//                throw new IllegalArgumentException("La orden debe tener al menos un producto");
//            System.out.println(orderDTO + " ORDER DTO");
//            Order order = modelMapper.map(orderDTO, Order.class);
//            order.setDate(LocalDate.now());
//            orderRepository.save(order);
//            System.out.println("Order: " + order);
//            return orderDTO;
//        } else {
//            throw new Exception("No se pudo crear la orden");
//        }
//    }


    // DE LA SIGUIENTE MANERA, MODIFICANDO EL DTO O AGREGANDO UNO ESPECÍFICO PARA CREAR QUE SOLO TENGA LOS TIPOS DE IDS,
    // EN EL JSON SOLO LE MANDO IDS
//    @Transactional
//    @Override
//    public OrderDTO createOrder(NewOrderDTO newOrderDTO) throws Exception {
//        if (Objects.nonNull(newOrderDTO)) {
//            Client client = clientRepository.findById(newOrderDTO.getClientId()).orElseThrow(() -> new Exception("No se encontró el cliente"));
//            List<Product> products = productRepository.findAllById(newOrderDTO.getProductsId());
//            if (products.isEmpty()) throw new Exception("No se encontraron productos con el/los ids proporcionados");
//            Integer quantity = newOrderDTO.getQuantity();
//            if (quantity == 0) throw new Exception("La cantidad de unidades del producto debe ser mayor a cero");
//            for (Product product : products) {
//                checkAndUpdateStock(product, quantity);
//            }
//            Order order = new Order(client, products, newOrderDTO.getQuantity());
//            order.setDate(LocalDate.now());
//            orderRepository.save(order);
//            return modelMapper.map(order, OrderDTO.class);
//        } else {
//            throw new Exception("No se pudo crear la orden");
//        }
//    }

    @Transactional
    @Override
    public ShowOrderDTO createOrder(NewOrderDTO newOrderDTO) throws Exception {
        if (Objects.nonNull(newOrderDTO)) {
            Client client = clientRepository.findById(newOrderDTO.getClientId()).orElseThrow(() -> new Exception("No se encontró el cliente"));
            List<NewOrderDetailDTO> newOrderDetailDTOS = newOrderDTO.getOrderDetails();
            if (newOrderDetailDTOS.isEmpty()) throw new Exception("La orden debe tener al menos 1 detalle");
            Order order = new Order();
            order.setClient(client);
            order.setDate(LocalDate.now());
            List<OrderDetail> orderDetailList = new ArrayList<>();
            for (NewOrderDetailDTO newOrderDetailDTO : newOrderDetailDTOS) {
                Product product = productRepository.findById(newOrderDetailDTO.getProductId())
                        .orElseThrow(() -> new Exception("No se encontró el producto con ese id"));
                Integer quantity = newOrderDetailDTO.getQuantity();
                checkAndUpdateStock(product, quantity);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setOrder(order);
                orderDetail.setQuantity(quantity);
                orderDetailList.add(orderDetail);
            }
            order.setOrderDetails(orderDetailList);
            orderRepository.save(order);
            return modelMapper.map(order, ShowOrderDTO.class);
        } else {
            throw new Exception("No se pudo crear la orden");
        }
    }

    @Override
    public List<ShowOrderDTO> getAllOrders() throws Exception {
        List<Order> orders = orderRepository.findAll();
        if (!orders.isEmpty()) {
            return orders.stream().map(order -> modelMapper.map(order, ShowOrderDTO.class)).toList();
        } else {
            throw new Exception("No se pudo obtener la lista de órdenes");
        }
    }

    @Override
    public ShowOrderDTO getOrderById(Long id) throws Exception {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new Exception("No se pudo obtener la orden con ese id"));
        return modelMapper.map(order, ShowOrderDTO.class);
    }

    @Transactional
    @Override
    public ShowOrderDTO updateOrder(Long id, NewOrderDTO newOrderDTO) throws Exception {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Client client = clientRepository.findById(newOrderDTO.getClientId()).orElseThrow(() -> new Exception("No se encontró el cliente"));
        List<NewOrderDetailDTO> newOrderDetailDTOs = newOrderDTO.getOrderDetails();
        if (newOrderDetailDTOs.isEmpty()) throw new Exception("No se encontraron detalles de la orden");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            for (int i = 0; i < newOrderDetailDTOs.size() ; i++) {
                Product product = productRepository.findById(newOrderDetailDTOs.get(i).getProductId())
                        .orElseThrow(() -> new Exception("No se encontró el producto con el id proporcionado"));
                Integer quantity = newOrderDetailDTOs.get(i).getQuantity();
                checkAndUpdateStock(product, quantity);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(order.getOrderDetails().get(i).getId());
                orderDetail.setProduct(product);
                orderDetail.setQuantity(quantity);
                orderDetail.setOrder(order);
                orderDetailList.add(orderDetail);
            }
            order.setClient(client);
            order.setOrderDetails(orderDetailList);
            orderRepository.save(order);
            return modelMapper.map(order, ShowOrderDTO.class);
        } else {
            throw new Exception("No se encontró la orden con el id: " + id + " para editar");
        }
    }

    private void checkAndUpdateStock(Product product, Integer quantity) throws Exception {
        Integer stock = product.getStock();
        if (stock <= 0 || quantity > stock)
            throw new Exception("Stock insuficiente del producto: " + product.getName());
        product.setStock(stock - quantity);
        productRepository.save(product);
    }
}
