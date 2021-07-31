package com.kitteless.kittelessfront.presenter;

import lombok.Getter;

@Getter
public class StampPresenter {

    private String stampCode;

    public StampPresenter(String stampCode) {
        this.stampCode = stampCode;
    }

    public String formattedStampCode() {
        return String.format("%,d", Integer.parseInt(this.stampCode)).replaceAll(",", " - ");
    }
}
