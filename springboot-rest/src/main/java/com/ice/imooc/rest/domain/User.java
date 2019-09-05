package com.ice.imooc.rest.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户模型
 *
 * @author : ACE
 * @date : 2019/9/5
 */

@Data(staticConstructor = "of")
@Accessors(chain = true)
public class User {

    private Long id;

    private String name;

}
