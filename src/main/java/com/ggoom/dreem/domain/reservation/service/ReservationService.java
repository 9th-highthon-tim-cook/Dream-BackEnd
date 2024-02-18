package com.ggoom.dreem.domain.reservation.service;

import com.ggoom.dreem.domain.goods.domain.Goods;
import com.ggoom.dreem.domain.goods.domain.repository.GoodsRepository;
import com.ggoom.dreem.domain.post.domain.Post;
import com.ggoom.dreem.domain.reservation.domain.Reservation;
import com.ggoom.dreem.domain.reservation.domain.repository.ReservationRepository;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final UserFacade userFacade;
    private final ReservationRepository reservationRepository;
    private final GoodsRepository goodsRepository;
    @Transactional
    public void createReservation(Post post, LocalDateTime time) {
        Goods goods = goodsRepository.findByPostAndTime(post, time);
        User user = userFacade.getCurrentUser(false);
        Reservation reservation = Reservation.builder()
                .time(time)
                .reservationPost(post)
                .reservationUser(user)
                .build();
        reservationRepository.save(reservation);
        goods.updateIsSold(true);

    }
}
