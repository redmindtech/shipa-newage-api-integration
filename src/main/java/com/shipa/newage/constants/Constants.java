package com.shipa.newage.constants;

/**
 * @author SureshKumar
 * 12-Sep-2023
 */

public class Constants {

	public static final String AUDITOR_AWARE = "auditorAware";
	public static final String DEFAULT_AUDITOR_NAME = "Admin";
	public static final String GENERIC_EXCEPTION_MESSAGE = "Exception occured, please check";
	public static final String COMMON_RESPONSE_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
	public static final String COMMON_RESPONSE_CREATION_DATE = "creationDate";
	public static final String COMMON_RESPONSE_LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String COMMON_NOT_FOUND = "Unable to find the record";
	public static final String COMMON_TEMPLATE_ID_NOT_FOUND = "Unable to find template details, please check.";
	public static final String SHIPA_ORDERS_BULK_POST_URL = "/orders/bulk?apikey={apikey}";
	public static final String SHIPA_ORDERS_GET_PDF = "/orders/{orderId}/pdf?orderId={orderId}&apikey={apikey}";
	public static final String SHIPA_API_STATUS_AWB_CREATED = "AWB_Created";
	public static final String SHIPA_API_STATUS_PDFB_GENERATED = "PDF_Generated";
	public static final String SHIPA_API_PARAM1_ORDER_ID = "orderId";
	public static final String SHIPA_API_PARAM2_API_KEY = "apikey";
	public static final String SHIPA_ORDERS_GET_STORY = "/orders/{orderId}/story?apikey={apikey}";
	public static final String SHIPA_GENERIC_SUCCESS_MESSAGE = "Success";
	public static final String SHIPA_ASYNC_THREAD_POOL_NAME = "threadPoolTaskExecutor";
	public static final String SHIPA_ASYNC_THREAD_NAME_PREFIX = "Async-";

}