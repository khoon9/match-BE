package com.platform.match.domain.constant;

import lombok.Getter;

public enum ClickType {
    APPLICATION("신청 버튼 클릭"),
    SUBMIT("제출 버튼 클릭(성공)");

    @Getter
    private final String description;

    ClickType(String description) {
        this.description = description;
    }

}
