package com.store.commodity.mapper;

import com.store.commodity.domain.PropertyQuery;
import org.apache.ibatis.jdbc.SQL;

public class PropertySelectProvider {

    public SQL getSelectSQL(final PropertyQuery propertyQuery) {

        return new SQL();
    }
}