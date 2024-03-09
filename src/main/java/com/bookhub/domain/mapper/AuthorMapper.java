package com.bookhub.domain.mapper;

import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.request.AuthorRequest;
import com.bookhub.domain.response.AuthorResponse;
import com.bookhub.domain.vo.AuthorVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class AuthorMapper {

    public abstract AuthorVo modelToVo(AuthorModel authorModel);
    public List<AuthorVo> modelsToVos(List<AuthorModel> authorModels) {
        return authorModels.stream().map(this::modelToVo).collect(Collectors.toList());
    }
    public abstract AuthorModel voToModel(AuthorVo authorVo);
    public abstract AuthorVo requestToVo(AuthorRequest authorRequest);
    public abstract AuthorResponse voToResponse(AuthorVo authorVo);
    public List<AuthorResponse> vosToResponses(List<AuthorVo> authorVos) {
        return authorVos.stream().map(this::voToResponse).collect(Collectors.toList());
    }
    @Mapping(target = "id", source = "authorId")
    public abstract AuthorVo resquestToVo(AuthorRequest authorRequest, Long authorId);
    public abstract AuthorResponse modelToResponse(AuthorModel author);
}
