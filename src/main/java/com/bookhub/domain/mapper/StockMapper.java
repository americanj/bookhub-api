package com.bookhub.domain.mapper;

import com.bookhub.domain.model.StockModel;
import com.bookhub.domain.response.StockResponse;
import com.bookhub.domain.vo.StockVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class StockMapper {
    
    public abstract StockVo modelToVo(StockModel stockModel);

    public abstract StockResponse voToResponse(StockVo stockVo);

}
