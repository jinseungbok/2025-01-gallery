package kr.co.wikibook.gallery.item;

import kr.co.wikibook.gallery.item.model.itemGetRes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface itemMapper {
    List<itemGetRes> findAllByIdIn(List<Integer> ids);
}
