package tabesto.testing.enums;

public enum PathEndPoint {
    LOGIN_CHECK("/login_check"),
    LOGIN("/login"),
    OAUTH("/api/user/user/new"),
    MENU_AVAILABILITY("/cache/menu-availability"),
    ADD_CATEGORY("/menu/category/new?menuId="),
    ADD_NEW_PRODUCT("/menu/food/new"),
    GET_ALL_CATEGORIES("/api/sections/get?selectedMenu=_all&_="),
    GET_LIST_CATEGORY("/menu/category/list"),
    ADD_CUSTOM_PRODUCT_PARENT("/menu/customProduct/new"),
    EDIT_CUSTOM_PRODUCT_PARENT("/menu/customProduct/menuChoice/editProduct/"),
    EDIT_AVAILABILITY("/menu/food/availability/edit"),
    GET_ALL_PRODUCTS("/api/repository/get?selectedMenu=_all&_="),
    GET_OPTION("/menu/food/paramtype/new"),
    GET_EDIT_ACTIVE_CARD("/menus/edit/"),
    GET_LIST_MENU("/menus/list"),
    OCA_SELLER("/api/v1/seller/"),
    GET_EDIT_CARD("/menus/edit/"),
    GET_LIST_CUSTOM_PRODUCTS("/api/customproduct/get?selectedMenu=_all&_="),;


    public final String url;

    PathEndPoint(String url) {
        this.url =  url;
    }

}
