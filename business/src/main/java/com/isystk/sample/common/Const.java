package com.isystk.sample.common;

/**
 * 定数定義
 */
public interface Const {

	/** ---- Image ---- **/
	String IMAGE_EXTENSION = "jpg";

	/** ---- MDC ---- **/
	String MDC_LOGIN_USER_ID = "LOGIN_USER_ID";

	String MDC_FUNCTION_NAME = "FUNCTION_NAME";

	/** ---- Message ---- **/
	String GLOBAL_SUCCESS_MESSAGE = "GlobalSuccessMessage";

	String GLOBAL_DANGER_MESSAGE = "GlobalDangerMessage";

	String VALIDATION_ERROR = "ValidationError";

	String OPTIMISTIC_LOCKING_FAILURE_ERROR = "OptimisticLockingFailureError";

	String DOUBLE_SUBMIT_ERROR = "DoubleSubmitError";

	String NO_DATA_FOUND_ERROR = "NoDataFoundError";

	String UNEXPECTED_ERROR = "UnexpectedError";

	String MESSAGE_DELETED = "Deleted";

	String MESSAGE_SUCCESS = "Success";

	/** ---- View ---- **/
	String ERROR_VIEW = "/error/500.html";

	String NOTFOUND_VIEW = "/error/404.html";

	String FORBIDDEN_VIEW = "/error/403.html";

	/** ---- ViewComponents ---- **/
	String MAV_CONST = "Const";

	String MAV_ERRORS = "errors";

	String MAV_PULLDOWN_OPTION = "PulldownOption";

	String MAV_LOGIN_USER = "LoginUser";

//    String MAV_CODE_CATEGORIES = "CodeCategories";

	/** ---- URLs ---- **/
	String ERROR_URL = "/error";

	String FORBIDDEN_URL = "/forbidden";

	String LOGIN_URL = "/login";

	String LOGIN_PROCESSING_URL = "/authenticate";

	String LOGIN_SUCCESS_URL = "/loginSuccess";

	String LOGIN_FAILURE_URL = "/loginFailure";

	String LOGIN_TIMEOUT_URL = "/loginTimeout";

	String RESET_PASSWORD_URL = "/resetPassword";

	String CHANGE_PASSWORD_URL = "/changePassword";

	String LOGOUT_URL = "/logout";

	String LOGOUT_SUCCESS_URL = "/logoutSuccess";

	String WEBJARS_URL = "/webjars/**";

	String STATIC_RESOURCES_URL = "/static/**";

}
