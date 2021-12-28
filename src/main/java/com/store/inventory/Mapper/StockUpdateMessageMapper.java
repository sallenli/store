package com.store.inventory.Mapper;

import com.store.inventory.domain.StockUpdateMessageDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 离线存储库存更新消息组件
 */
@Mapper
public interface StockUpdateMessageMapper {

    /**
     * 新增库存消息
     * @param stockUpdateMessageDo 库存更新消息do对象
     */
    @Insert("insert into " +
            "inventory_offline_stock_update_message "  +
            "(message_id," +
            "operation," +
            "parameter," +
            "parameter_clazz,"+
            "gmt_create," +
            "gmt_modified)  " +
            "values(" +
            "#{messageId}," +
            "#{operation}," +
            "#{parameter}," +
            "#{parameterClazz},"+
            "#{gmtCreate}," +
            "#{gmtModified})")
    @Options(keyColumn = "id",keyProperty = "id",useGeneratedKeys = true)
    void saveOfflineStockUpdateMessage(StockUpdateMessageDo stockUpdateMessageDo);

    /**
     * 批量查询库存更新消息，每次50条
     * @return 库存更新消息do对象集合
     */
    @Select("select " +
            "id," +
            "message_id," +
            "operation," +
            "parameter," +
            "parameter_clazz,"+
            "gmt_create," +
            "gmt_modified" +
            " from inventory_offline_stock_update_message " +
            "order by id " +
            "limit 50")
     @Results({
             @Result(column = "id",property = "id",id = true),
             @Result(column = "message_id",property = "messageId"),
             @Result(column = "operation",property = "operation"),
             @Result(column = "parameter",property = "parameter"),
             @Result(column = "parameter_clazz",property = "parameterClazz"),
             @Result(column = "gmt_create",property = "gmtCreate"),
             @Result(column = "gmt_modified",property ="gmtModified")})
    List<StockUpdateMessageDo> listByBatch();

    /**
     * 批量删除库存更新消息
     * @param messageIds 库存更新消息id
     */
    @Delete("delete from inventory_offline_stock_update_message " +
            "where  message_id in (${messageIds})")
    void removeByBatch(@Param("messageId") String messageIds);

    /**
     * 查询库存更新消息记录数
     * @return
     */
    @Select("select count(*) from inventory_offline_stock_update_message")
    Long count();
}
