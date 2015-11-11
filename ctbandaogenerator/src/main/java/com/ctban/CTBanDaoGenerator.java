package com.ctban;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;

public class CTBanDaoGenerator {

    public static void main(String[] args) throws Exception {
//        testTourServerApi();
        initDataFile();
    }

    private static void testTourServerApi() {
        DBTest tourTest = new DBTest();
//        tourTest.changePassword();
    }

    private static void initDataFile() {
        DBConfig dbConfig = new DBConfig();
        Schema schema = new Schema(dbConfig.getDBVersion(), dbConfig.getSourceStructure());

        DbTableBuilder dbTableBuilder = new DbTableBuilder(schema);
        addUser(dbTableBuilder);

        addInn(dbTableBuilder);

        addProperty(dbTableBuilder);

        addTag(dbTableBuilder);

        addCategoryTitle(dbTableBuilder);

        addCategoryList(dbTableBuilder);

        addLocalTitle(dbTableBuilder);

        addLocalList(dbTableBuilder);

        addProductBreviaryTable(dbTableBuilder);

        addDeviceAdd(dbTableBuilder);

        addProduct(dbTableBuilder);

        addWeather(dbTableBuilder);

        try {
            new DaoGenerator().generateAll(schema, dbConfig.getSourceDir());
        } catch (Exception e) {
        }

    }


    public static void addTag(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.ProductTag.toString())
                .addIdProperty()
                .addStringPropertyNotNull(DBConfig.TagTable.tag_id.toString())
                .addStringPropertyNotNull(DBConfig.TagTable.tag_name.toString())
                .addStringProperty(DBConfig.TagTable.item_count.toString())
                .addStringProperty(DBConfig.TagTable.item_seq.toString())
                .addStringProperty(DBConfig.TagTable.tag_seq.toString())
                .build();

    }

    public static void addUser(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.User.toString())
                .addIdProperty()
                .addStringPropertyNotNull(DBConfig.UserTable.account.toString())
                .addStringPropertyNotNull(DBConfig.UserTable.password.toString())
                .addBooleanProperty(DBConfig.UserTable.islogin.toString())
                .addStringProperty(DBConfig.UserTable.token.toString())
                .addStringProperty(DBConfig.UserTable.role.toString())
                .addStringProperty(DBConfig.UserTable.state.toString())
                .addStringProperty(DBConfig.UserTable.userMobile.toString())
                .addStringProperty(DBConfig.UserTable.innerHead.toString())
                .addStringProperty(DBConfig.UserTable.innerName.toString())
                .build();
    }

    public static void addInn(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.Inn.toString())
                .addIdProperty()
                .addStringProperty(DBConfig.InnTable.innId.toString())
                .addStringProperty(DBConfig.InnTable.innerContact.toString())
                .addStringProperty(DBConfig.InnTable.innerHead.toString())
                .addStringProperty(DBConfig.InnTable.innerIdentify.toString())
                .addStringProperty(DBConfig.InnTable.innerMoblie.toString())
                .addStringProperty(DBConfig.InnTable.innerScore.toString())
                .addStringProperty(DBConfig.InnTable.innerServe.toString())
                .addStringProperty(DBConfig.InnTable.innerTodayServe.toString())
                .addStringProperty(DBConfig.InnTable.innHead.toString())
                .addStringProperty(DBConfig.InnTable.innProducts.toString())
                .addStringProperty(DBConfig.InnTable.innName.toString())
                .build();
    }

    public static void addProperty(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.MyProperty.toString())
                .addIdProperty()
                .addStringPropertyNotNull(DBConfig.PropertyTable.key.toString())
                .addStringProperty(DBConfig.PropertyTable.value.toString())
                .build();
    }

    public static void addCategoryTitle(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.CategoryTitle.toString())
                .addStringPropertyNotNull(DBConfig.CategoryTitleTable.id.toString())
                .addStringProperty(DBConfig.CategoryTitleTable.name.toString())
                .build();
    }

    public static void addCategoryList(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.CategoryList.toString())
                .addStringPropertyNotNull(DBConfig.CategoryListTable.category.toString())
                .addStringPropertyNotNull(DBConfig.CategoryListTable.category_id.toString())
                .addStringPropertyNotNull(DBConfig.CategoryListTable.name.toString())
                .build();
    }

    public static void addLocalTitle(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.LocalTitle.toString())
                .addStringPropertyNotNull(DBConfig.LocalTitleTable.dest_id.toString())
                .addStringPropertyNotNull(DBConfig.LocalTitleTable.dest_name.toString())
                .build();
    }

    public static void addLocalList(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.LocalList.toString())
                .addStringPropertyNotNull(DBConfig.LocalListTable.dest_id.toString())
                .addStringPropertyNotNull(DBConfig.LocalListTable.local_id.toString())
                .addStringPropertyNotNull(DBConfig.LocalListTable.local_name.toString())
                .build();
    }

    public static void addProductBreviaryTable(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.ProductBreviary.toString())
                .addStringPropertyNotNull(DBConfig.ProductBreviaryTable.product_id.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.price.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.old_price.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.product_name.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.quantity.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.score.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.state.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.thumb.toString())
                .addStringProperty(DBConfig.ProductBreviaryTable.tuan_end_time.toString())
                .build();
    }

    public static void addDeviceAdd(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.LaunchProfile.toString())
                .addStringPropertyNotNull(DBConfig.LaunchProfileTable.img.toString())
                .addStringProperty(DBConfig.LaunchProfileTable.link.toString())
                .addStringProperty(DBConfig.LaunchProfileTable.tag.toString())
                .addStringProperty(DBConfig.LaunchProfileTable.type.toString())
                .build();
    }


    public static void addProduct(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.Product.toString())
                .addStringPropertyNotNull(DBConfig.ProductTable.product_id.toString())
                .addStringProperty(DBConfig.ProductTable.agent.toString())
                .addStringProperty(DBConfig.ProductTable.bdgps.toString())
                .addStringProperty(DBConfig.ProductTable.bought_count.toString())
                .addStringProperty(DBConfig.ProductTable.category.toString())
                .addStringProperty(DBConfig.ProductTable.category_id.toString())
                .addStringProperty(DBConfig.ProductTable.comments.toString())
                .addStringProperty(DBConfig.ProductTable.content.toString())
                .addStringProperty(DBConfig.ProductTable.lat.toString())
                .addStringProperty(DBConfig.ProductTable.lon.toString())
                .addStringProperty(DBConfig.ProductTable.old_price.toString())
                .addStringProperty(DBConfig.ProductTable.on_shelves.toString())
                .addStringProperty(DBConfig.ProductTable.price.toString())
                .addStringProperty(DBConfig.ProductTable.score.toString())
                .addStringProperty(DBConfig.ProductTable.product_name.toString())
                .addStringProperty(DBConfig.ProductTable.state.toString())
                .addStringProperty(DBConfig.ProductTable.shelf_count.toString())
                .addStringProperty(DBConfig.ProductTable.thumb.toString())
                .addStringProperty(DBConfig.ProductTable.quantity.toString())
                .addStringProperty(DBConfig.ProductTable.tuan_end_time.toString())
                .build();
    }

    public static void addWeather(DbTableBuilder dbTableBuilder){
        dbTableBuilder.prepareTable(DBConfig.TableName.Weather.toString())
                .addStringPropertyNotNull(DBConfig.WeatherTable.cityid.toString())
                .addStringProperty(DBConfig.WeatherTable.city.toString())
                .addStringProperty(DBConfig.WeatherTable.temp.toString())
                .build();
    }



}
