package com.gof.iteration2;

import com.gof.customer.core.DataAPI;
import com.gof.customer.data.TypeOfData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitaliypopov on 13.11.14.
 */
public class AppendDataApiHandler extends BaseDataAPIHandler {

    public static final Map<TypeOfData, String> DEFAULT_DATA_TYPE_MAPPING;
    static {
        Map<TypeOfData, String> map = new HashMap<TypeOfData, String>(4);
        map.put(TypeOfData.LIVE, "1");
        map.put(TypeOfData.PREPARED, "2");
        map.put(TypeOfData.FAKE, "3");
        map.put(TypeOfData.ERR, "4");
        DEFAULT_DATA_TYPE_MAPPING = Collections.unmodifiableMap(map);
    }

    private Map<TypeOfData, String> dataTypeMapping = DEFAULT_DATA_TYPE_MAPPING;

    public AppendDataApiHandler() {
    }

    public AppendDataApiHandler(final Map<TypeOfData, String> dataTypeMapping) {
        this.dataTypeMapping = dataTypeMapping;
    }

    @Override
    public boolean canHandleData(final DataAPI data) {
        return true;
    }

    @Override
    protected DataAPI doHandleData(final DataAPI data) {
        if (null == data) return null;

        TypeOfData typeOfData = data.getTypeOfData();
        if (!dataTypeMapping.containsKey(typeOfData)) {
            throw new IllegalStateException("dataTypeMapping doesn't contain key " + typeOfData);
        }

        String dataFX = data.getDataFX();
        if (null == dataFX) return data;

        String changedData = dataFX + dataTypeMapping.get(typeOfData);
//        System.out.println("changedData" + changedData);
        data.setDataFX(changedData);
        return data;
    }

    public Map<TypeOfData, String> getDataTypeMapping() {
        return dataTypeMapping;
    }

    public void setDataTypeMapping(final Map<TypeOfData, String> dataTypeMapping) {
        this.dataTypeMapping = dataTypeMapping;
    }
}
