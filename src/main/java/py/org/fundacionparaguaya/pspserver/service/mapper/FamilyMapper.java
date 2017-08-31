package py.org.fundacionparaguaya.pspserver.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.org.fundacionparaguaya.pspserver.domain.FamilyEntity;
import py.org.fundacionparaguaya.pspserver.service.common.BaseMapper;
import py.org.fundacionparaguaya.pspserver.service.dto.FamilyDTO;

/**
 *  Created by jaimeferreira on 8/31/2017
 */
@Component
public class FamilyMapper implements BaseMapper<FamilyEntity, FamilyDTO> {

	private final ModelMapper modelMapper;
	 
	public FamilyMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<FamilyDTO> entityListToDtoList(List<FamilyEntity> entityList) {
		 return entityList.stream()
	                .filter(Objects::nonNull)
	                .map(this::entityToDto)
	                .collect(Collectors.toList());
	}

	@Override
	public FamilyDTO entityToDto(FamilyEntity entity) {
		FamilyDTO dto = modelMapper.map(entity, FamilyDTO.class);
	    return dto;
	}

	@Override
	public FamilyEntity dtoToEntity(FamilyDTO dto) {
		return modelMapper.map(dto, FamilyEntity.class);
	}

}
