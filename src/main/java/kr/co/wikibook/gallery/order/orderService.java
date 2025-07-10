package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.item.itemMapper;
import kr.co.wikibook.gallery.order.model.OrderPostDto;
import kr.co.wikibook.gallery.order.model.OrderPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class orderService {
    private final itemMapper itemMapper;
    private final orderMapper orderMapper;

    public int saveOrder(OrderPostReq dto) {
        // 상품 정보 DB로부터 가져온다.

        return 1;

    }
}

