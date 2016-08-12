package com.tandong.iknowbox.common.exception.api;

import java.util.Locale;

/**
 * 负责对外提供国际化消息处理的统一访问接口，
 * 完成由异常代码、参数、自定义消息、区域等数据至本地化消息文本的转换
 * 
 * @author TanDong
 *
 */
public interface ExceptionResolver {

	String getMessage(String code, Locale locale, Object[] args);

}
