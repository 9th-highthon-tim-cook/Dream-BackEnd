package com.ggoom.dreem.domain.goods.presentation;

import com.ggoom.dreem.domain.goods.presentation.dto.request.CreateGoodsRequest;
import com.ggoom.dreem.domain.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping()
    public void createGoods(@RequestBody CreateGoodsRequest request) {
        goodsService.createGoodsList(request);
    }
}
