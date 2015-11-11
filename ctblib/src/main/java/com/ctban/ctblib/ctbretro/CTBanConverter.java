/**
 * Created by zhoufeng'an on 2015/9/24.
 */
/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ctban.ctblib.ctbretro;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import retrofit.Converter;

final class CTBanConverter implements Converter {
//    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
//    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Type tarType;
    private Gson gson;
    CTBanConverter( Gson gson, Type tarType) {
        this.gson = gson;
        this.tarType = tarType;
    }

    private String getStream2String(Reader isr){
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(isr);
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
    public Object convert(Object value) throws IOException {
        return null;
    }
}
