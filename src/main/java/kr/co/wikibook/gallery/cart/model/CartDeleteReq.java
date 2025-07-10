package kr.co.wikibook.gallery.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@AllArgsConstructor
public class CartDeleteReq {
    //    @JsonIgnore
    private Integer cartId;
    private Integer memberId;
    }
