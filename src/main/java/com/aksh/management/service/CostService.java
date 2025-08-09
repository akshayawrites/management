package com.aksh.management.service;
import com.aksh.management.CustomException.InvalidInputException;
import com.aksh.management.CustomException.ResourceNotFoundException;
import com.aksh.management.model.Cost;
import com.aksh.management.model.Product;
import com.aksh.management.pojo.CostDTO;
import com.aksh.management.repository.CostRepository;
import com.aksh.management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CostService {
    private final CostRepository costRepository;
    private final ProductRepository productRepository;
    public CostService(CostRepository costRepository,ProductRepository productRepository) {
        this.costRepository = costRepository;
        this.productRepository=productRepository;
    }

    public List<CostDTO>  getAllCost() {

        List<Cost> listofCosts = costRepository.findAll();
        List<CostDTO> costDTOs = new ArrayList<>();
        for (Cost cost : listofCosts) {
            CostDTO  costDTO = new CostDTO();
            costDTO.setId(cost.getId());
            costDTO.setQuantity(cost.getQuantity());
            costDTO.setProductId(cost.getProduct().getId());
            costDTO.setTotal_price(cost.getTotal_price());
            costDTOs.add(costDTO);

            System.out.println(cost);
            // product.setDescription(product.getDescription()+" Akshaya");
        }
        return costDTOs;
    }

    public Cost saveCost(CostDTO costDto) {
        try{
            Cost cost=convertCostDTOtoCost(costDto);
            return costRepository.save(cost);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("not saved");
        }
//       return costRepository.save(cost);
    }

//    private Cost convertCostDTOtoCost(CostDTO costDto) {
//        Cost cost=new Cost();
//        Optional<Product> product=productRepository.findById(costDto.getProduct_id());
//        if(product.isPresent()){
//            cost.setProduct(product.get());
//        }
//        cost.setQuantity(costDto.getQuantity());
//        cost.setTotal_price(costDto.getTotal_price());
//        return cost;
//    }

    private Cost convertCostDTOtoCost(CostDTO costDto) {
        Product product = productRepository.findById(costDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product with ID " + costDto.getProductId() + " not found"));

        Cost cost = new Cost();
        cost.setProduct(product);
        cost.setQuantity(costDto.getQuantity());
        cost.setTotal_price(costDto.getTotal_price());

        return cost;
    }



    public Cost getCostById(Long id) {
        try{
            return costRepository.findById(id).orElse(null);
        }catch (InvalidInputException e){
            throw new InvalidInputException("not saved");
        }
//        return costRepository.findById(id).orElse(null);
    }

    public void deleteCost(Long id) {
        try{
            costRepository.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("not saved");
        }
//        costRepository.deleteById(id);
    }
}
