package com.gopher.mp.entity.dto;

import lombok.*;

import java.util.Date;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class QueryCompanyAo {
    private String name;
    private Date startDate;
    private Date endDate;
    private String tel;
    private String linkName;
}
