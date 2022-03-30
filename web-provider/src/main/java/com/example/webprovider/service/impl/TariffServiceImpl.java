package com.example.webprovider.service.impl;

import com.example.webprovider.domain.mapper.TariffMapper;
import com.example.webprovider.domain.model.Tariff;
import com.example.webprovider.domain.repository.TariffRepository;
import com.example.webprovider.service.TariffService;
import com.example.webprovider.service.dto.TariffDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Override
    public TariffDTO getTariffById(Integer id) {
        Tariff tariff = tariffRepository.getTariffById(id);
        return TariffMapper.INSTANCE.tariffToTariffDTO(tariff);
    }

    @Override
    public List<TariffDTO> getTariffsByCategoryName(String categoryName) {
        List<Tariff> tariffList = tariffRepository.getAllTariffs();
        Optional.ofNullable(categoryName)
                .ifPresent((name) -> tariffList.removeIf(tariff -> !tariff.getCategory()
                        .getName().equals(name)));
        return tariffList.stream()
                .map(TariffMapper.INSTANCE::tariffToTariffDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TariffDTO createTariff(TariffDTO tariffDTO) {
        log.info(this.getClass().getSimpleName() + " createTariff()");
        Tariff tariff = TariffMapper.INSTANCE.tariffDTOToTariff(tariffDTO);
        tariff = tariffRepository.createTariff(tariff);
        return TariffMapper.INSTANCE.tariffToTariffDTO(tariff);
    }

    @Override
    public TariffDTO updateTariff(Integer id, TariffDTO tariffDTO) {
        log.info(this.getClass().getSimpleName() + " updateTariff()");
        Tariff tariff = TariffMapper.INSTANCE.tariffDTOToTariff(tariffDTO);
        tariff = tariffRepository.updateTariff(id, tariff);
        return TariffMapper.INSTANCE.tariffToTariffDTO(tariff);
    }

    @Override
    public void deleteTariff(Integer id) {
        tariffRepository.deleteTariff(id);
        log.info("Tariff with id {} was deleted", id);
    }
}
