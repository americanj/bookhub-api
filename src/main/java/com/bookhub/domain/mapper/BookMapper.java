package com.bookhub.domain.mapper;

import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.model.BookModel;
import com.bookhub.domain.model.StockModel;
import com.bookhub.domain.request.AuthorIdRequest;
import com.bookhub.domain.request.BookRequest;
import com.bookhub.domain.request.StockIdRequest;
import com.bookhub.domain.response.BookResponse;
import com.bookhub.domain.vo.BookVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class BookMapper {

    @Mapping(source = "author", target = "author")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "price", target = "price")
    public abstract BookVo modelToVo(BookModel bookModel);
    public abstract BookResponse voToResponse(BookVo bookVo);
    public abstract BookResponse voToResponse2(BookVo bookVo);
    public List<BookVo> modelsToVos(List<BookModel> bookModels) {
        return bookModels.stream().map(this::modelToVo).collect(Collectors.toList());
    }
    public List<BookResponse> vosToResponses(List<BookVo> bookVos) {
        return bookVos.stream().map(this::voToResponse).collect(Collectors.toList());
    }
    @Mapping(target = "author.id", source = "authorId")
    @Mapping(target = "stock.id", source = "stockId")
    public abstract BookVo requestToVo(BookRequest bookRequest);

    public abstract BookModel voToModel(BookVo bookVo);

    @Mapping(target = "price", source = "price")
    public abstract BookModel requestToModel(BookRequest bookRequest);
}
