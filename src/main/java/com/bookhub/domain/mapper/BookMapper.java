package com.bookhub.domain.mapper;


import com.bookhub.domain.model.BookModel;
import com.bookhub.domain.vo.BookVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class BookMapper {
    public abstract BookVo modelToVo(BookModel bookModel);
}
