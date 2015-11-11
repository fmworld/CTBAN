package com.ctban;

/**
 * Created by zhoufeng'an on 2015/8/4.
 */
public class DBConfig {
    private String sourceDir ="ctblib/src/main/java";
    private int DBVersion =1;
    private String sourceStructure = "com.ctban.ctblib.models.dao";
    public enum TableName{
        User,
        ProductBreviary,
        Inn,
        MyProperty,
        ProductTag,
        CategoryTitle,
        CategoryList,
        LocalTitle,
        LocalList,
        LaunchProfile,
        Product,
        Weather
    }

    public enum WeatherTable{
        city,
        cityid,
        temp
    }

    public enum UserTable{
        account,
        password,
        token,
        islogin,
        role,
        state,
        userMobile,
        innerName,
        innerHead
    }

    public enum InnTable{
        innId,
        innName,
        innProducts,
        innHead,
        innerHead,
        innerScore,
        innerServe,
        innerContact,
        innerMoblie,
        innerIdentify,
        innerTodayServe
    }

    public enum PropertyTable{
        key,
        value,
    }

    public enum TagTable{
        tag_id,
        tag_name,
        item_count,
        item_seq,
        tag_seq
    }

    public enum CategoryTitleTable{
        id,
        name
    }

    public enum CategoryListTable{
        category_id,
        category,
        name
    }

    public enum LocalTitleTable{
        dest_id,
        dest_name
    }

    public enum LocalListTable{
        local_id,
        local_name,
        dest_id
    }

    public enum ProductBreviaryTable{
        product_id,
        state,
        product_name,
        price,
        old_price,
        thumb,
        quantity,
        score,
        tuan_end_time

    }
    public enum LaunchProfileTable{
        type,
        img,
        link,
        tag
    }

    public enum ProductTable{
        product_id,
        state,//
        product_name,//
        price,
        old_price,
        score,
        comments,
        agent,
        shelf_count,//
        content,
        thumb,//
        quantity,//
        bought_count,
        tuan_end_time,//
        category,
        category_id,
        lon,
        lat,
        bdgps,
        on_shelves
    }


    public String getSourceDir() {
        return sourceDir;
    }

    public int getDBVersion() {
        return DBVersion;
    }

    public String getSourceStructure() {
        return sourceStructure;
    }
}
