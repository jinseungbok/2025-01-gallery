package kr.co.wikibook.gallery.cart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartPostReq {
    private int itemId;
    private int memberId;
}
