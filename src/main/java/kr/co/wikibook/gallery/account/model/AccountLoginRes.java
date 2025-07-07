package kr.co.wikibook.gallery.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class AccountLoginRes {
    private int id;
    @JsonIgnore
    private String loginPw;
    // json 동작시 loginPw 빠짐
}
