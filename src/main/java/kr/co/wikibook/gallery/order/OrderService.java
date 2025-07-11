package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.cart.CartMapper;
import kr.co.wikibook.gallery.item.itemMapper;
import kr.co.wikibook.gallery.item.model.itemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final itemMapper itemMapper;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final CartMapper cartMapper;

    @Transactional
    public int saveOrder(OrderPostReq req, int logginedMemberId) {
        // 상품 정보 DB로부터 가져온다.
        List<itemGetRes> itemList  = itemMapper.findAllByIdIn(req.getItemIds());
        log.info("itemList: {}", itemList);

        // 총 구매가격 콘솔에 출력
        long totalPrice = 0;
        for(itemGetRes item : itemList) {
            totalPrice += item.getPrice() - (item.getPrice() * item.getDiscountPer() / 100);
        }
        log.info("totalPrice: {}", totalPrice);

        /* OrderPostDto에 @Setter, @AllArgumentContructor 적용했을 때
        // orderPostDto 객체화, 데이터 삽입
        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setMemberId(logginedMemberId);
        orderPostDto.setName(req.getName());
        orderPostDto.setAddress(req.getAddress());
        orderPostDto.setPayment(req.getPayment());
        orderPostDto.setCardNumber(req.getCardNumber());
        orderPostDto.setAmount(totalPrice);
        */

        // OrderPostDto에 @Builder 적용했을 때
        OrderPostDto orderPostDto = OrderPostDto.builder()
                .memberId(logginedMemberId)
                .name(req.getName())
                .address(req.getAddress())
                .payment(req.getPayment())
                .cardNumber(req.getCardNumber())
                .amount(totalPrice)
                .build();
        log.info("before-orderPostDto={}", orderPostDto);
        orderMapper.save(orderPostDto);
        log.info("after-orderPostDto={}", orderPostDto);

        // OrderItemPostDto 객체화, 데이터 삽입
        OrderItemPostDto orderItemPostDto = new OrderItemPostDto(orderPostDto.getOrderId(), req.getItemIds());
        orderItemMapper.save(orderItemPostDto);

        cartMapper.deleteByMemberId(logginedMemberId);

        return 1;
    }
    public List<OrderGetRes> findAllByMemberIdOrderByIdDesc(int memberId) {
        return orderMapper.findAllByMemberIdOrderByIdDesc(memberId);
    }
    public OrderDetailGetRes detail(OrderDetailGetReq req) {
        OrderDetailGetRes result = orderMapper.findByOrderIdAndMemberId(req);
        List<OrderDetailDto> items = orderItemMapper.findAllByOrderId(req.getOrderId());
        log.info("result={}", result);
        return result;
    }
}