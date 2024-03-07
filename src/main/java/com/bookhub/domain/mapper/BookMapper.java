package com.bookhub.domain.mapper;


import com.bookhub.domain.model.BookModel;
import com.bookhub.domain.response.BookResponse;
import com.bookhub.domain.vo.BookVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class BookMapper {

    @Mapping(source = "author", target = "author")
    public abstract BookVo modelToVo(BookModel bookModel);

    public abstract BookResponse voToResponse(BookVo bookVo);
}
