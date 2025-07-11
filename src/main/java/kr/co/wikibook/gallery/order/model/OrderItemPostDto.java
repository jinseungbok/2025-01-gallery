package kr.co.wikibook.gallery.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class OrderItemPostDto {
    private int orderId;
    private List<Integer> itemIds;
}
