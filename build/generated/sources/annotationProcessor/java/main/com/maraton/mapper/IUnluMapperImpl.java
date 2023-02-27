package com.maraton.mapper;

import com.maraton.dto.request.UnluOlusturRequestDto;
import com.maraton.repository.entity.Unlu;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T15:18:49+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IUnluMapperImpl implements IUnluMapper {

    @Override
    public Unlu toUnlu(UnluOlusturRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Unlu.UnluBuilder<?, ?> unlu = Unlu.builder();

        unlu.state( dto.isState() );
        unlu.name( dto.getName() );
        unlu.image( dto.getImage() );
        unlu.özellik1( dto.getÖzellik1() );
        unlu.özellik2( dto.getÖzellik2() );
        unlu.özellik3( dto.getÖzellik3() );

        return unlu.build();
    }
}
