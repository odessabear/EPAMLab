package com.example.webprovider.domain.mapper;

import com.example.webprovider.domain.model.Tariff;
import com.example.webprovider.service.dto.TariffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffMapper {

    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);

    TariffDTO tariffToTariffDTO(Tariff tariff);

    Tariff tariffDTOToTariff(TariffDTO tariffDTO);

    List<TariffDTO> tariffsToTariffsDTO(List<Tariff> tariffs);
}
