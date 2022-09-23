package com.mis.kill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author Li HuiKun
 * @Date 2022/9/19 9:31
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("contour_config")
public class ContourConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    int xSize;
    int ySize;
    String baseUrl;

}
