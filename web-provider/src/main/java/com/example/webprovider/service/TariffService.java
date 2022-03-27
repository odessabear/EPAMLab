package com.example.webprovider.service;

import com.example.webprovider.service.dto.TariffDTO;

import java.util.List;

public interface TariffService {

    TariffDTO getTariffById(Integer id);

    List<TariffDTO> getTariffsByCategoryName(String categoryName);

    TariffDTO createTariff(TariffDTO tariffDTO);

    TariffDTO updateTariff(Integer id, TariffDTO tariffDTO);

    void deleteTariff(Integer id);
}
