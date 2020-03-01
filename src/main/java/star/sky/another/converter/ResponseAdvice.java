package star.sky.another.converter;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import star.sky.another.model.entity.BaseEntity;
import star.sky.another.view.BaseView;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/18 9:50
 **/
@RestControllerAdvice(basePackages = {"star.sky.another"})
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof BaseEntity) {
            RestResult<BaseEntity> restResult = new RestResult<>();
            restResult.setCode("200");
            restResult.setData((BaseEntity) body);
            return restResult;
        } else if (body instanceof BaseView) {
            RestResult<BaseView> restResult = new RestResult<>();
            restResult.setCode("200");
            restResult.setData((BaseView) body);
            return restResult;
        }
        return body;
    }
}
