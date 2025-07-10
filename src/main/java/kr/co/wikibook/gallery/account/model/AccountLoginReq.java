package kr.co.wikibook.gallery.account.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLoginReq {
    private String name;
    private String loginId;
    private String loginPw;
}
