package com.bookhub.domain.mapper;

import com.bookhub.domain.model.StockModel;
import com.bookhub.domain.request.StockIdRequest;
import com.bookhub.domain.response.StockResponse;
import com.bookhub.domain.vo.StockVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class StockMapper {
    
    public abstract StockVo modelToVo(StockModel stockModel);

    public abstract StockResponse voToResponse(StockVo stockVo);

    public List<StockVo> modelsToVos(List<StockModel> stockModels) {
        return stockModels.stream().map(this::modelToVo).collect(Collectors.toList());
    }
    public List<StockResponse> vosToResponses(List<StockVo> stockVos) {
        return stockVos.stream().map(this::voToResponse).collect(Collectors.toList());
    }
}
