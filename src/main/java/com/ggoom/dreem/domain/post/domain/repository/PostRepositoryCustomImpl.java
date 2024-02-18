//package com.ggoom.dreem.domain.post.domain.repository;
//
//import com.ggoom.dreem.domain.post.presenstation.dto.response.PostListResponse;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.core.types.dsl.Expressions;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static com.ggoom.dreem.domain.goods.domain.QGoods.goods;
//import static com.ggoom.dreem.domain.post.domain.QPost.post;
//
//@Repository
//@RequiredArgsConstructor
//@Primary
//public class PostRepositoryCustomImpl implements PostRepositoryCustom {
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public List<PostListResponse> findAll(String career, LocalDateTime date, LocalDateTime date2) {
//        BooleanExpression careerExpression = eqCareer(career);
//        BooleanExpression dateExpression = eqDate(date, date2);
//
//        return queryFactory.query()
//                .select(post)
//                .from(post)
//                .innerJoin(goods).on(post.id.eq(goods.post.id))
//                .fetch()
//                .stream()
//                .map(PostListResponse::of)
//                .toList();
//    }
//
//
//    private BooleanExpression eqCareer(String career) {
//        if (career == null || career.isBlank()) {
//            return null; // Changed to return a neutral expression
//        }
//        return post.author.career.contains(career);
//    }
//
//    private BooleanExpression eqDate(LocalDateTime date, LocalDateTime date2) {
//        if (date == null) {
//            return null; // Changed to return a neutral expression
//        }
//        return goods.time.between(date, date2);
//    }
//}
