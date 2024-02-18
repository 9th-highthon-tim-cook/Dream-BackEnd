package com.ggoom.dreem.domain.goods.service;

import com.ggoom.dreem.domain.goods.domain.Goods;
import com.ggoom.dreem.domain.goods.domain.repository.GoodsRepository;
import com.ggoom.dreem.domain.goods.presentation.dto.request.CreateGoodsRequest;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.enums.UserType;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createGoods(LocalDateTime time) {
        User user = userFacade.getCurrentUser(false);
        if (!user.getUserType().equals(UserType.MENTOR)) {
            throw new RuntimeException("멘토만 상품을 등록할 수 있습니다.");
        }
        Goods goods = Goods.builder()
                .time(time)
                .mentor(user.getMentorList().get(0))
                .isSold(false)
                .build();
        goodsRepository.save(goods);
    }

    public void createGoodsList(CreateGoodsRequest request) {
        for (LocalDateTime time : request.getTimes()) {
            createGoods(time);
        }
    }
}
