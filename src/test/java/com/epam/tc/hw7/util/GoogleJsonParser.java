package com.epam.tc.hw7.util;

import com.epam.tc.hw7.entities.MetalColorsEntity;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoogleJsonParser {

    public static Object[][] metalsColorsDataSetParser(String text) {

        Type itemsMapType = new TypeToken<Map<String, MetalColorsEntity>>() {}
            .getType();

        Map<String, MetalColorsEntity> map = new Gson().fromJson(text, itemsMapType);
        List<MetalColorsEntity> list = new ArrayList(map.values());

        MetalColorsEntity[][] arrayOfObjects = new MetalColorsEntity[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            MetalColorsEntity model = list.get(i);
            arrayOfObjects[i][0] = model;
        }
        return arrayOfObjects;
    }
}
