package com.gopher.zkd1.entity.ao;

import lombok.*;

import javax.validation.constraints.NotNull;


/**
 * @author 6c6763
 * @date 2020/10/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class ModifyCompanyAo extends InsertCompanyAo {
    @NotNull(message = "企业编号不能为空")
    private Long id;
}
