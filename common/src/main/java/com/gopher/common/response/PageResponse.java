package com.gopher.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页返回结果
 * @author aladdin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> implements Serializable {
    private static final long serialVersionUID = -9114036876246324067L;
    /**
     * 当前页码
     */
    private int pageNo;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * data
     */
    private T data;

}