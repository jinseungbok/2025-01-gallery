package kr.co.wikibook.gallery.order;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.account.etc.AccountConstants;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> add(HttpServletRequest httpReq, @RequestBody OrderPostReq req) {
        int logginedMemberId = (int) HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        log.info("req: {}", req);
        int result = orderService.saveOrder(req, logginedMemberId);
        return ResponseEntity.ok(result);
    }
    @GetMapping
    public ResponseEntity findAllByMemberIdOrderByIdDesc(HttpServletRequest httpReq) {
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        List<OrderGetRes> result = orderService.findAllByMemberIdOrderByIdDesc(logginedMemberId);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<?> findDetail(HttpServletRequest httpReq, @PathVariable int orderId) {
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        OrderDetailGetReq req = new OrderDetailGetReq();
        req.setOrderId(orderId);
        req.setMemberId(logginedMemberId);
        OrderDetailGetRes result = orderService.detail(req);
        return ResponseEntity.ok(result);
    }
}
