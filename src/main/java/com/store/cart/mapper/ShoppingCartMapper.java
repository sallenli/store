package com.store.cart.mapper;

import com.store.cart.domain.ShoppingCartDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

/**
 * 购物车管理模块的mapper组件
 */
@Mapper
public interface ShoppingCartMapper {
    /**
     * 根据用户账号id查询购物车
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    @Select("select " +
            "id," +
            "user_account_id," +
            "gmt_create," +
            "gmt_modified " +
            "from shopping_cart " +
            "where user_account_id = #{userAccountId}")
    @Results({@Result(column = "id", property = "id",id = true),
              @Result(column = "user_account_id", property = "userAccountId"),
              @Result(column = "gmt_create", property = "gmtCreate"),
              @Result(column = "gmt_modified", property = "gmtModified")})
    ShoppingCartDo getShoppingCartByUserAccountId(@Param("userAccountId") Long userAccountId);

    /**
     * 新增购物车
     * @param shoppingCartDo 购物车do对象
     */
    @Insert("insert into shopping_cart" +
            "(user_account_id," +
            "gmt_create," +
            "gmt_modified)" +
            "values(" +
            "#{userAccountId,jdbcType = BIGINT}," +
            "#{gmtCreate,jdbcType=TIMESTAMP}," +
            "#{gmtModified,jdbcType=TIMESTAMP})")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    long saveShoppingCart(ShoppingCartDo shoppingCartDo);

}
