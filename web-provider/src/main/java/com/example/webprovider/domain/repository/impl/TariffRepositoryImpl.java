package com.example.webprovider.domain.repository.impl;

import com.example.webprovider.domain.model.Tariff;
import com.example.webprovider.domain.repository.TariffRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TariffRepositoryImpl implements TariffRepository {

    private final List<Tariff> tariffList = new ArrayList<>();

    @Override
    public Tariff getTariffById(Integer id) {
        return tariffList.stream()
                .filter(tariff -> tariff.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tariff doesn't exist!!!"));
    }

    @Override
    public Tariff getTariffByCategoryName(String categoryName) {
        return tariffList.stream()
                .filter(tariff -> tariff.getCategory().getName().equals(categoryName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no such tariff in this Category"));
    }

    @Override
    public List<Tariff> getAllTariffs() {
        return new ArrayList<>(tariffList);
    }

    @Override
    public Tariff createTariff(Tariff tariff) {
        tariff.setId(tariffList.size() + 1);
        tariffList.add(tariff);
        return tariff;
    }

    @Override
    public Tariff updateTariff(Integer id, Tariff tariff) {
        Tariff currentTariff = tariffList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tariff doesn't exist!!!"));
        tariffList.remove(currentTariff);
        tariff.setId(currentTariff.getId());
        tariffList.add(tariff);
        return tariff;
    }

    @Override
    public void deleteTariff(Integer id) {
        tariffList.removeIf(tariff -> tariff.getId().equals(id));
    }
}
