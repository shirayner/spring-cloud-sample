package com.ray.study.smaple.springcloud.feign.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserDto
 *
 * @author ray
 * @date 2020/6/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private Integer age;

    private Date creationDate;

    private Date lastUpdateDate;

}
