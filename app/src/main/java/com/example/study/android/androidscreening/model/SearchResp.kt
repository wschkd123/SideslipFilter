package com.example.study.android.androidscreening.model

/**
 * @author shichaowang
 * @date 2019/5/8
 * @describ
 */


data class CategoryFilterResp(
        val attrs: List<SpecAttr>, //规格属性
        val brands: List<String> //商品品牌
)

data class SpecAttr(
        val id: Int, //属性id
        val name: String, //属性名称
        val type: Int, //attrs值的类型，1：枚举 2：用户自己输入
        val values: ArrayList<String>, //属性的具体枚举， 不同type值，格式也不同，
        // 当type为1时，表示格式是字符串数组，数组元素为属性枚举的成员。type为2，表示输入框

        val selectValues: ArrayList<String>
)
