
package com.gopher.common.response;

import com.github.pagehelper.PageInfo;

/**
 * @author aladdin
 */
public class PageUtil {

    public static PageResponse getPageResult(PageInfo<?> pageInfo) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setPageNo(pageInfo.getPageNum());
        pageResponse.setPageSize(pageInfo.getPageSize());
        pageResponse.setTotalSize(pageInfo.getTotal());
        pageResponse.setTotalPages(pageInfo.getPages());
        pageResponse.setData(pageInfo.getList());
        return pageResponse;
    }
}