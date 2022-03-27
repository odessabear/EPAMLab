package com.example.webprovider.domain.repository;


import com.example.webprovider.domain.model.Tariff;

import java.util.List;

public interface TariffRepository {

    Tariff getTariffById(Integer id);

    Tariff getTariffByCategoryName(String categoryName);

    List<Tariff> getAllTariffs();

    Tariff createTariff(Tariff tariff);

    Tariff updateTariff(Integer id, Tariff tariff);

    void deleteTariff(Integer id);
}