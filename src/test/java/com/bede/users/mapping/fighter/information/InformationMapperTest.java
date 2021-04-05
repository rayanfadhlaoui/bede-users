package com.bede.users.mapping.fighter.information;

import com.bede.users.dto.fighter.InformationDto;
import com.bede.users.entities.fighter.information.InformationEntity;
import com.bede.users.entities.fighter.information.ClassEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class InformationMapperTest {
    @InjectMocks
    private InformationMapperImpl mapper;

    @Mock
    private ClassEnumMapper classEnumMapper;
    @Mock
    private RaceEnumMapper raceEnumMapper;
    @Mock
    private GenderEnumMapper genderEnumMapper;

    @Test
    void simpleMapping() {
        InformationDto informationDto = new InformationDto();
        informationDto.setFighterClass("no class");
        given(classEnumMapper.mapToEnum("no class")).willReturn(ClassEnum.NO_CLASS);
        InformationEntity informationEntity = mapper.mapToEntity(informationDto);
        assertThat(informationEntity.getClassEnum()).isEqualTo(ClassEnum.NO_CLASS);
    }
}