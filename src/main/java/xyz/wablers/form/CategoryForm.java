package xyz.wablers.form;

import lombok.Data;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/13 16:04
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
