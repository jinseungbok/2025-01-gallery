package kr.co.wikibook.gallery.order;

import kr.co.wikibook.gallery.order.model.OrderGetRes;
import kr.co.wikibook.gallery.order.model.OrderPostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface orderMapper {
    int save(OrderPostDto dto);

}
