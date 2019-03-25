package com.social.base;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author alvis
 */
public class BasePage {
    private Integer pageIndex;

    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
