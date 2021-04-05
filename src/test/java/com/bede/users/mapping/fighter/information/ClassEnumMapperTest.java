package com.bede.users.mapping.fighter.information;

import com.bede.users.entities.fighter.information.ClassEnum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClassEnumMapperTest {

    private final ClassEnumMapper mapper = new ClassEnumMapper();

    @Test
    void simpleMapping() {
        ClassEnum classEnum = mapper.mapToEnum("no class");
        assertThat(classEnum).isEqualTo(ClassEnum.NO_CLASS);
    }
}