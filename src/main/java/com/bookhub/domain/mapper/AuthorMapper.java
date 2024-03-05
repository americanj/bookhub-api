package com.bookhub.domain.mapper;

import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.vo.AuthorVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class AuthorMapper {

    public abstract AuthorVo modelToVo(AuthorModel authorModel);
    public abstract AuthorModel voToModel(AuthorVo authorVo);
}
