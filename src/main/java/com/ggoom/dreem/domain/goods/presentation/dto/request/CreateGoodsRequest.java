package com.ggoom.dreem.domain.goods.presentation.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CreateGoodsRequest {
    private List<LocalDateTime> times;
}
