package com.bestbuy.constant;

public class EndPoint {
    //This is end points for Products
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String CREATE_SINGLE_PRODUCT = "/products";
    public static final String GET_SINGLE_PRODUCTS_BY_ID = "/products/{id}";
    public static final String UPDATE_PRODUCTS_BY_ID = "/products/{id}";
    public static final String DELETE_PRODUCTS_BY_ID = "/products/{id}";


    //This is end points for Stores
    public static final String GET_ALL_STORES = "/stores";
    public static final String CREATE_STORE = "/stores";
    public static final String GET_STORE_BY_ID = "/stores/{id}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{id}";
    public static final String DELETE_STORE_BY_ID = "/stores/{id}";

    //This  end points  for Services
    public static final String GET_ALL_SERVICES = "/services";
    public static final String CREATE_SERVICES = "/services";
    public static final String GET_SERVICES_BY_ID = "/services/{id}";
    public static final String UPDATE_SERVICES_BY_ID = "/services/{id}";
    public static final String DELETE_SERVICES_BY_ID = "/services/{id}";

    //This end points for categories
    public static final String GET_ALL_CATEGORIES = "/categories";
    public static final String CREATE_CATEGORIES = "/categories";
    public static final String GET_CATEGORIES_BY_ID = "/categories/{id}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/categories/{id}";
    public static final String DELETE_CATEGORIES_BY_ID = "/categories/{id}";

}
