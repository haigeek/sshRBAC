package common;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * BaseReflectUtils.java @author zzn
 */
public class BaseReflectUtils {
	 public static Class<Object> getSuperClassGenricType(Class<?> clazz){
		 return getSuperClassGenricType(clazz, 0);  
	}
	
	 @SuppressWarnings("unchecked")
	public static Class<Object> getSuperClassGenricType(Class<?> clazz, int index) throws IndexOutOfBoundsException {  
		 Type genType = clazz.getGenericSuperclass();  
		 if (!(genType instanceof ParameterizedType)) {
			 return Object.class;  
		 }  
		   
		 Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		 if (index >= params.length || index < 0) {  
			 return Object.class;  
		 }  
		 if (!(params[index] instanceof Class)) {  
			  return Object.class;  
		 }  
		 return (Class<Object>) params[index];  
		      }  

}
