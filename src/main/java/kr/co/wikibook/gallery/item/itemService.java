package kr.co.wikibook.gallery.item;


import kr.co.wikibook.gallery.item.model.itemGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class itemService {
    private final itemMapper itemMapper;

    public List<itemGetRes> findAll(List<Integer> ids) {
        return itemMapper.findAllByIdIn(ids);
    }
}
